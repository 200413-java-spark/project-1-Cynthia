package com.projectOne.servlets;
import java.sql.*;

public class PatientDAO {
	
	static Connection conn;
	static PreparedStatement pst;
	
	public static void processSpark() {
		
	}
	
	public static int insertPatient(PatientBean u) { //PatientBean u
		int status=0;
		try {
			conn=ConnectionProvider.getCon();
			pst=conn.prepareStatement("insert into classificationResults(patientname, patientresult) values(?,?)");
			pst.setString(1, u.getPatientName());// u.getPatientName() "hi"
			pst.setString(2, u.getPatientResult());// u.isPatientResult() "false"
			status=pst.executeUpdate();
			conn.close();
			
		} catch(Exception ex){
			System.out.println(ex);
		}
		
		return status;
	}

}
