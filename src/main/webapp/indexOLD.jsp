<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    session = request.getSession(false);
    if (session!=null)
    {
        session.invalidate();
    }
%>
<html>
<head>
    <title>Generic Startup JSP</title>
</head>
<body style="background-color: oldlace">
Hey, man. What's up? </br>
<ul>
    <li><a href="newuser.jsp">I want to add a new user</a></li>
    <li><a href="tripsearch.jsp">I'm a real user and want to do a search</a></li>
</ul>

</body>
</html>
