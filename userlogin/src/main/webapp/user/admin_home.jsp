<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>${session.admin.nickname}的管理界面</title>
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
            <li><a href="#">${session.admin.nickname}</a>
                <ul class="level2">
                    <li><a href="userAction!adminLogout.do">退出管理</a></li>
                </ul>
            </li>
        </ul>
    </nav>

    <div class="gap_after_header"></div>
    <div class="table_users">
        <div class="table_title">用户列表</div>
        <div>
            <table>
                <tr>
                    <td>序号</td>
                    <td>用户名</td>
                    <td>昵称</td>
                    <td>操作</td>
                </tr>
                <c:forEach var="user" items="${requestScope.users }"
                           varStatus="status">
                    <tr>
                        <td>${status.index+1 }</td>
                        <td>${user.username }</td>
                        <td>${user.nickname }</td>
                        <td><a href="userAction!resetPasswd.do?id=${user.id }">重置密码</a>|
                            <a href="userAction!deleteUser.do?id=${user.id }">删除</a></td>
                    </tr>
                </c:forEach>
            </table>
        </div>
        <!-- div id="passwd" style="width: 100px; display: none;">
            <div style="width: 80px; height: 20px;">
                修改密码<img src="images/close.png" onclick="$('#passwd').style.display='none'"/>
            </div>
            <div>
                <input type="hidden" name="id" id="uid" value="0" /> <input
                    type="password" name="password" />
                <button>确定</button>
            </div>
        </div-->
    </div>
</div>
</body>
</html>