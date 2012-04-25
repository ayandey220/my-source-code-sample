<%@page import="edu.learn.displaytag.TestList"%>
<%@page import="org.displaytag.tags.TableTagParameters"%>
<%@page import="org.displaytag.util.ParamEncoder"%>
<%@page import="edu.learn.displaytag.Test"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>displaytag demo</title>
</head>
<body>
<%
	TestList testList = new TestList();	
	request.setAttribute( "test", testList.getList());
%>

<hr>
<b>page size:</b> number of rows to display on page<br>
<b>size:</b> total number of record<br>
<b>export:</b> enable export for listing set export property true<br>

<br>
<br>
<display:table name="test" id="l" pagesize="10" size="100" 
	partialList="true" export="true" excludedParams="*" sort="list"
>
	<display:column sortable="true" property="row"></display:column>
	<display:column sortable="true" property="id"></display:column>
	<display:column sortable="true" property="name"></display:column>
</display:table>

<%= new ParamEncoder("l").encodeParameterName(TableTagParameters.PARAMETER_SORT) %><br>
<%= (Integer.parseInt(request.getParameter((new ParamEncoder("l").encodeParameterName(TableTagParameters.PARAMETER_PAGE)))) - 1) * 100  %><br>
<%= new ParamEncoder("l").encodeParameterName(TableTagParameters.PARAMETER_ORDER) %>
</body>
</html>