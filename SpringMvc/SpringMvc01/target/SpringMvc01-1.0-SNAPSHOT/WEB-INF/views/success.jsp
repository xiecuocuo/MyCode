<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h4>Success!</h4>
    username:${sessionScope.person.getUsername()}<br/>
    city:${sessionScope.address.getCity()}<br/>
    person:${requestScope.person}<br/>
<fmt:bundle basename="i18n">
    <fmt:message key="i18n.username"></fmt:message><br></br>
    <fmt:message key="i18n.password"></fmt:message><br></br>
</fmt:bundle>
</body>
</html>
