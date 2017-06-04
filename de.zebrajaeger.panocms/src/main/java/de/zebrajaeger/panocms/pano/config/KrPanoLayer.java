package de.zebrajaeger.panocms.pano.config;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Lars Brandt
 */
public class KrPanoLayer {
    @XmlAttribute
    private String name;
    @XmlAttribute
    private String type;
    @XmlAttribute
    private String url;
    @XmlAttribute
    private Boolean keep;
    @XmlAttribute
    private String parent;
    @XmlAttribute
    private Boolean visible;
    @XmlAttribute
    private Boolean enabled;
    @XmlAttribute(name = "handcursor")
    private Boolean handCursor;
    @XmlAttribute(name = "maskchildren")
    private Boolean maskChildren;
    @XmlAttribute(name = "scalechildren")
    private Boolean scaleChildren;
    @XmlAttribute
    private String zorder;
    @XmlAttribute
    private String style;
    @XmlAttribute
    private String align;
    @XmlAttribute
    private String edge;
    @XmlAttribute
    private String x;
    @XmlAttribute
    private String y;
    @XmlAttribute
    private String rotate;
    @XmlAttribute
    private String width;
    @XmlAttribute
    private String height;
    @XmlAttribute
    private String scale;
    @XmlAttribute
    private String alpha;
    @XmlAttribute
    private String crop;
    @XmlAttribute(name = "onovercrop")
    private String onOvercrop;
    @XmlAttribute(name = "ondowncrop")
    private String onDowncrop;
    @XmlAttribute
    private String bgcolor;
    @XmlAttribute
    private String bgalpha;
    @XmlAttribute
    private String bgborder;
    @XmlAttribute
    private String bgroundedge;
    @XmlAttribute
    private String bgshadow;
    @XmlAttribute
    private Boolean bgcapture;
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
