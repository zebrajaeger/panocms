package de.zebrajaeger.panocms.pano;

import com.google.common.base.Charsets;
import com.google.gson.Gson;
import org.apache.commons.io.FileUtils;

import javax.xml.bind.JAXB;
import java.io.File;
import java.io.IOException;

/**
 * @author Lars Brandt
 */
public class PanoUtils {
    public static KrPanoConfig findConfig(File panoRoot) {
        for (File f : panoRoot.listFiles()) {
            if (f.isFile() && f.getName().toLowerCase().endsWith(".xml")) {
                return JAXB.unmarshal(f, KrPanoConfig.class);
            }
        }
        return null;
    }

    public static PanoDescriptor findDescriptor(File panoRoot) throws IOException {
        for (File f : panoRoot.listFiles()) {
            if (f.isFile() && f.getName().toLowerCase().equals("descriptor.xml")) {
                return JAXB.unmarshal(f, PanoDescriptor.class);
            } else if (f.isFile() && f.getName().toLowerCase().equals("descriptor.json")) {
                String json = FileUtils.readFileToString(f, Charsets.UTF_8);
                return new Gson().fromJson(json, PanoDescriptor.class);
            }
        }
        return null;
    }
}
