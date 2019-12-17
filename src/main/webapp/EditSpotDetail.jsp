<%@ page import="dqtravelspots.entity.Touristspot" %>
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
<jsp:include page="/getSpotDetails"/>
<h1 style="text-align:center; color: darkgreen">Edit Place Details</h1>
<TABLE style="margin-left: auto;margin-right: auto">
    <TR><TD><br></TD></TR>
    <TR>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/index.jsp" class="btn btn-default">Back to Home Screen</a></TD>
    </TR>
</TABLE>
<FORM ACTION="updateSpotDetails" METHOD="get" style="text-align: center; color: darkgreen">
    <br><br>
    <br><br>
    Place ID:<INPUT TYPE="TEXT" NAME="ns_id" size="50" value="<c:out value='${oneSpot.getId()}'/>" readonly/>
    <br><br>
    Planet ID:<INPUT TYPE="TEXT" NAME="ns_planetid" size="50" value="<c:out value='${oneSpot.getPlanetID()}'/>" readonly/>
    <br><br>
    Name:<INPUT TYPE="TEXT" NAME="ns_name" size="50" maxlength="150" required value="<c:out value='${oneSpot.name}'/>"/>
    <br><br>
    Description:<INPUT TYPE="TEXT" NAME="ns_description" size="50" maxlength="500" required value="<c:out value='${oneSpot.description}'/>"/>
    <br><br>
    <% Touristspot tempSpot = (Touristspot) request.getAttribute ("oneSpot");
    String hCap = (String) tempSpot.getHandicapAccess();
    if( hCap.equals("True")) {  %>
    Handicap Accessible?:<INPUT TYPE="checkbox" NAME="ns_handicap" value="HY" checked/>
    <% } else { %>
    Handicap Accessible?:<INPUT TYPE="checkbox" NAME="ns_handicap" value="HY"/>
    <% } %>
    <br><br>
    <% String impOnly = (String) tempSpot.getImperialOnly();
    if( impOnly.equals("True")) {  %>
    Imperial Only?:<INPUT TYPE="checkbox" NAME="ns_imperial" value="IY" checked/>
    <% } else { %>
    Imperial Only?:<INPUT TYPE="checkbox" NAME="ns_imperial" value="IY"/>
    <% } %>
    <br><br>
    <button style="alignment: center" type="submit" class="btn btn-default">Submit</button>
    <button style="alignment: center" type="reset" class="btn btn-default">Reset</button>

</FORM>

</body>
</html>
