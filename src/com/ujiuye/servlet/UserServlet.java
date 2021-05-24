package com.ujiuye.servlet;

import com.ujiuye.service.UserService;
import com.ujiuye.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userServlet")
public class UserServlet extends BaseServlet {
    UserService userService = new UserServiceImpl();

    protected void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean res = userService.login(username,password);
        if (res){
            response.sendRedirect("studentServlet?flag=getStudentByPage&page=1");
        }else {
            response.sendRedirect("login.html");
        }
    }

    protected void signUp(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean res = userService.signUp(username,password);
        if (res){
            response.sendRedirect("login.html");
        }else {
            response.sendRedirect("signUp.html");
        }
    }

}
