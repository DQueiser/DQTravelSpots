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
    <title>Welcome to the DQTravelSpots application</title>
</head>
<body style="background-color: oldlace">
This is going to be the main screen, protected for users. No links on this page either </br>
<ul>
    <li><a href="newuser.jsp">I want to add a new user</a></li>
    <li><a href="tripsearch.jsp">I'm a real user and want to do a search</a></li>
</ul>

</body>
</html>
