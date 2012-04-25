<%@page import="edu.learn.struts2.locale.StrutsLocale"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Struts Locale</title>
</head>
<body>

<br>
<h2>Language: <s:property value="%{#attr.language}" /><br></h2>

<s:if test="%{#attr.language == 'ENGLISH'}">	
	Hoorey ....<s:property value="%{#attr.language}" /><br>	
</s:if>
<s:else>
	
	Oops ....<s:property value="%{#attr.language}" /><br>
</s:else>
<%= StrutsLocale.getText("global.locale") %>

<br>
Change language<br>
<a href="<%= request.getContextPath() %>/loginJsp/loginUser.action?request_locale=en" >English</a> |
<a href="<%= request.getContextPath() %>/loginJsp/loginUser.action?request_locale=de" >German [de]</a> |
<a href="<%= request.getContextPath() %>/loginJsp/loginUser.action?request_locale=fr" >French</a> |
<a href="<%= request.getContextPath() %>/loginJsp/loginUser.action?request_locale=zh_CN" >Chinese (Simplified) </a>
<br><br><br>
<a href="<%= request.getContextPath() %>/loginJsp/user.action" >Login User with User Bean</a>
</body>
</html>