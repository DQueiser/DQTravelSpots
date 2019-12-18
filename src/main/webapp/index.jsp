<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <div align="center"> <img src="TravelCollage2.bmp" alt="Default image" title="Travel Scenes"/></div>
    <title>Welcome to the DQTravelSpots application</title>
</head>
<body style="background-color: oldlace">
<h1 style="text-align:center; color: darkgreen">Home Menu</h1>
<FORM ACTION="/IndieProject_war/FaveReview1.jsp" METHOD="GET">
    <TABLE style="margin-left: auto;margin-right: auto">
        <TR><TD><br></TD></TR>
        <TR>
            <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/Search.jsp" class="btn btn-default">Search for a Place</a></TD>
            <TD><button type="submit" class="btn btn-default">Review my Favorites</button></TD>
            <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/Addspot1.jsp" class="btn btn-default">Add a Place</a></TD>
            <TD style="padding-right: 50px"></TD>
            <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/Editspot1.jsp" class="btn btn-warning">Edit a Place</a></TD>
            <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/EditUser1.jsp" class="btn btn-warning">Edit Users</a></TD>
            <TD style="padding-right: 50px"></TD>
            <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/About.jsp" class="btn btn-info">About This Application</a></TD>
            <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/logout.jsp" class="btn btn-info">Logout</a></TD>
        </TR>
    </TABLE>
</FORM>
</body>
</html>
