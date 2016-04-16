<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>用户注册</title>
    <link rel="stylesheet" type="text/css" href="css/common.css"/>
    <link rel="stylesheet" type="text/css" href="css/user.css"/>
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/user.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
</head>
<body>
<div class="wrapper">
    <nav>
        <ul>
            <li>已有账号，立即
                <button type="button"
                        onclick="window.location.href='userAction!prepareLogin.do'">登录
                </button>
            </li>
        </ul>
    </nav>

    <div class="gap_after_header"></div>
    <div class="table_user">
        <div class="table_title">用户注册</div>
        <form id="userRegister" onsubmit="return checkRegister(this);">
            <div>
                <table>
                    <tr>
                        <td>用户名</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="username"
                                   required="required" placeholder="3-20位字母、数字或下划线"/></td>
                    </tr>
                    <tr>
                        <td>密码</td>
                    </tr>
                    <tr>
                        <td><input type="password" name="password"
                                   required="required" placeholder="6-20位"/></td>
                    </tr>
                    <tr>
                        <td>确认密码</td>
                    </tr>
                    <tr>
                        <td><input type="password" name="confirmPassword"
                                   required="required" placeholder="必须与密码相同"/></td>
                    </tr>
                    <tr>
                        <td>昵称</td>
                    </tr>
                    <tr>
                        <td><input type="text" name="nickname"
                                   required="required" placeholder="3-20位"/></td>
                    </tr>
                </table>
            </div>
        </form>
        <div class="link_group">
            <button type="submit" form="userRegister" formmethod="post"
                    formaction="userAction!register.do">注册
            </button>
            <button form="userRegister" type="reset">重置</button>
        </div>
    </div>
</div>
</body>
</html>