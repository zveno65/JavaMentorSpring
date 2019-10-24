<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<html>
<head>
    <title>Users</title>
</head>

<body>

<div>
    <div>
        <div>
            <h2>Users</h2>
        </div>
        <c:set var="name" value="${addName}"/>
        <c:if test="${name != null}">
            <p>User ${name} added!</p>
        </c:if>
        <c:set var="name" value="${editName}"/>
        <c:if test="${name != null}">
            <p>User ${name} edited!</p>
        </c:if>
        <table>
            <thead>
            <tr>
                <th>Name</th>
                <th>Age</th>
                <th>Edit</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="user" items="${users}">
                <tr>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.age}"/></td>
                    <sec:authorize access="hasRole('ROLE_ADMIN')">
                    <td>
                        <a href="/edit?id=<c:out value="${user.id}"/>">Edit</a>
                    </td>
                    <td>
                        <form action="/delete" method="post">
                            <input type="hidden" name="id" value="${user.id}">
                            <button type="submit">Delete</button>
                        </form>
                    </td>
                    </sec:authorize>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<sec:authorize access="hasRole('ROLE_ADMIN')">
<div>
    <button onclick="location.href='/registration'">Add new user</button>
</div>
</sec:authorize>
<div>
    <form action="/logout" method="post">
        <input type="submit" value="Sing out"/>
    </form>
</div>
</body>
</html>