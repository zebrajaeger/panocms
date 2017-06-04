package de.zebrajaeger.panocms.pano.config;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Lars Brandt
 */
public class KrPanoView {
    @XmlAttribute(name = "hlookat")
    private double hLookat;
    @XmlAttribute(name = "vlookat")
    private double vLookat;
    @XmlAttribute
    private double fov;
    @XmlAttribute(name = "fovmin")
    private double fovMin;
    @XmlAttribute(name = "fovmax")
    private double fovMax;
    @XmlAttribute(name = "maxpixelzoom")
    private double maxPixelZoom;
    @XmlAttribute(name = "limitview")
    private double limitView;
}
