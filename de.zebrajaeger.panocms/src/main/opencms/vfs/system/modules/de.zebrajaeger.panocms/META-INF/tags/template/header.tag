<%@ tag body-content="empty" trimDirectiveWhitespaces="true" %>

<%@ taglib prefix="cms" uri="http://www.opencms.org/taglib/cms" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="pc" uri="http://panocms.zebrajaeger.de/taglib/pc" %>

<fmt:setLocale value="${cms.locale}"/>

<%--@elvariable id="cms" type="org.opencms.jsp.util.CmsJspStandardContextBean"--%>

<div class="header" style="background:url(<pc:linkExternal absolute="false">/system/modules/de.zebrajaeger.panocms/resources/images/header-bg.png</pc:linkExternal>)#fff">
        <%--
    <div class="header-top ">
        <div class="wrap">
            <div class="short-info">
                <a href="#">mail@nicholfoto.org</a>
                <span>+ 1 000 025 0587</span>
            </div>
            <ul class="follow_icon">
                <li><a href="#" style="opacity: 1;"><img src="images/follow_icon.png" alt=""></a></li>
                <li><a href="#" style="opacity: 1;"><img src="images/follow_icon1.png" alt=""></a></li>
                <li><a href="#" style="opacity: 1;"><img src="images/follow_icon2.png" alt=""></a></li>
                <li><a href="#" style="opacity: 1;"><img src="images/follow_icon3.png" alt=""></a></li>
                <li><a href="#" style="opacity: 1;"><img src="images/follow_icon4.png" alt=""></a></li>
                <li><a href="#" style="opacity: 1;"><img src="images/follow_icon5.png" alt=""></a></li>
            </ul>
            <div class="clear"></div>
        </div>
    </div>
        --%>
    <div class="header-bot">
        <div class="wrap">
            <div class="logo">
                <a href="index.html"><img src="<cms:link>/.gallery/vorlage//logo.png</cms:link>" alt=""/></a>
            </div>
            <div class="menu">
                <ul>
                    <li class="active"><a href="index.html">Home</a></li>
                    <li><a href="about.html">About</a></li>
                    <li><a href="projects.html">Projects</a></li>
                    <li><a href="contact.html">Contact</a></li>
                </ul>
            </div>
            <div class="clear"></div>
        </div>
    </div>
</div>
