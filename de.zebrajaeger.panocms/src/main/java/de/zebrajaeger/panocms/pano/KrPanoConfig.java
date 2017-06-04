package de.zebrajaeger.panocms.pano;

import de.zebrajaeger.panocms.pano.config.KrPanoAction;
import de.zebrajaeger.panocms.pano.config.KrPanoAutorotate;
import de.zebrajaeger.panocms.pano.config.KrPanoEvents;
import de.zebrajaeger.panocms.pano.config.KrPanoHotspot;
import de.zebrajaeger.panocms.pano.config.KrPanoImage;
import de.zebrajaeger.panocms.pano.config.KrPanoInclude;
import de.zebrajaeger.panocms.pano.config.KrPanoLayer;
import de.zebrajaeger.panocms.pano.config.KrPanoPlugin;
import de.zebrajaeger.panocms.pano.config.KrPanoPreview;
import de.zebrajaeger.panocms.pano.config.KrPanoView;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * @author Lars Brandt
 */
@XmlRootElement(name = "krpano")
public class KrPanoConfig {

    @XmlAttribute
    private String version;
    @XmlAttribute(name = "ispartialpano")
    private boolean isPartialPano;
    @XmlAttribute(name = "ionstart")
    private String onStart;

    @XmlElement(name = "include")
    private List<KrPanoInclude> inc;
    @XmlElement
    private KrPanoPreview preview;
    @XmlElement
    private KrPanoImage image;
    @XmlElement
    private KrPanoView view;
    @XmlElement
    private KrPanoAutorotate autorotate;
    @XmlElement
    private KrPanoPlugin plugin;
    @XmlElement
    private KrPanoLayer layer;
    @XmlElement
    private KrPanoHotspot hotspot;
    @XmlElement
    private KrPanoEvents events;
    @XmlElement
    private KrPanoAction action;
    @XmlElement
    private KrPanoAction KrPanoScene;
}
