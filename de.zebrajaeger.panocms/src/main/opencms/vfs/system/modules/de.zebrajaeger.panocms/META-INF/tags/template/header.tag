<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ attribute name="hasSiteNavigation" required="true" type="java.lang.Boolean" %>
<%@ attribute name="hasLanguageNavigation" required="true" type="java.lang.Boolean" %>
<%@ attribute name="hasLogo" required="true" type="java.lang.Boolean" %>
<%@ attribute name="hasHandlebar" required="true" type="java.lang.Boolean" %>
<%@ attribute name="headerCfg" required="true" type="org.opencms.jsp.util.CmsJspContentAccessBean " %>

<%@ taglib prefix="cms" uri="http://www.opencms.org/taglib/cms" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lv" uri="http://lv.com/taglib/basis" %>
<fmt:setLocale value="${cms.locale}"/>

<%--@elvariable id="cms" type="org.opencms.jsp.util.CmsJspStandardContextBean"--%>
<%--@elvariable id="all" type="java.util.List<com.lv.opencms.basis.i18n.JspTagLanguageMenu.LanguageItem>"--%>
<%--@elvariable id="current" type="com.lv.opencms.basis.i18n.JspTagLanguageMenu.LanguageItem"--%>
<%--@elvariable id="navL1" type="org.opencms.jsp.util.CmsJspNavigationBean"--%>
<%--@elvariable id="itemL1" type="org.opencms.jsp.CmsJspNavElement"--%>
<%--@elvariable id="navL2" type="org.opencms.jsp.util.CmsJspNavigationBean"--%>
<%--@elvariable id="itemL2" type="org.opencms.jsp.CmsJspNavElement"--%>
<%--@elvariable id="path" type="java.lang.String"--%>
<%--@elvariable id="other" type="java.lang.String"--%>

<header class="page-header">
</header>
