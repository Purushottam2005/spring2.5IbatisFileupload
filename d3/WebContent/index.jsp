<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="/ckeditor/ckeditor.js"></script>
</head>
<body>
	d3 asdfasdf
	<form method="post">
		<p>
			My Editor:<br>
			<textarea name="editor1">&lt;p&gt;Initial value.&lt;/p&gt;</textarea>
			<script>
				CKEDITOR.replace('editor1', {
					filebrowserBrowseUrl : '/browser/browse.php?type=Images',
					filebrowserUploadUrl : '/upload.do?type=Files'
				});
			</script>
		</p>
		<p>
			<input type="submit">
		</p>
	</form>
</body>
</html>