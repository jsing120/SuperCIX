<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
	<title>File Upload</title>
</head>
<body>
<form:form method="POST" action="uploaded.do" modelAttribute="uploadForm" enctype="multipart/form-data">
${message} &nbsp;<input type="file" name="uploadedFile">
<br><hr>
 <input type="submit" value="Submit HTML File"/>

</form:form>
</body>
</html>