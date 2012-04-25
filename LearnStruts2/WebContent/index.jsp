<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Learn Struts 2</title>
</head>
<body>
<a href="cacheJsp/checkCache.action" >Cache Interceptor Demo</a> <br>
<a href="loginJsp/user.action" >Login User with User Bean</a>
<hr>
<h2>Language</h2>
<a href="loginJsp/loginUser.action?request_locale=en" >English</a> |
<a href="loginJsp/loginUser.action?request_locale=de" >German [de]</a> |
<a href="loginJsp/loginUser.action?request_locale=fr" >French</a> |
<a href="loginJsp/loginUser.action?request_locale=zh_CN" >Chinese (Simplified) </a>
<hr>
<a href="displaytag/index.jsp">displaytag</a><br>
<a href="token.htm">Token</a>
</body>
</html>