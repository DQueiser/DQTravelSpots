<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Trip Search Results</title>
</head>
<body style="background-color: antiquewhite">

<div class="container-fluid">
    <h2>Search results</h2>
    <br />
    <table border="1">
        <tr>
            <th>City</th>
            <th>Rating</th>
            <th>Comment</th>
        </tr>
        <c:forEach items="${userTrips}" var="thisUserTrip">
            <tr>
                <td>
                    <c:out value="${thisUserTrip.getCityLocation()}" />
                </td>
                <td>
                    <c:out value="${thisUserTrip.getRating()}" />
                </td>
                <td>
                    <c:out value="${thisUserTrip.getComment()}" />
                </td>
            </tr>
        </c:forEach>
    </table

</div>


</body>
</html>
