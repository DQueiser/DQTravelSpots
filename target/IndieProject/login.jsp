<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <title>Welcome!</title>
</head>
<body style="background-color: oldlace;">
    <h1 style="text-align:center; color: darkgreen">DQTravelSpots - Find your place in the Galaxy</h1>
    <FORM ACTION="j_security_check" METHOD="POST">
        <TABLE style="margin-left: auto;margin-right: auto">
            <TR>
                <TD>User name: </TD>
                <TD><INPUT TYPE="TEXT" NAME="j_username"></TD>
                <TD></TD>
            </TR>
            <TR><TD><br></TD></TR>
            <TR>
                <TD>Password: </TD>
                <TD><INPUT TYPE="PASSWORD" NAME="j_password"></TD>
                <TD></TD>
            </TR>
            <TR><TD><br></TD></TR>
            <TR>
                <!--<TD><INPUT TYPE="SUBMIT" VALUE="Log In"></TD> -->
                <TD><button type="submit" class="btn btn-default">Submit</button></TD>
                <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/newuser.jsp" class="btn btn-default">Create a New User</a></TD>
                <TD><button type="reset" class="btn btn-default">Reset</button></TD>
            </TR>
        </TABLE>
    </FORM>
</body>
</html>


