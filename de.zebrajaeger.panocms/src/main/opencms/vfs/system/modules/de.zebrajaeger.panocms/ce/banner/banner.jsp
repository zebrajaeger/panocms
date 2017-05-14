<%@page buffer="none" session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="cms" uri="http://www.opencms.org/taglib/cms" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--@elvariable id="cms" type="org.opencms.jsp.util.CmsJspStandardContextBean"--%>
<%--@elvariable id="c" type="org.opencms.jsp.util.CmsJspContentAccessBean"--%>
<%--@elvariable id="v" type="java.util.Map<java.lang.String, org.opencms.jsp.util.CmsJspContentAccessValueWrapper>"--%>
<%--@elvariable id="r" type="java.util.Map<java.lang.String, java.lang.String>"--%>

<cms:formatter var="c" val="v" rdfa="r">
    <div class="banner">
        <div id="wrapper">
            <div class="wrap">
                <div class="slider-wrapper theme-default">
                    <div id="slider" class="nivoSlider">
                        <c:forEach items="${c.valueList['Bild']}" var="img" >
                            <img src="<cms:link>${img.value['Image']}</cms:link>"  alt="${img.value['Alt']}" />
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </div>
</cms:formatter>
