package de.zebrajaeger.panocms.pano.config;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Lars Brandt
 */
public class KrPanoEvents {
    @XmlAttribute
    private String enterfullscreen;
    @XmlAttribute
    private String exitfullscreen;
    @XmlAttribute
    private String xmlcomplete;
    @XmlAttribute
    private String previewcomplete;
    @XmlAttribute
    private String loadcomplete;
    @XmlAttribute
    private String newpano;
    @XmlAttribute
    private String removepano;
    @XmlAttribute
    private String newscene;
    @XmlAttribute
    private String loaderror;
    @XmlAttribute
    private String keydown;
    @XmlAttribute
    private String keyup;
    @XmlAttribute
    private String click;
    @XmlAttribute
    private String singleclick;
    @XmlAttribute
    private String doubleclick;
    @XmlAttribute
    private String mousedown;
    @XmlAttribute
    private String mouseup;
    @XmlAttribute
    private String mousewheel;
    @XmlAttribute
    private String contextmenu;
    @XmlAttribute
    private String idle;
    @XmlAttribute
    private String viewchange;
    @XmlAttribute
    private String viewchanged;
    @XmlAttribute
    private String resize;
    @XmlAttribute
    private String autorotatestart;
    @XmlAttribute
    private String autorotatestop;
    @XmlAttribute
    private String autorotateoneround;
    @XmlAttribute
    private String autorotatechange;
}
