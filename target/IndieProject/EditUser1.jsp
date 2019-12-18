<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <div align="center"> <img src="TravelCollage2.bmp" alt="Default image" title="Travel Scenes"/></div>
    <title>Welcome to the DQTravelSpots application</title>
</head>

<body style="background-color: oldlace">
<jsp:include page="/searchUsers1"/>
<h1 style="text-align:center; color: darkgreen">Users of this Application</h1>
<TABLE style="margin-left: auto;margin-right: auto">
    <TR><TD><br></TD></TR>
    <TR>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/index.jsp" class="btn btn-default">Back to main screen</a></TD>
    </TR>
</TABLE>

<div class="container-fluid">
    <br />
    <c:choose>
        <c:when test="${!empty(userList1)}">
            <table class="table table-striped table-bordered">
                <tr>
                    <th>User ID</th>
                    <th>Username</th>
                    <th>Date Registered</th>
                    <th>Update?</th>
                    <th>Delete?</th>
                </tr>
                <c:forEach var="userThing" items="${userList1}">
                    <tr>
                        <td><c:out value="${userThing.getId()}" /></td>
                        <td><c:out value="${userThing.userName}" /></td>
                        <td><c:out value="${userThing.dateRegistered}" /></td>
                        <td>Edit</td>
                        <td><a href="/IndieProject_war/deleteUsers1?user=<c:out value='${userThing.getId()}'/>">Delete</a></td>
                        <!--<td><c:out value="${tourSpot.handicapAccess}" /></td>
                        <td><c:out value="${tourSpot.imperialOnly}" /></td>-->
                    </tr>
                </c:forEach>
            </table
        </c:when>
        <c:otherwise>
            <p class="validations">How on Earth are there no Users?!?!</p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
