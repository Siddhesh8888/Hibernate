<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<jsp:useBean id="ipl" class="beans.IPLBean" scope="application" />
<jsp:setProperty property="*" name="ipl"/>
<body>
	<form action="process_form.jsp" method="get">
		<table style="background-color: lightgrey; margin: auto">
			<tr>
				<td>Select Team</td>
				<td><select name="myTeam">
				<c:forEach var="t" items="${applicationScope.ipl.fetchAllTeams()}">
						<option value="${t.id}">${t.abbrevation}</option>
						</c:forEach>
				</select></td>
			</tr>
			<tr>
				<td>Enter First Name</td>
				<td><input type="text" name="fname" /></td>
			</tr>
			<tr>
				<td>Enter Last Name</td>
				<td><input type="text" name="lname" /></td>
			</tr>
			<tr>
				<td>Enter Email</td>
				<td><input type="text" name="email" /></td>
			</tr>
			<tr>
				<td>Select DoB</td>
				<td><input type="date" name="dob" /></td>
			</tr>
			<tr>
				<td>Enter Batting Average</td>
				<td><input type="number" value="0.00" step="0.01" name="avg" /></td>
			</tr>
			<tr>
				<td>Enter No Of Wickets Taken</td>
				<td><input type="number" name="wickets" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Add A Player" /></td>
			</tr>
		</table>
	</form>
	<%-- <h5>Teams : ${applicationScope.ipl.fetchAllTeams()}</h5> --%>
</body>


</html>