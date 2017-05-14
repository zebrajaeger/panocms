<%@page buffer="none" session="false" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="cms" uri="http://www.opencms.org/taglib/cms" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pc" uri="http://panocms.zebrajaeger.de/taglib/pc" %>
<%@ taglib prefix="template" uri="http://panocms.zebrajaeger.de/taglib/template" %>

<%--@elvariable id="cms" type="org.opencms.jsp.util.CmsJspStandardContextBean"--%>

<fmt:setLocale value="${cms.locale.language}" />
<!DOCTYPE html>
<html class="no-js" lang="${cms.locale.language}">
    <template:head/>
    <body>
        <template:header/>
        <cms:container name="banner">Banner</cms:container>
        <cms:container name="content">Content</cms:container>
        <template:footer/>
    </body>
</html>