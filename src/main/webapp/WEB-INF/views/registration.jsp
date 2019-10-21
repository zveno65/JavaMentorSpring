<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Registration new user</title>
</head>

<body>
<div>

    <div>
        <div>
            <h2>Registration user</h2>
        </div>
        <c:if test="${exception != null}">
        <p>"${exception}", please try again</p>
        </c:if>
        <form method="post">
            <label>Name:
                <input type="text" name="name" value="${user.name}"><br />
            </label>
            <label>Age:
                <input type="number" name="age" value="${user.age}"><br />
            </label>
            <label>Password:
                <input type="password" name="password" value="${user.password}"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <button onclick="location.href='../..'">Back to list of users</button>
</div>
</body>
</html>