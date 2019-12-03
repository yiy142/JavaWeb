<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>登陆界面</title>
</head>
<body>

<h1>登            录</h1>
<hr>
<form action="/login" method="post">
    <table>
        <tr>
            <td class="td1">用 户 名：</td>
            <td class="td2"><input class="text1" type="text"
                                   name="username"/></td>
        </tr>
        <tr>
            <td class="td1">密    码：</td>
            <td class="td2"><input class="text1" type="password"
                                   name="password" /></td>
        </tr>
        <tr>
            <td colspan="2">
                <input class="button" type="submit" value="登录" />
                <a href="register.jsp"> 注册 </a>>
            </td>
        </tr>
    </table>
</form>
</body>
</html>
