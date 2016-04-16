<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>用户注册页面</title>
</head>
<body>
<br/>
<center>
    <s:form action="regist">
        <s:textfield name="username" label="用户名"/>
        <s:password name="password" label="密码"/>
        <s:password name="repassword" label="重复密码"/>
        <s:radio list="{'男','女'}" name="gender" value="'男'"/>
        <s:textfield name="birthday" label="生日(格式如:1990-01-01)"/>
        <s:checkboxlist list="{'读书','游戏','看电影','旅游'}" name="habby" label="爱好"/>
        <s:textarea rows="3" cols="15" name="address" label="家庭住址"/>
        <s:submit value="注册"/>
    </s:form>
</center>
</body>
</html>