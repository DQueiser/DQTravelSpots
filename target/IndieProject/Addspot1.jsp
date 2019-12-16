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
<h1 style="text-align:center; color: darkgreen">Let's add a tourist spot</h1>
<TABLE style="margin-left: auto;margin-right: auto">
    <TR><TD><br></TD></TR>
    <TR>
        <TD><button type="submit" class="btn btn-default">waka waka waka </button></TD>
        <TD style="margin-left: auto;margin-right: auto">     </TD>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/index.jsp" class="btn btn-default">Back to main screen</a></TD>
        <TD style="margin-left: auto;margin-right: auto">     </TD>
        <TD style="margin-left: auto;margin-right: auto"><a href="/IndieProject_war/About.jsp" class="btn btn-default">About This Application</a></TD>
    </TR>
</TABLE>
<FORM ACTION="addSpot2" METHOD="get" style="text-align: center; color: darkgreen">
    <br><br>
    <label style="color: darkgreen">What Planet is this Place on?</label>
    <select name="planet1" style="text-align:center">
        <c:forEach var="mapEntry" items="${planetMap}">
            <option value="<c:out value='${mapEntry.key}'/>"><c:out value="${mapEntry.value}"/></option>
        </c:forEach>
    </select>
    <br><br>
    Name:<INPUT TYPE="TEXT" NAME="ns_name" size="50" maxlength="150" required/>
    <br><br>
    Description:<INPUT TYPE="TEXT" NAME="ns_description" size="50" maxlength="500" required/>
    <br><br>
    Handicap Accessible?:<INPUT TYPE="checkbox" NAME="ns_handicap" value="HY"/>
    <br><br>
    Imperial Only?:<INPUT TYPE="checkbox" NAME="ns_imperial" value="IY"/>
    <br><br>
    <button style="alignment: center" type="submit" class="btn btn-default">Submit</button>
    <button style="alignment: center" type="reset" class="btn btn-default">Reset</button>

</FORM>

</body>
</html>
