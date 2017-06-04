package de.zebrajaeger.panocms.pano.config.image;

import javax.xml.bind.annotation.XmlAttribute;
import java.net.URL;

/**
 * @author Lars Brandt
 */
public class KrPanoImageFisheye {
    @XmlAttribute
    private URL url;
    @XmlAttribute
    private Double fov;
    /**
     * yaw, pitch, roll
     */
    @XmlAttribute
    private String align;
    /**
     * left,right,top,button
     */
    @XmlAttribute
    private String crop;
    /**
     * a,b,c,d,e
     */
    @XmlAttribute
    private String lenscp;
    @XmlAttribute
    private String mjpegstream;

}
