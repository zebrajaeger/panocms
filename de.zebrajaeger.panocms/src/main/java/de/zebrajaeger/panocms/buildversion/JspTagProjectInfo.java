package de.zebrajaeger.panocms.buildversion;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Writes out the project info to identify the version.
 *
 * @author Lars Brandt on 28.07.2016
 */
public class JspTagProjectInfo extends TagSupport {

    private static final String LF = "\n";

    public int doStartTag() throws JspException {
        try {
            pageContext.getOut().append(generateContent());
        } catch (Exception e) {
            throw new JspException(e.getMessage());
        }
        return EVAL_PAGE;
    }

    /**
     * adds a span with title and property to stringbuffer
     *
     * @param content the target
     * @param title   title to identify on webpage
     * @param value   type of value
     */
    private void addValue(Appendable content, String title, BuildVersion.GitKey value) throws IOException {
        BuildVersion v = BuildVersion.instance();
        content.append(title).append(": ").append(v.get(value));
    }

    /**
     * generates the content for projectinfo
     */
    private String generateContent() throws IOException {
        StringBuilder result = new StringBuilder();
        result.append("\nHOST: ").append(getHostId()).append(LF);
        result.append("##### COMMON ####").append(LF);

        addValue(result, "BRANCH", BuildVersion.GitKey.BRANCH);
        result.append(LF);

        addValue(result, "TAGS", BuildVersion.GitKey.TAGS);
        result.append(LF);

        result.append("##### BUILD ####").append(LF);

        addValue(result, "BUILD_TIME", BuildVersion.GitKey.BUILD_TIME);
        result.append(LF);

        addValue(result, "BUILD_USER_EMAIL", BuildVersion.GitKey.BUILD_USER_EMAIL);
        result.append(LF);

        result.append("##### COMMIT ####").append(LF);

        addValue(result, "COMMIT_ID_DESCRIBE_SHORT", BuildVersion.GitKey.COMMIT_ID_DESCRIBE_SHORT);
        result.append(LF);

        addValue(result, "COMMIT_ID", BuildVersion.GitKey.COMMIT_ID);
        result.append(LF);

        addValue(result, "COMMIT_TIME", BuildVersion.GitKey.COMMIT_TIME);
        result.append(LF);

        result.append("SCHEME").append(": ").append(pageContext.getRequest().getScheme());
        result.append(LF);

        result.append("SERVERNAME").append(": ").append(pageContext.getRequest().getServerName());
        result.append(LF);

        result.append("PORT").append(": ").append(Integer.toString(pageContext.getRequest().getServerPort()));
        result.append(LF);

        release();

        return result.toString();
    }

    public static String getHostId() {
        String result = "unknown";
        try {
            String hostName = InetAddress.getLocalHost().getHostName();
            String[] parts = hostName.split("\\.");
            if (parts.length > 0) {
                result = parts[0];
            }
        } catch (UnknownHostException e) {
            return "unknown(" + e.getMessage() + ")";
        }
        return result;
    }
}
