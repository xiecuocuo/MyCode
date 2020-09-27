<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spittles</title>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/style.css" />" >
</head>
<body>
   <div class="spittleView">
       <div class="spittleMessage"><c:out value="${spittle.message}"/></div>
       <div class="spittleTime"><c:out value="${spittle.time}"/></div>
   </div>
</body>
</html>
