
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>

    <title>My JSP 'index.jsp' starting page</title>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
</head>

<body>
<h1>注            册</h1>
<hr>
<form action="/register" method="post">
    <table>
        <tr>
            <td class="td1">用 户 名：</td>
            <td class="td2"><input class="text1" type="text"
                                   name="username" /></td>
        </tr>
        <tr>
            <td class="td1">密    码：</td>
            <td class="td2"><input class="text1" type="password"
                                   name="password" /></td>
        </tr>
        <tr>
            <td class="td1">确认密码：</td>
            <td class="td2"><input class="text1" type="password"
                                   name="repassword" /></td>
        </tr>
        <tr>
            <td colspan="2"><input class="button" type="submit" value="注册" />
                <a href="login.jsp">返回</a> </td>
        </tr>
    </table>
</form>
</body>
