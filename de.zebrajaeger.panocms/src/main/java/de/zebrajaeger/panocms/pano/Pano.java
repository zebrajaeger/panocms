package de.zebrajaeger.panocms.pano;

import java.io.File;
import java.io.IOException;

/**
 * @author Lars Brandt
 */
public class Pano {

    public static Pano of(File panoRoot) throws IOException {
        KrPanoConfig cfg = PanoUtils.findConfig(panoRoot);
        PanoDescriptor desc = PanoUtils.findDescriptor(panoRoot);
        return new Pano(panoRoot, cfg, desc);
    }

    private File panoRoot;
    private KrPanoConfig panoConfig;
    private PanoDescriptor descriptor;

    public Pano(File panoRoot, KrPanoConfig panoConfig, PanoDescriptor descriptor) {
        this.panoRoot = panoRoot;
        this.panoConfig = panoConfig;
        this.descriptor = descriptor;
    }
}
