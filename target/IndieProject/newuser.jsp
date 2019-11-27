<%@ page import="netscape.javascript.JSObject" %>
<%@ page import="java.io.ObjectInputStream" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
    <title>Add New User</title>
</head>
<body style="background-color: oldlace">
<h1 style="text-align:center; color: darkgreen">Register a New User</h1>
<FORM ACTION="addNewUser" METHOD="POST">

    <TABLE style="margin-left: auto;margin-right: auto">
        <TR>
            <TD>First Name: </TD>
            <TD><INPUT TYPE="TEXT" NAME="nu_firstname"></TD>
        </TR>
        <TR><TD><br></TD></TR>
        <TR>
            <TD>Last Name: </TD>
            <TD><INPUT TYPE="TEXT" NAME="nu_lastname"></TD>
        </TR>
        <TR><TD><br></TD></TR>
        <TR>
            <TD>User Name: </TD>
            <TD><INPUT TYPE="TEXT" id="txtUserName" NAME="nu_username"></TD>
        </TR>
        <TR><TD><br></TD></TR>
        <TR>
            <TD>Email Address: </TD>
            <TD><INPUT TYPE="TEXT" NAME="nu_email"></TD>
        </TR>
        <TR><TD><br></TD></TR>
        <TR>
            <TD>Password: </TD>
            <TD><INPUT TYPE="PASSWORD" NAME="nu_pass1"></TD>
        </TR>
        <TR><TD><br></TD></TR>
        <TR>
            <TD>Confirm Password: </TD>
            <TD><INPUT TYPE="PASSWORD" NAME="nu_pass2"></TD>
        </TR>
        <TR><TD><br></TD></TR>
        <TR>
            <TD><button type="submit" class="btn btn-default">Submit</button></TD>
            <TD><button type="reset" class="btn btn-default">Reset</button></TD>
        </TR>
    </TABLE>


</FORM>
</body>
</html>
