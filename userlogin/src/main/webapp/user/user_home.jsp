<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${session.user.nickname}的主页</title>
    <link rel="stylesheet" type="text/css" href="css/easyui.css">
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/user.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
<div class="wrapper">
    <nav>
        <ul class="level1">
            <li><a href="#">${session.user.nickname}</a>
                <ul class="level2">
                    <li><a href="userAction!detail.do">个人资料</a></li>
                    <li><a href="javascript:void(0)" onclick="$('#w').window('open')">修改密码</a></li>
                    <li><a href="userAction!logout.do">退出系统</a></li>
                </ul>
            </li>
        </ul>
    </nav>

    <div class="gap_after_header"></div>
    <h1 align="center">
        this is home page of <font color="blue">${session.user.nickname}
        !</font>
    </h1>

    <div id="w" class="easyui-window" title="修改密码"
         data-options="iconCls:'icon-save'"
         style="width: 300px; height: 200px; padding: 10px;">
        <input type="text"/>
    </div>
</div>
</body>
</html>