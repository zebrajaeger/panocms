package de.zebrajaeger.panocms.pano.config;

import javax.xml.bind.annotation.XmlAttribute;

/**
 * @author Lars Brandt
 */
public class KrPanoAutorotate {
    @XmlAttribute
    private boolean enabled;
    @XmlAttribute
    private double waittime;
    @XmlAttribute
    private double speed;
}
