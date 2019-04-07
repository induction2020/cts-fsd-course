<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Subject</title>
<script>
var data = "${response}";
if(data!=null && data.length >1){
	alert( "data: "+data ) ;	
}

</script>
</head>
<body>
<div align="center">
<h1 style="color: green">Book Management</h1>
<br>
<h2 style="green">Add Subject</h2>

	<form:form method="post" action="./addSubject.htm"
		modelAttribute="subject">
		<table>
			<tr>
				<td>Subject ID: </td>
				<td><form:input path="subjectId" /></td>
			</tr>
			<tr>
				<td>Subject Title: </td>
				<td><form:input path="subtitle" /></td>
			</tr>
			<tr>
				<td>Duration In Hours: </td>
				<td><form:input path="durationInHours" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Subject"></input></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3 style="color: olive;"><a href="./showmenu.htm">Go to Menu</a></h3>
</div>

</body>
</html>