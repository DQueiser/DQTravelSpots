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
This is the USERTRIP screen under construction </br>
<TABLE style="margin-left: auto;margin-right: auto">
    <TR><TD><br></TD></TR>
    <TR>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/Search.jsp" class="btn btn-default">Search a Destination</a></TD>
        <TD style="margin-left: auto;margin-right: auto">     </TD>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/index.jsp" class="btn btn-default">Back to main screen</a></TD>
        <TD style="margin-left: auto;margin-right: auto">     </TD>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/About.jsp" class="btn btn-default">About This Application</a></TD>
    </TR>
</TABLE>

<div class="container-fluid">
    <h2>Search results</h2>
    <br />
    <c:choose>
        <c:when test="${!empty(userTrips)}">
            <table class="table table-striped table-bordered">
                <tr>
                    <th>Location</th>
                    <th>Num POIs</th>
                    <th>Rating</th>
                    <th>Comment</th>
                    <th>Date Reg</th>
                </tr>
                <c:forEach var="userTrip" items="${userTrips}">
                    <tr>
                        <!--<td><a href="/IndieProject_war/UserTripDetail.jsp?trip=<c:out value='${userTrip.id}'/>"><c:out value="${userTrip.cityLocation}" /></a></td>-->
                        <td><a href="/IndieProject_war/searchUserTripDetails?trip=<c:out value='${userTrip.id}'/>"><c:out value="${userTrip.cityLocation}" /></a></td>
                        <td><c:out value="${userTrip.numOfPoints}" /></td>
                        <td><c:out value="${userTrip.rating}" /></td>
                        <td><c:out value="${userTrip.comment}" /></td>
                        <td><c:out value="${userTrip.dateRegistered}" /></td>
                    </tr>
                </c:forEach>
            </table
        </c:when>
        <c:otherwise>
            <p class="validations">No trips were found</p>
        </c:otherwise>
    </c:choose>
</div>

</body>
</html>
