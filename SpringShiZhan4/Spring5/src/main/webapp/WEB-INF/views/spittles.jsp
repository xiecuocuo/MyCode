<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittles</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
    <c:forEach items="${spittleList}" var="spittle">
        <li id="spittles_<c:out value="spittle.id"/>">
            <div class="spitt">
                <c:out value="${spittle.Message}"/>
            </div>
            <div>
                <span class="spittleTime"><c:out value="${spittle.time}"/></span>
                <span class="spittleLocation">(<c:out value="${spittle.latitude}"/>,<c:out value="${spittle.longtitude}"/></span>
            </div>
        </li>
    </c:forEach>
</body>
</html>
