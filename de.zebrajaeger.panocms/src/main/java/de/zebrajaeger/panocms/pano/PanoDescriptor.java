package de.zebrajaeger.panocms.pano;

import de.zebrajaeger.panocms.pano.descriptor.Coordinate;
import de.zebrajaeger.panocms.pano.descriptor.Tag;

import java.util.List;
import java.util.UUID;

/**
 * @author Lars Brandt
 */
public class PanoDescriptor {
    private UUID id;
    private String name;
    private String description;
    private String excerpt;
    private Coordinate coordinate;
    private Float angleH;
    private Float angleV;
    private List<Tag> tags;
}
