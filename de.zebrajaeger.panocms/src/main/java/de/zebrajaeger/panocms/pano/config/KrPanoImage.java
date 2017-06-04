package de.zebrajaeger.panocms.pano.config;

import de.zebrajaeger.panocms.pano.config.image.KrPanoImageCube;
import de.zebrajaeger.panocms.pano.config.image.KrPanoImageCubestrip;
import de.zebrajaeger.panocms.pano.config.image.KrPanoImageCylinder;
import de.zebrajaeger.panocms.pano.config.image.KrPanoImageFisheye;
import de.zebrajaeger.panocms.pano.config.image.KrPanoImageLevel;
import de.zebrajaeger.panocms.pano.config.image.KrPanoImageSphere;
import de.zebrajaeger.panocms.pano.config.image.KrPanoImageType;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

/**
 * @author Lars Brandt
 */
public class KrPanoImage {
    /**
     * CUBE = CUBE
     * CUBESTRIP = CUBESTRIP
     * SPHERE = SPHERE
     * CYLINDER = CYLINDER
     * FISHEYE = null
     * FLAT = CYLINDER
     * VIDEO = SPHERE
     */
    @XmlAttribute
    private KrPanoImageType type;

    /**
     * CUBE, CUBE(multires),
     * SPHERE, SPHERE(multires),
     * CYLINDER, CYLINDER(multires)
     * FLAT, FLAT(multires)
     * VIDEO
     */
    @XmlAttribute
    private Character prealign;

    /**
     * SPHERE, SPHERE(multires)
     * CYLINDER, CYLINDER(multires)
     * FLAT,
     * VIDEO
     */
    @XmlAttribute(name = "hfov")
    private Double hFov;
    /**
     * SPHERE, SPHERE(multires)
     * CYLINDER, CYLINDER(multires)
     * FLAT(multires) = 1.0
     * VIDEO
     */
    @XmlAttribute(name = "vfov")
    private Double vFov;
    /**
     * SPHERE, SPHERE(multires)
     * CYLINDER, CYLINDER(multires)
     * VIDEO
     */
    @XmlAttribute(name = "voffset")
    private Double vOffset;

    /**
     * CUBE(multires) = true,
     * SPHERE(multires) = true,
     * CYLINDER(multires) = true,
     * FLAT(multires) = true
     */
    @XmlAttribute
    private Boolean multires;
    /**
     * CUBE(multires),
     * SPHERE(multires),
     * CYLINDER(multires),
     * FLAT(multires)
     */
    @XmlAttribute
    private Double multiresthreshold;
    /**
     * CUBE(multires),
     * SPHERE(multires),
     * CYLINDER(multires),
     * FLAT(multires)
     */
    @XmlAttribute
    private Boolean progressive;
    /**
     * CUBE(multires),
     * SPHERE(multires),
     * CYLINDER(multires),
     * FLAT(multires)
     */
    @XmlAttribute
    private String tilesize;
    /**
     * CUBE(multires),
     * SPHERE(multires),
     * CYLINDER(multires)
     * FLAT(multires)
     */
    @XmlAttribute
    private Integer baseindex;
    /**
     * CUBE(multires),
     * SPHERE(multires),
     * CYLINDER(multires),
     * FLAT(multires)
     */
    @XmlAttribute
    private Integer frames;
    /**
     * CUBE(multires),
     * SPHERE(multires),
     * CYLINDER(multires),
     * FLAT(multires)
     */
    @XmlAttribute
    private Integer frame;

    /**
     * CUBE(multires) level/cube,
     * SPHERE(multires) level/sphere
     * CYLINDER(multires) level/cylinder
     * FLAT(multires) level/cylinder
     */
    @XmlElement
    private KrPanoImageLevel level;
    /**
     * CUBE
     */
    @XmlElement
    private KrPanoImageCube cube;
    /**
     * CUBESTRIP
     */
    @XmlElement
    private KrPanoImageCubestrip cubestrip;
    /**
     * SPHERE
     */
    @XmlElement
    private KrPanoImageSphere sphere;
    /**
     * CYLINDER,
     * FLAT
     */
    @XmlElement
    private KrPanoImageCylinder cylinder;
    /**
     * FISHEYE
     */
    @XmlElement
    private KrPanoImageFisheye fisheye;
}
