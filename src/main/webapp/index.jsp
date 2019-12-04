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
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <div align="center"> <img src="TravelCollage1.bmp" alt="Default image" title="Travel Scenes"/></div>
    <title>Welcome to the DQTravelSpots application</title>
</head>
<body style="background-color: oldlace">
    <TABLE style="margin-left: auto;margin-right: auto">
        <TR><TD><br></TD></TR>
        <TR>
            <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/Search.jsp" class="btn btn-default">Search a Destination</a></TD>
            <TD style="margin-left: auto;margin-right: auto">     </TD>
            <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/UserTrip.jsp" class="btn btn-default">Review My Trips</a></TD>
            <TD style="margin-left: auto;margin-right: auto">     </TD>
            <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/About.jsp" class="btn btn-default">About This Application</a></TD>
        </TR>
    </TABLE>

</body>
</html>
