<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="content-type" content="text/html;charset=utf-8">
    <title><s:text name="loginTitle"/></title>
</head>
<body>
<center>
    ${tip}
    <s:form action="login.action">
        <s:textfield name="username" key="loginName"/>
        <s:password name="password" key="loginPassword"/>
        <s:submit key="loginSubmit"/>
    </s:form>
</center>
</body>
</html>
