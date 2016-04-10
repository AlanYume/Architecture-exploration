<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户登录</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/user.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
<div class="wrapper">
    <nav></nav>
    <div class="gap_after_header"></div>
    <div class="table_user">
        <div class="table_title">管理员登录</div>
        <form id="userlogin">
            <div>
                <table>
                    <tr>
                        <td><input type="text" required="required" name="username"
                                   placeholder="用户名"/></td>
                    </tr>
                    <tr>
                        <td><input type="password" required="required"
                                   name="password" placeholder="密码"/></td>
                    </tr>
                </table>
            </div>
        </form>
        <div class="link_group">
            <button type="submit" form="userlogin" formmethod="post"
                    formaction="userAction!adminLogin.do">登录
            </button>

            <button form="userlogin" type="reset">重置</button>
        </div>
    </div>
</div>
</body>
</html>