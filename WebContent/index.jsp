<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>File Upload to Database</title>
</head>
<body>
	<center>
		<h1>Automated Gray Matter to White Matter Ratio Processor</h1>
		<h2>Please upload region of interest (ROI) to database</h2>
		<form method="post" action="Results" enctype="multipart/form-data">
			<table>
				<tr>
					<td>Enter Image Volume Name</td>
					<td><input type="text" name="file_name"/></td>
				</tr>
				<tr>
					<td>Upload Volume:</td>
					<td><input type="file" name="volume" /></td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="Upload">
					</td>
				</tr>
			</table>
		</form>
		
		<%
		String file_name = (String)request.getParameter("filename");
		if(file_name!=null){
			out.println(file_name+" File uploaded successfuly");
			
			/**
			* INSERT SPARK
			*/			
			
			// Return results from Spark	
	
			out.println( "<html><body><h1 align='center'>Image Results</h1>"
					+ "<br> Tumor present in </br>" 
					+ "</body></html>");
		}
		
		%>
		
	</center>
</body>
</html>