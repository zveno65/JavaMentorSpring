<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new user</title>
</head>

<body>
<div>
    <%--    <%=request.getAttribute("userName") != null ? out.println("<p>User '" + request.getAttribute("userName") + "' added!</p>") : ""%>--%>
    <div>
        <div>
            <h2>Add user</h2>
        </div>
        <form method="post">
            <label>Name:
                <input type="text" name="name"><br />
            </label>
            <label>Age:
                <input type="number" name="age"><br />
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