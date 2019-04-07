<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Book</title>

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
<h2 style="green">Add Book</h2>

	<form:form method="post" action="./addBook.htm"
		modelAttribute="book">
		<table>
			<tr>
				<td>Subject ID: </td>
				<td><form:input path="subjectId" /></td>
			</tr>
			<tr>
				<td>Book ID: </td>
				<td><form:input path="bookId" /></td>
			</tr>
			<tr>
				<td>Title: </td>
				<td><form:input path="title" /></td>
			</tr>
			<tr>
				<td>Price: </td>
				<td><form:input path="price" /></td>
			</tr>
			<tr>
				<td>Volume: </td>
				<td><form:input path="volume" /></td>
			</tr>
			<tr>
				<td>PublishDate: </td>
				<td><form:input path="publishDate" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input type="submit" value="Add Book"></input></td>
			</tr>
		</table>
	</form:form>
	<br>
	<h3 style="color: olive;"><a href="./showmenu.htm">Go to Menu</a></h3>
</div>

</body>
</html>