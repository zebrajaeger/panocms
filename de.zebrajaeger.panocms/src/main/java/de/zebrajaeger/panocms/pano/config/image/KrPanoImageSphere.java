package de.zebrajaeger.panocms.pano.config.image;

import javax.xml.bind.annotation.XmlAttribute;
import java.net.URL;

/**
 * @author Lars Brandt
 */
public class KrPanoImageSphere {
    @XmlAttribute
    private URL url;

    @XmlAttribute
    private String mapping;

    @XmlAttribute
    private String mjpegstream;
}
