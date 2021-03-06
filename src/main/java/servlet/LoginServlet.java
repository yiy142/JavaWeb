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

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
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
        Users user = new Users();
        LoginRegisterInfo info = new LoginRegisterInfo();
        if (username == null || username.length() == 0) {
            out.print("<script language='javascript'>alert('用户名不能为空！');"
                    + "window.location.href='jsp/login.jsp';</script>");
        } else {
            List<Users> list = info.queryInfo("username", username);
            for (int i = 0; i < list.size(); i++) {
                user = list.get(i);
                if (user.getUserName().equals(username)) {
                    if (user.getPassword().equals(password)) {
                        //response.sendRedirect("jsp/success.jsp");
                        out.print("登录成功！");
                        return;
                    } else {
                        out.print("<script language='javascript'>alert('密码错误！');"
                                + "window.location.href='jsp/login.jsp';</script>");
                        //response.sendRedirect("jsp/fail.jsp");
                    }
                }
            }
            out.print("<script language='javascript'>alert('用户名错误！');"
                    + "window.location.href='jsp/login.jsp';</script>");
            //response.sendRedirect("jsp/fail.jsp");
        }
    }
}