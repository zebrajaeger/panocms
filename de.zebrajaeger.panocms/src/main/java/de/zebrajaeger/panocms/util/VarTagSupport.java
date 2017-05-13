package de.zebrajaeger.panocms.util;

import org.apache.commons.lang3.StringUtils;
import org.opencms.file.CmsObject;
import org.opencms.jsp.util.CmsJspElFunctions;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.BodyTagSupport;
import javax.servlet.jsp.tagext.TryCatchFinally;
import java.io.IOException;
import java.util.Locale;

/**
 * @author Lars Brandt on 13.12.2016
 */
public abstract class VarTagSupport extends BodyTagSupport implements TryCatchFinally {

    private String var;
    private CmsObject cmsObject;

    @Override
    public final void release() {
        super.release();
        var = null;
        cmsObject = null;
        doRelease();
    }

    protected void doRelease() {
    }

    protected void setResultValue(Object value) throws JspException {
        setResultValue(value, true);
    }

    protected void removeResultValue() {
        if (StringUtils.isNotBlank(var)) {
            pageContext.removeAttribute(var);
        }
    }

    /**
     * set a value as attribute or write directly to jsp (PAGE_SCOPE)
     *
     * @param value the value. if null, this method does nothing
     * @param writeToContent if var==null && writeToContent==true -> result will be written to jsp
     * @throws JspException
     */
    protected void setResultValue(Object value, boolean writeToContent) throws JspException {
        if (value != null) {
            if (StringUtils.isNotBlank(var)) {
                pageContext.setAttribute(var, value);
            } else if (writeToContent) {
                try {
                    pageContext.getOut().write(value.toString());
                } catch (IOException e) {
                    throw new JspException("Could not write to out", e);
                }
            }
        }
    }

    public CmsObject getCmsObject() {
        if (cmsObject == null) {
            cmsObject = CmsJspElFunctions.getCmsObject(pageContext);
        }
        return cmsObject;
    }

    protected Locale getLocale() {
        return getCmsObject().getRequestContext().getLocale();
    }

    @Override
    public void doFinally() {
        release();
    }

    @Override
    public void doCatch(Throwable throwable) throws Throwable {
        throw throwable;
    }

    //<editor-fold desc="Getter/Setter">
    public void setVar(String var) {
        this.var = var;
    }

    public String getVar() {
        return var;
    }
    //</editor-fold>
}
