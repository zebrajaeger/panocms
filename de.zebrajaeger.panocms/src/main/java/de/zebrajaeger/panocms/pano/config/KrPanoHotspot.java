package de.zebrajaeger.panocms.pano.config;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Lars Brandt
 */
public class KrPanoHotspot {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String url;
    @XmlAttribute
    private Boolean keep;
    @XmlAttribute
    private Boolean visible;
    @XmlAttribute
    private Boolean enabled;
    @XmlAttribute
    private Boolean handcursor;
    @XmlAttribute
    private Boolean maskchildren;
    @XmlAttribute
    private String zorder;
    @XmlAttribute
    private String style;
    @XmlAttribute
    private Double ath;
    @XmlAttribute
    private Double atv;
    @XmlAttribute
    private String edge;
    @XmlAttribute
    private Boolean zoom;
    @XmlAttribute
    private Boolean distorted;
    @XmlAttribute
    private Double rx;
    @XmlAttribute
    private Double ry;
    @XmlAttribute
    private Double rz;
    @XmlAttribute
    private String width;
    @XmlAttribute
    private String height;
    @XmlAttribute
    private Double scale;
    @XmlAttribute
    private Double rotate;
    @XmlAttribute
    private Double alpha;

    @XmlAttribute(name = "onover")
    private String onOver;
    @XmlAttribute(name = "onhover")
    private String onHover;
    @XmlAttribute(name = "onout")
    private String onOut;
    @XmlAttribute(name = "onclick")
    private String onClick;
    @XmlAttribute(name = "ondown")
    private String onDown;
    @XmlAttribute(name = "onup")
    private String onUp;
    @XmlAttribute(name = "onloaded")
    private String onLoaded;
}
