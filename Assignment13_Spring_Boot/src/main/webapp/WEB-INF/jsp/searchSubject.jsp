<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Subject</title>
<script>
var subjectResults = "${subjectResults}";
if(subjectResults!=null && subjectResults.length >1){
	//alert( "subjectResults: "+subjectResults ) ;	
}
</script>
</head>
<body>
<div align="center">subjectResults
<h1 style="color: green">Book Management</h1>
<br>
<h2 style="color: blue">Search Subject</h2>


	<form:form method="post" action="./searchSubject.htm"
		modelAttribute="subject">
		<table>
			<tr>
				<td>Subject ID: </td>
				<td><form:input path="subjectId" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Search Subject"></input></td>
			</tr>
		</table>
	</form:form>
	<br>
	
	<h3 style="color: olive;">Search Results: </h3>
	Subject ID: ${subjectResults.subjectId}<br>
	Subject Title: ${subjectResults.subtitle}<br>
	Duration : ${subjectResults.durationInHours}
	<br>
	<c:forEach items="${subjectResults.references}" var="bookref">
	 ${bookref}
</c:forEach>
	<br>
	<h3 style="color: olive;"><a href="./showmenu.htm">Go to Menu</a></h3>
	</div>
</body>
</html>