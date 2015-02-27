<!DOCTYPE html>
<%@page pageEncoding="UTF-8" language="java" contentType="text/html; UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<html>
<head>
    <meta charset="UTF-8">
    <title>Welcome</title>
</head>
<body>
<h1>Sample Page</h1>
<pre>${mybean}</pre>
<hr>
<form action="sample" method="post">
    <input type="text" id="message" name="message">
    <input type="submit" value="add">
</form>
</body>
</html>

