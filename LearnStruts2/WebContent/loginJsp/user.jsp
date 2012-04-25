<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>User</title>
<script type="text/javascript">
function GetXmlHttpObject()
{
    if (window.XMLHttpRequest)
    {
        // code for IE7+, Firefox, Chrome, Opera, Safari
        return new XMLHttpRequest();
    }
    if (window.ActiveXObject)
    {
    // code for IE6, IE5
    return new ActiveXObject("Microsoft.XMLHTTP");
    }
    
    return null;
}

function getUserList(){
	var myAjaxPostrequest = new GetXmlHttpObject();
	var parameters = "a=list";
	/*
	*	The difference b/w post and get in ajax call, in get you need to specify inline parameter
	*	and get has also limitation to send the long text as well as in special characters and in get request send null in parameter.
	*	In post request you can send long text, special character, and you can also pass parameters in send method.
	*/
	myAjaxPostrequest.open("POST", "users.action", true);
    myAjaxPostrequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
    myAjaxPostrequest.send(parameters);
    myAjaxPostrequest.onreadystatechange=function(){
        if(myAjaxPostrequest.readyState==4){
            if(myAjaxPostrequest.status==200){
            	//If you are using text (string) then there is no need to use eval
            	//document.getElementById('userList').innerHTML = myAjaxPostrequest.responseText;
            	
            	//if you are using json then you need use eval (javascript function) to parse json content into HTML 
            	document.getElementById('userList').innerHTML = eval(myAjaxPostrequest.responseText);
            }
            else{
                alert("An error has occured making the request");
            }
        }
    };
}
</script>
</head>
<body>
<table>
<s:form action="saveUser" namespace="/loginJsp" theme="simple">
<tr>
<td>Id</td> <td>
<s:textfield name="user.id" label="id" />
</td>
</tr>
<tr>
<td><s:text name="global.username" /> </td> <td>
<s:textfield name="user.username" label="username" />
</td>
</tr>
<tr>
<td><s:text name="global.password" /></td> <td>
<s:textfield name="user.password" label="password" />
</td>
</tr>
<tr>
<td colspan="2">
<s:submit />
</td>
</tr>
</s:form>
</table>
<div id="userList">
</div>
<a href="#" onclick="javascript: getUserList()">User List</a>
<a href="#" onclick="javascript: window.open('users.action?a=downloadFile');">Download File</a>
<br><br><br><br><br><br><br><br><br><br><br><br>
Change language
<hr>
<a href="<%= request.getContextPath() %>/loginJsp/loginUser.action?request_locale=en" >English</a> |
<a href="<%= request.getContextPath() %>/loginJsp/loginUser.action?request_locale=de" >German [de]</a> |
<a href="<%= request.getContextPath() %>/loginJsp/loginUser.action?request_locale=fr" >French</a> |
<a href="<%= request.getContextPath() %>/loginJsp/loginUser.action?request_locale=zh_CN" >Chinese (Simplified) </a>
<hr>
</body>
</html>