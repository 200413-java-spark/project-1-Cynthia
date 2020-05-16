package com.projectOne.servlets;
import java.sql.*;

public class PatientDAO {
	
	static Connection conn;
	static PreparedStatement pst;
	
	public static int insertPatient(PatientBean u) {
		int status=0;
		try {
			conn=ConnectionProvider.getCon();
			pst=conn.prepareStatement("insert into patient values(?,?)");
			pst.setString(1, u.getPatientName());//
			pst.setBoolean(2, u.isPatientResult());
			status=pst.executeUpdate();
			conn.close();
			
		} catch(Exception ex){
			System.out.println(ex);
		}
		
		return status;
	}

}
