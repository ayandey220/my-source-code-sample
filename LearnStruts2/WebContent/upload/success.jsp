<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title><s:property value="%{filename}"/> Successfully  ....</title>
</head>
<body>

<s:iterator value="%{uploadFileName}" var="file">
	<s:text name="thankyou" /> <s:text name="file" /><br>
</s:iterator>

<hr>
<s:iterator value="%{excelFileContent}" var="excelfile">
	<div style="width: 350px; height: 200px; overflow: scroll;">
		<s:text name="excelfile" />
	</div>
</s:iterator>

<hr>
<s:iterator value="antivirusStatus" var="status">
	<div style="width: 350px; height: 200px; overflow: scroll;">
		<s:if test="%{#status=='OK'}">
			<img src='../images/ok.gif' />
		</s:if>
		<s:else>
			<s:text name="status"></s:text>
		</s:else>
	</div>
</s:iterator>
</body>
</html>