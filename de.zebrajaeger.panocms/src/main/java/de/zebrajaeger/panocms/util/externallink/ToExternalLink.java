package de.zebrajaeger.panocms.util.externallink;

import org.opencms.file.CmsObject;
import org.opencms.file.CmsResource;
import org.opencms.flex.CmsFlexController;
import org.opencms.jsp.CmsJspTagLink;
import org.opencms.main.CmsException;
import org.opencms.main.OpenCms;
import org.opencms.site.CmsSite;
import org.opencms.staticexport.CmsLinkManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Lars Brandt, Silpion IT Solutions GmbH
 */
public class ToExternalLink {

    private static final Logger LOG = LoggerFactory.getLogger(ToExternalLink.class);

    /**
     * OpenCms way to support static function of OpenCms Tags (like  @see CmsJspTagLink.linkTagAction)
     * @param target, link target
     * @param version, if true last modified will be added as parameter
     * @param request
     * @return
     */
    public  String externalLinkTagAction(String target, boolean version, HttpServletRequest request) {
        return externalLinkTagAction(target, false, version, request);
    }

    /**
     * OpenCms way to support static function of OpenCms Tags (like  @see CmsJspTagLink.linkTagAction)
     * @param target, link target
     * @param request
     * @param absolute, flag, if target is absolute or relativ
     * @return
     */
    public  String externalLinkTagAction(String target, HttpServletRequest request, boolean absolute) {
        return externalLinkTagAction(target, absolute, false, request);
    }

    /**
     * OpenCms way to support static function of OpenCms Tags (like  @see CmsJspTagLink.linkTagAction)
     * @param target, link target
     * @param absolute,flag, if target is absolute or relativ
     * @param version, if true last modified will be added as parameter
     * @param request
     * @return
     */
    public String externalLinkTagAction(final String target, boolean absolute, boolean version, HttpServletRequest request) {
        String url = target;
        CmsFlexController controller = CmsFlexController.getController(request);
        CmsObject cmo = controller.getCmsObject();
        if (version && cmo.existsResource(target)) {
            // append some version to resource
            try {
                CmsResource resource = cmo.readResource(target);
                long lastModified = resource.getDateLastModified();
                if (url.contains("?")) {
                    url += "&v=" + lastModified;
                } else {
                    url += "?v=" + lastModified;
                }
            } catch (CmsException e) {
                LOG.warn("Could not read resource '" + target + "'", e);
            }
        }
        if (absolute) {
            // url = OpenCms.getLinkManager().getServerLink(cmo, resourceName);
            url = OpenCms.getLinkManager().substituteLinkForUnknownTarget(cmo, url);
            url = getServerUrl(cmo, url);
        } else {
            if (request == null) {
                url = OpenCms.getLinkManager().substituteLinkForUnknownTarget(cmo, url);
            } else {
                url = CmsJspTagLink.linkTagAction(url, request);
            }
        }
        return url;
    }

    /**
     * Only if absolute uri and no schema in url parameters
     *
     * 1) If offline projekt -> Workplace Server
     * 2) actual site secure
     * Server and request is https protocol -> Secure Url, if not Site Url
     */
    public static String getServerUrl(CmsObject cmo, String url) {
        String serverPrefix = null;

        if (CmsLinkManager.isAbsoluteUri(url) && !CmsLinkManager.hasScheme(url)) {
            if (cmo.getRequestContext().getCurrentProject().isOnlineProject()) {

                CmsSite currentSite = OpenCms.getSiteManager().getSite(url, cmo.getRequestContext().getSiteRoot());
                if (currentSite.hasSecureServer()) {
                    // now a resource comes over ssl requested, return absolute
                    // url with https
                    serverPrefix = currentSite.getSecureUrl();
                } else {
                    serverPrefix = currentSite.getUrl();
                }

                if (LOG.isDebugEnabled()) {
                    String msg = "Generated serverprefix '%s' for url '%s', site: %s";
                    LOG.debug(String.format(msg, serverPrefix, url, currentSite));
                }

            } else {
                serverPrefix = OpenCms.getSiteManager().getWorkplaceServer();
            }
            url = serverPrefix + url;
        }
        return url;
    }
}
