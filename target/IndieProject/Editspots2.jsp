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
<h1 style="text-align:center; color: darkgreen">Check out the list of places</h1>
<TABLE style="margin-left: auto;margin-right: auto">
    <TR><TD><br></TD></TR>
    <TR>
        <TD style="margin-left: auto;margin-right: auto">     </TD>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/index.jsp" class="btn btn-default">Back to main screen</a></TD>
        <TD style="margin-left: auto;margin-right: auto">     </TD>
    </TR>
</TABLE>

<div class="container-fluid">
    <h2>Search results</h2>
    <br />
    <c:choose>
        <c:when test="${!empty(tSpots1)}">
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Planet ID</th>
                    <th>Name</th>
                    <th>Description</th>
                </tr>
                <c:forEach var="tourSpot" items="${tSpots1}">
                    <tr>
                        <td><c:out value="${tourSpot.planetID}" /></td>
                        <td><c:out value="${tourSpot.name}" /></td>
                        <td><c:out value="${tourSpot.description}" /></td>
                    </tr>
                </c:forEach>
            </table
        </c:when>
        <c:otherwise>
            <p class="validations">No places were found on that planet</p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
