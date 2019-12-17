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
<jsp:include page="/popuPlanet1"/>
<h1 style="text-align:center; color: darkgreen">Searching Places</h1>
<TABLE style="margin-left: auto;margin-right: auto">
    <TR><TD><br></TD></TR>
    <TR>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/index.jsp" class="btn btn-default">Back to Home screen</a></TD>
    </TR>
</TABLE>
<FORM ACTION="/IndieProject_war/SearchSpots1.jsp" METHOD="get" style="text-align: center; color: darkgreen">
    <br><br>
    <label style="color: darkgreen">What Planet are we going to?</label>
    <select name="planet1" style="text-align:center">
        <c:forEach var="mapEntry" items="${planetMap}">
            <option value="<c:out value='${mapEntry.key}'/>"><c:out value="${mapEntry.value}"/></option>
        </c:forEach>
    </select>
    <br><br>
    <button style="alignment: center" type="submit" class="btn btn-default">Submit</button>

</FORM>

</body>
</html>
