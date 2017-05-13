package de.zebrajaeger.panocms;

import org.opencms.configuration.CmsConfigurationManager;
import org.opencms.file.CmsObject;
import org.opencms.module.A_CmsModuleAction;
import org.opencms.module.CmsModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Lars Brandt on 20.12.2016
 */
public class ActionClass extends A_CmsModuleAction {

    private static final Logger LOG = LoggerFactory.getLogger(ActionClass.class);
    private static CmsObject adminCms;

    public static CmsObject getAdminCms() {
        return adminCms;
    }

    @Override
    public void initialize(CmsObject pAdminCms, CmsConfigurationManager configurationManager, CmsModule module) {
        adminCms = pAdminCms;
    }
}
