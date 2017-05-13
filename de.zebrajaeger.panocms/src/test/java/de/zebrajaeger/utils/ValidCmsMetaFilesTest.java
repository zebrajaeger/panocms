package de.zebrajaeger.utils;

import org.apache.commons.io.IOUtils;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeDiagnosingMatcher;
import org.junit.Test;
import org.opencms.util.CmsUUID;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;
import java.net.URI;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;

import static org.hamcrest.Matchers.hasXPath;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assume.assumeThat;

public class ValidCmsMetaFilesTest {

  private static final String SRC_MAIN_MANIFEST = "src/main/opencms/manifest";

  @Test
  public void filesAreValid() throws Exception {
    Path start = Paths.get(new URI(getProjectBasePath() + SRC_MAIN_MANIFEST)).toAbsolutePath();
    assumeThat(Files.exists(start), is(true));

    Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        if (file.toAbsolutePath().toString().endsWith("ocmsfolder.xml")) {
          Document document = loadXml(file);
          assertValidMetaFolder(file, document);
        }

        if (file.toAbsolutePath().toString().endsWith("ocmsfile.xml")) {
          Document document = loadXml(file);
          assertValidMetaFile(file, document);
        }

        return FileVisitResult.CONTINUE;
      }
    });
  }

  @Test
  public void filesHaveUniqueUUIDs() throws Exception {
    Path start = Paths.get(new URI(getProjectBasePath() + SRC_MAIN_MANIFEST)).toAbsolutePath();
    assumeThat(Files.exists(start), is(true));

    final Map<String, String> uuidstructure = new HashMap<>();

    Files.walkFileTree(start, new SimpleFileVisitor<Path>() {
      @Override
      public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {

        Document document = null;
        if (file.toAbsolutePath().toString().endsWith("ocmsfolder.xml")) {
          document = loadXml(file);
        }

        if (file.toAbsolutePath().toString().endsWith("ocmsfile.xml")) {
          document = loadXml(file);
        }

        if (document != null) {
          assertUniqueElement(uuidstructure, document, file, "uuidstructure");
        }

        return FileVisitResult.CONTINUE;
      }
    });
  }

  private void assertUniqueElement(Map<String, String> uuids, Document document, Path file, String element) {
    String reason = file.toAbsolutePath().toString();

    try {

      XPath xPath = XPathFactory.newInstance().newXPath();
      String uuid = xPath.evaluate("/fileinfo/file/" + element, document);

      if (uuid != null && uuid.length() > 0) {
        String previous = uuids.get(uuid);
        assertThat("No two files with same " + element + ": '" + uuid + "' " + reason, previous, nullValue());

        uuids.put(uuid, reason);
      }

    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

  protected void assertValidMetaFile(Path file, Document document) {
    String reason = file.toAbsolutePath().toString();
    assertThat(reason, document, hasXPath("/fileinfo/file/uuidstructure", is(validUUID())));
    assertThat(reason, document, hasXPath("/fileinfo/file/uuidresource", is(validUUID())));
    assertThat(reason, document, hasXPath("/fileinfo/file/datelastmodified", is("${datelastmodified}")));
    assertThat(reason, document, hasXPath("/fileinfo/file/datecreated", is("${datecreated}")));
  }

  protected void assertValidMetaFolder(Path file, Document document) {
    String reason = file.toAbsolutePath().toString();
    assertThat(reason, document, hasXPath("/file/uuidstructure", is(validUUID())));
    assertThat(reason, document, hasXPath("/file/datelastmodified", is("${datelastmodified}")));
    assertThat(reason, document, hasXPath("/file/datecreated", is("${datecreated}")));
  }

  protected Document loadXml(Path file) throws IOException {
    try {
      String xml = IOUtils.toString(Files.newInputStream(file));

      DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
      factory.setFeature("http://apache.org/xml/features/nonvalidating/load-dtd-grammar", false);
      factory.setFeature("http://apache.org/xml/features/nonvalidating/load-external-dtd", false);
      DocumentBuilder documentBuilder = factory.newDocumentBuilder();

      return documentBuilder.parse(new InputSource(new StringReader(xml)));
    } catch (Exception e) {
      throw new IOException(e);
    }
  }

  private static Matcher<String> validUUID() {
    return new TypeSafeDiagnosingMatcher<String>() {
      @Override
      protected boolean matchesSafely(String item, Description mismatchDescription) {
        boolean validUUID = CmsUUID.isValidUUID(item);

        if (!validUUID) {
          mismatchDescription.appendText("no valid UUID ").appendValue(item).appendText(" ");
        }

        return validUUID;
      }

      @Override
      public void describeTo(Description description) {

      }
    };
  }

  private String getProjectBasePath() {
    try {
      URI mavenTargetFolder = getClass().getResource("/").toURI();
      return mavenTargetFolder.toString() + "../../";
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }

}
