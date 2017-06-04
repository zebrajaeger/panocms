package de.zebrajaeger.panocms.pano.config;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlValue;

/**
 * @author Lars Brandt
 */
public class KrPanoAction {
    @XmlAttribute
    private String name;

    @XmlAttribute
    private String type;

    @XmlValue
    private String content;
}
