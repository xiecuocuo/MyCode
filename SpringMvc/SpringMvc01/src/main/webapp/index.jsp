<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <a href="springmvc/delete/10">删除10</a><br/>
    <a href="springmvc/testParamsAndHeaders?username=ynf&age=11">testParamsAndHeaders</a><br/>
    <form action="springmvc/testMethod11" method="post"><br/>
        <input type="submit" value="提交">
    </form>
    <a href="helloWorld">HelloWorld!</a><br/>
    <a href="springmvc/testRequestMapping">testRequestMapping</a><br/>
    <a href="springmvc/testRest/1">testRestGET</a><br/>
    <form action="springmvc/testRest" method="post">
        <input type="submit" value="testRestPOST">
    </form><br/>
    <form action="springmvc/testRest/1" method="post">
        <input type="hidden" name="_method" value="PUT">
        <input type="submit" value="testRestPUT">
    </form><br/>
    <form action="springmvc/testRest/1" method="post">
        <input type="hidden" name="_method" value="DELETE">
        <input type="submit" value="testRestDELETE">
    </form><br/>
    <a href="springmvc/testRequestParam?username=ynf&age=11">testRequestParam</a><br/>
    <a href="springmvc/testRequestHeader?username=ynf&age=11">testRequestHeader</a><br/>
    <a href="springmvc/testCookieValue?username=ynf&age=11">testCookieValue</a><br/>
    <form action="springmvc/testPojo" method="post"><br/>
        username:<input name="username" type="text"><br/>
        password:<input name="password" type="password"><br/>
        email:<input name="email" type="text"><br/>
        age:<input name="age" type="text"/><br/>
        province:<input name="address.province" type="text"><br/>
        city:<input name="address.city" type="text"><br/>
        <input type="submit" value="submit">
    </form>
    <a href="springmvc/testRequestApi?username=ynf&age=11">testRequestApi</a><br/>
    <a href="springmvc/testModelAndView?username=ynf&age=11">testModelAndView</a><br/>
    <a href="springmvc/testModel?username=ynf&age=11">testModel</a><br/>
    <a href="springmvc/testMap?username=ynf&age=11">testMap</a><br/>
    <a href="springmvc/testSessionAttribute?username=ynf&age=11">testSessionAttribute</a><br/>
    <form action="springmvc/testModelAttribute" method="post">
        <input type="hidden" name="id" value="1"><br/>
        username:<input type="text" name="username"  value="ynf"><br/>
        email:<input type="text" name="email" value="976301948@qq.com"><br/>
        age:<input type="age" name="age" value="12"><br/>
        <input type="submit" value="Submit">
    </form>
    <a href="springmvc/testHelloView">testHelloView</a><br/>
    <a href="springmvc/testForward">testForward</a><br/>
    <a href="springmvc/testRedirect">testRedirect</a><br/>
</body>
</html>
