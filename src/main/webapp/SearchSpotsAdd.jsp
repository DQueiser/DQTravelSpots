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
<jsp:include page="/searchSpotsAdd1"/>
<h1 style="text-align:center; color: darkgreen">Adding a Favorite</h1>
<TABLE style="margin-left: auto;margin-right: auto">
    <TR><TD><br></TD></TR>
    <TR>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/Search.jsp" class="btn btn-default">Search another Planet</a></TD>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/index.jsp" class="btn btn-default">Back to main screen</a></TD>
    </TR>
</TABLE>

<div class="container-fluid">
    <h2>Favorite has been added</h2>
</div>

</body>
</html>
