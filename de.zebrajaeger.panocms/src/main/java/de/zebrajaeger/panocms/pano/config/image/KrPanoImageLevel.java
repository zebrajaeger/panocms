package de.zebrajaeger.panocms.pano.config.image;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Lars Brandt
 */
public class KrPanoImageLevel {
    /**
     * CUBE, SPHERE, CYLINDER, FLAT
     */
    @XmlAttribute
    private String tiledimagewidth;
    /**
     * CUBE, SPHERE, CYLINDER, FLAT
     */
    @XmlAttribute
    private String tiledimageheight;
    /**
     * CUBE, SPHERE, CYLINDER, FLAT
     */
    @XmlAttribute
    private String tilesize;
    /**
     * FLAT
     */
    @XmlAttribute
    private String download;
    /**
     * FLAT
     */
    @XmlAttribute
    private String decode;
    /**
     * CUBE, SPHERE, CYLINDER, FLAT
     */
    @XmlAttribute
    private Boolean aspreview;

    /**
     * CUBE
     */
    @XmlElement
    private KrPanoImageCube cube;
    /**
     * SPHERE, VIDEO
     */
    @XmlElement
    private KrPanoImageSphere sphere;
    /**
     * CYLINDER, FLAT
     */
    @XmlElement
    private KrPanoImageCylinder cylinder;
}
