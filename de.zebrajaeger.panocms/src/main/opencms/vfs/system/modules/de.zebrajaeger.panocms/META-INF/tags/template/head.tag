<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="cms" uri="http://www.opencms.org/taglib/cms" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="lv" uri="http://lv.com/taglib/basis" %>

<%--@elvariable id="cms" type="org.opencms.jsp.util.CmsJspStandardContextBean"--%>

<head>
    <cms:enable-ade/>
    <meta charset="utf-8">
    <title>${cms.title}</title>

    <meta name="description" content="${cms.vfs.property[cms.requestContext.uri]['Description']}" />
    <meta name="keywords" content="${cms.vfs.property[cms.requestContext.uri]['Keywords']}" />


            <meta name="application-name" content="Panocms">
            <meta name="msapplication-tooltip" content="Panocms">
            <meta name="msapplication-TileColor" content="#FFFFFF">
            <meta name="msapplication-TileImage"
                  content="<cms:link>/system/modules/de.zebrajaeger.panocms/resources/images/mstile-144x144.png</cms:link>">
            <link rel="apple-touch-icon-precomposed" sizes="114x114"
                  href="<cms:link>/system/modules/de.zebrajaeger.panocms/resources/images/apple-touch-icon.png</cms:link>">
            <link rel="shortcut icon" type="image/png"
                  href="<cms:link>/system/modules/de.zebrajaeger.panocms/resources/images/favicon.png</cms:link>">
            <link rel="icon" type="image/png"
                  href="<cms:link>/system/modules/de.zebrajaeger.panocms/resources/images/favicon.png</cms:link>"
                  sizes="32x32">

    <c:if test="${cms.isonline}>
            <link rel="stylesheet"
                  href="<lv:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/bower.min.css</lv:linkExternal>">
            <link rel="stylesheet"
                  href="<lv:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/vendor.min.css</lv:linkExternal>">
            <link rel="stylesheet"
                  href="<lv:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/app.min.css</lv:linkExternal>">
        <script src="<lv:linkExternal absolute="false">/system/modules/com.lv.opencms.basis/resources/js/bower.min.js</lv:linkExternal>"></script>
        <script src="<lv:linkExternal absolute="false">/system/modules/com.lv.opencms.basis/resources/js/app.min.js</lv:linkExternal>"></script>

	</c:if>

    <c:if test="${not cms.isonline}>
            <link rel="stylesheet"
                  href="<lv:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/bower.css</lv:linkExternal>">
            <link rel="stylesheet"
                  href="<lv:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/vendor.css</lv:linkExternal>">
            <link rel="stylesheet"
                  href="<lv:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/app.css</lv:linkExternal>">
        <script src="<lv:linkExternal absolute="false">/system/modules/com.lv.opencms.basis/resources/js/bower.js</lv:linkExternal>"></script>
        <script src="<lv:linkExternal absolute="false">/system/modules/com.lv.opencms.basis/resources/js/app.js</lv:linkExternal>"></script>

	</c:if>
</head>
