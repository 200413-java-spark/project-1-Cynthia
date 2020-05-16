package com.projectOne.servlets;
import java.io.*;
import java.util.*;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class Results
 */
//@WebServlet("/Results")
public class Results extends HttpServlet {
	private static final long serialVersionUID = 1;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Results() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		//response.getWriter().append("Served at: ").append(request.getContextPath());
//		PrintWriter out = response.getWriter();
//		
//		// Remove this line for functions
//		//double sqrtvalue = Math.sqrt(4.0);
//		
//		
//		// Return results from Spark
//		boolean booleanVar = true;
//		boolean booleanVar2 = false;
//	
//		out.println( "<html><body><h1 align='center'>Image Results</h1>"
//				+ "<br> Tumor present in Image 1: " + booleanVar + "</br>" 
//				+ "<br> Tumor present in Image 2: " + booleanVar2 + "</br>" 
//				+ "</body></html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher("/Display");
		rd.forward(request, response);
		
		String file_name = null;
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		boolean isMultipartContent = ServletFileUpload.isMultipartContent(request);
		if(!isMultipartContent) {
			return;
		}
		FileItemFactory factory = new DiskFileItemFactory();
		ServletFileUpload upload = new ServletFileUpload(factory);
		try {
			
			
			List <FileItem> fields = upload.parseRequest(request);
			Iterator <FileItem> it = fields.iterator();
			if(!it.hasNext()) {
				return;
			}
			while (it.hasNext()) {
				FileItem fileItem = it.next();
				boolean isFormField = fileItem.isFormField();
				if(isFormField) {
					if(file_name == null) {
						if(fileItem.getFieldName().equals("file_name")) {
							file_name = fileItem.getString();
						}
					}
				}else {
					if(fileItem.getSize() > 0) {
						fileItem.write(new File("C:\\uploaded_files\\" + fileItem.getName()));
						
						//////////////////////////////////////////////
//						boolean booleanVar = true; //////// SPARK RETURN
//						
//						PatientBean ptBn = new PatientBean();
//						ptBn.setPatientName(file_name);
//						ptBn.setPatientResult(booleanVar);
						/////////////////////////////////////////////////
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			out.println("<script type='text/javascript'>");
			out.println("window.location.href='index.jsp?filename="+file_name+"'");
			out.println("</script>");
			out.close();
		}
	}
}
