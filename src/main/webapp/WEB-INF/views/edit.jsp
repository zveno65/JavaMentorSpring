<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>edit user</title>
</head>

<body>
<div>
    <div>
        <div>
            <h2>edit user</h2>
        </div>
        <form method="post">
            <label>Name:
                <input type="text" name="name" value="${user.getName()}"><br />
            </label>
            <label>Age:
                <input type="number" name="age" value="${user.getAge()}"><br />
            </label>
            <button type="submit">Submit</button>
        </form>
    </div>
</div>

<div>
    <form action="/logout" method="post">
        <input type="submit" value="Sing out"/>
    </form>
</div>

<div>
    <button onclick="location.href='../..'">Back to main</button>
</div>

</body>
</html>