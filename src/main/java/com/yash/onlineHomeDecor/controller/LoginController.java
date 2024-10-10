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

@WebServlet("/login/*")
public class LoginController extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getPathInfo();
        if (action == null) {
            action = "/";
        }

        switch (action) {
            case "/":
                showLoginForm(request, response);
                break;
            case "/profile":
                showUserProfile(request, response);
                break;
            default:
                response.sendError(404);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        loginUser(request, response);
    }

    private void showLoginForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
    }

    private void showUserProfile(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        User user = (User) request.getSession().getAttribute("currentUser");
        if (user == null) {
            response.sendRedirect(request.getContextPath() + "/login");
        } else {
            request.setAttribute("user", user);
            request.getRequestDispatcher("/WEB-INF/views/profile.jsp").forward(request, response);
        }
    }

    private void loginUser(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            User user = userService.loginUser(email, password);
            request.getSession().setAttribute("currentUser", user);
            response.sendRedirect(request.getContextPath() + "/login/profile");
        } catch (Exception e) {
            request.setAttribute("errorMessage", e.getMessage());
            request.getRequestDispatcher("/WEB-INF/views/login.jsp").forward(request, response);
        }
    }
}