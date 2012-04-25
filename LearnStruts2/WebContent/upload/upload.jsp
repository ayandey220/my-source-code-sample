<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Upload your files</title>
</head>
<body>

<s:form action="uploadFiles" method="POST" enctype="multipart/form-data" namespace="/upload" theme="simple">
<s:text name="file.upload1" />: <s:file name="upload" /><br>
<s:text name="file.upload2" /><s:file name="upload" /><br>
<s:text name="file.upload3" /><s:file name="upload" /><br>
<s:text name="file.upload4" /><s:file name="upload" /><br>
<s:submit value="upload file(s)" />
</s:form>

<s:textfield key="file.upload1"  />


<s:property value="getText('global.username')" />
<hr>
To check the virus scanner please download <a href="<%= request.getContextPath()%>/virus_sample.rar">Virus Sample</a>

</body>
</html>