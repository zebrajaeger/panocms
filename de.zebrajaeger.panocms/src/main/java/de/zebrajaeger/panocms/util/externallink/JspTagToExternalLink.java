package de.zebrajaeger.panocms.util.externallink;

import org.opencms.file.CmsObject;
import org.opencms.flex.CmsFlexController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import java.io.IOException;

/**
 * Tag to generate an external link from internal link.
 */
public class JspTagToExternalLink extends BodyTagSupport {

    private static final Logger LOG = LoggerFactory.getLogger(JspTagToExternalLink.class);

    private boolean absolute = true;

    private boolean version = true;

    @Override
    public int doEndTag() throws JspException {
        CmsObject cmo = CmsFlexController.getCmsObject(pageContext.getRequest());
        try {
            String resourceName = cmo.getRequestContext().removeSiteRoot(getBodyContent().getString());
            getBodyContent().clear();
            String url = new ToExternalLink().externalLinkTagAction(
                resourceName,
                absolute,
                version,
                (HttpServletRequest) pageContext.getRequest());
            getBodyContent().write(url);
            getBodyContent().writeOut(pageContext.getOut());
            return EVAL_PAGE;
        } catch (IOException e) {
            LOG.error("Error generating url", e);
            throw new JspException(e);
        } finally {
            release();
        }
    }

    @Override
    public void release() {
        super.release();
        this.absolute = true;
        this.version = true;
    }

    //<editor-fold desc="Getter/Setter">
    @SuppressWarnings("unused")
    public void setAbsolute(boolean absolute) {
        this.absolute = absolute;
    }

    @SuppressWarnings("unused")
    public void setVersion(boolean version) {
        this.version = version;
    }
    //</editor-fold>
}
