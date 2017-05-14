<%@ tag body-content="empty" trimDirectiveWhitespaces="true"%>

<%@ taglib prefix="cms" uri="http://www.opencms.org/taglib/cms" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pc" uri="http://panocms.zebrajaeger.de/taglib/pc" %>

<%--@epcariable id="cms" type="org.opencms.jsp.util.CmsJspStandardContextBean"--%>

<head>
    <cms:enable-ade/>
        <title>${cms.title}</title>
        <meta name="description" content="${cms.vfs.property[cms.requestContext.uri]['Description']}" />
        <meta name="keywords" content="${cms.vfs.property[cms.requestContext.uri]['Keywords']}" />

        <link rel="stylesheet" type="text/css" media="all"
              href="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/style.css</pc:linkExternal>"  />
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />

        <link rel="apple-touch-icon-precomposed" sizes="114x114"
              href="<cms:link>/system/modules/de.zebrajaeger.panocms/resources/images/apple-touch-icon.png</cms:link>">
        <link rel="shortcut icon" type="image/png"
              href="<cms:link>/system/modules/de.zebrajaeger.panocms/resources/images/favicon.png</cms:link>">
        <link rel="icon" type="image/png"
              href="<cms:link>/system/modules/de.zebrajaeger.panocms/resources/images/favicon.png</cms:link>"
              sizes="32x32">
        <!-- CSS -->
        <link rel="stylesheet" type="text/css" media="all"
              href="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/default.css</pc:linkExternal>">
        <link rel="stylesheet" type="text/css" media="all"
              href="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/nivo-slider.css</pc:linkExternal>">
        <!-- JS -->
        <script src="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/js/jquery-1.9.0.min.js</pc:linkExternal>"></script>
        <script src="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/js/jquery.nivo.slider.js</pc:linkExternal>"></script>
        <script type="text/javascript">
            $(window).load(function() {
                $('#slider').nivoSlider();
            });
        </script>
<%--
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

    <c:if test="${cms.isOnlineProject}">
            <link rel="stylesheet"
                  href="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/bower.min.css</pc:linkExternal>">
            <link rel="stylesheet"
                  href="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/vendor.min.css</pc:linkExternal>">
            <link rel="stylesheet"
                  href="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/app.min.css</pc:linkExternal>">
        <script src="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/js/bower.min.js</pc:linkExternal>"></script>
        <script src="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/js/app.min.js</pc:linkExternal>"></script>

	</c:if>

    <c:if test="${not cms.isOnlineProject}">
            <link rel="stylesheet"
                  href="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/bower.css</pc:linkExternal>">
            <link rel="stylesheet"
                  href="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/vendor.css</pc:linkExternal>">
            <link rel="stylesheet"
                  href="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/css/app.css</pc:linkExternal>">
        <script src="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/js/bower.js</pc:linkExternal>"></script>
        <script src="<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/js/app.js</pc:linkExternal>"></script>

	</c:if>
--%>
</head>
