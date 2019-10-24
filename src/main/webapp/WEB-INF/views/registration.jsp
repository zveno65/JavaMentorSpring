<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
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
        <p>${exception}, please try again</p>
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
<sec:authorize access="isAnonymous()">
<button onclick="location.href='/login'">Sing in</button>
</sec:authorize>
</body>
</html>