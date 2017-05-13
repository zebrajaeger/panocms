package de.zebrajaeger.panocms.util;

import org.apache.commons.lang.StringUtils;
import org.opencms.file.CmsPropertyDefinition;
import org.opencms.main.CmsException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.jsp.JspException;

/**
 * @author Lars Brandt, Silpion IT Solutions GmbH
 */
public class JspTagTitle extends VarTagSupport {

    private static final Logger LOG = LoggerFactory.getLogger(JspTagTitle.class);
    private String path;

    @Override
    public int doEndTag() throws JspException {
        try {
            if (StringUtils.isNotBlank(path)) {
                path = getCmsObject().getRequestContext().removeSiteRoot(path);
            } else {
                // no path given -> take current path
                path = getCmsObject().getRequestContext().getUri();
            }

            if (getCmsObject().existsResource(path)) {
                String result = getCmsObject().readPropertyObject(path, CmsPropertyDefinition.PROPERTY_TITLE, true).getValue();
                setResultValue(result);
            } else {
                LOG.warn("Read title from Resource '{}' failed", path);
            }

            return super.doEndTag();
        } catch (CmsException e) {
            throw new JspException("Could not read Title", e);
        } finally {
            release();
        }
    }

    @Override
    protected void doRelease() {
        path = null;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
