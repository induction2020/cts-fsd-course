<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search Book</title>
</head>
<body>
<div align="center">
<h1 style="color: green">Book Management</h1>
<br>
<h2 style="green">Search Book</h2>

	<form:form method="post" action="./searchBook.htm"
		modelAttribute="book">
		<table>
			<tr>
				<td>Book ID: </td>
				<td><form:input path="bookId" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Search Book"></input></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3 style="color: olive;"><a href="./showmenu.htm">Go to Menu</a></h3>
	<br>
	<h3 style="color: olive;">Search Results: </h3>
	<br>
	Book ID : ${bookResults.bookId}
	<br>
	Subject ID : ${bookResults.subjectId}
	<br>
	Title : ${bookResults.title}
	<br>
	Price : ${bookResults.price}
	<br>
	Publish Date : ${bookResults.publishDate}
	<br>
	
</div>
</body>
</html>