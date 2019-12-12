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
    <div align="center"> <img src="TravelCollage2.bmp" alt="Default image" title="Travel Scenes"/></div>
    <title>Goodbye!</title>
</head>
<body style="background-color: oldlace">
<FORM>
    <TABLE style="margin-left: auto;margin-right: auto">
        <TR><TD><br></TD></TR>
        <TR><th>You have been logged out. Have a nice day.</th></TR>
        <TR>
            <TD><a href="/IndieProject_war/index.jsp" class="btn btn-default">Log back in</a></TD>
        </TR>
    </TABLE>
</FORM>
</body>
</html>
