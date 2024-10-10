package com.yash.onlineHomeDecor.controller;

import com.yash.onlineHomeDecor.domain.User;
import com.yash.onlineHomeDecor.service.UserService;
import com.yash.onlineHomeDecor.serviceimpl.UserServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/register/*")
public class RegistrationController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showRegistrationForm(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registerUser(request, response);
    }

    private void showRegistrationForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("${pageContext.request.contextPath}/views/register.jsp").forward(request, response);
    }

    private void registerUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        String address = request.getParameter("address");
        String dobStr = request.getParameter("dateOfBirth");
        String role = request.getParameter("role");
        Date dateOfBirth = null;

        try {
            dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(dobStr);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        User user = new User();
        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setAddress(address);
        user.setDateOfBirth(dateOfBirth);
        user.setRole(role);

        try {
            userService.registerUser(user);
            response.sendRedirect(request.getContextPath() + "/login");
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("${pageContext.request.contextPath}/views/register.jsp").forward(request, response);
        }
    }
}