package servlet;

import dao.LoginRegisterInfo;
import entity.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String repassword = request.getParameter("repassword");
        Users user = new Users();
        LoginRegisterInfo info = new LoginRegisterInfo();
        if (username == null || username.length() == 0) {
            out.print("<script language='javascript'>alert('用户名不能为空！');"
                    + "window.location.href='JSP/register.jsp';</script>");
        } else {
            List<Users> list = info.queryInfo("username", username);
            for (int i = 0; i < list.size(); i++) {
                user = list.get(i);
                if (user.getUserName().equals(username)) {
                    out.print("<script language='javascript'>alert('用户名已存在！');"
                            + "window.location.href='JSP/register.jsp';</script>");
                }
            }
        }
        if (password == null || password.length() == 0) {
            out.print("<script language='javascript'>alert('密码不能为空！');"
                    + "window.location.href='JSP/register.jsp';</script>");
        } else if (!password.equals(repassword)) {
            out.print("<script language='javascript'>alert('两次输入的密码不一致！');"
                    + "window.location.href='JSP/register.jsp';</script>");
        }
        user.setUserName(username);
        user.setPassword(password);
        info.saveInfo(user);
        out.print("注册成功！");
    }
}