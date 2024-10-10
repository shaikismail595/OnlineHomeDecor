<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Register</title>
</head>
<body>
    <h2>Registration Form</h2>

    <c:if test="${not empty errorMessage}">
        <div style="color: red;">${errorMessage}</div>
    </c:if>

    <form action="${pageContext.request.contextPath}/register" method="post">
        <div>
            <label for="name">Name:</label>
            <input type="text" id="name" name="name" required>
        </div>
        <div>
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <div>
            <label for="address">Address:</label>
            <textarea id="address" name="address" required></textarea>
        </div>
        <div>
            <label for="dateOfBirth">Date of Birth:</label>
            <input type="date" id="dateOfBirth" name="dateOfBirth" required>
        </div>
        <div>
            <label for="role">Role:</label>
            <select id="role" name="role">
                <option value="USER">User</option>
                <option value="ADMIN">Admin</option>
            </select>
        </div>
        <button type="submit">Register</button>
    </form>

    <p>Already have an account? <a href="${pageContext.request.contextPath}/login">Login here</a></p>
</body>
</html>