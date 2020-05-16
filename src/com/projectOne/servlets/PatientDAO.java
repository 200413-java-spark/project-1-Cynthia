package com.projectOne.servlets;
import java.sql.*;

public class PatientDAO {
	
	static Connection conn;
	static PreparedStatement pst;
	
	public static void processSpark() {
		
	}
	
	public static int insertPatient() { //PatientBean u
		int status=0;
		try {
			conn=ConnectionProvider.getCon();
			pst=conn.prepareStatement("insert into classificationResults(patientname, patientresult) values(?,?)");
			pst.setString(1, "hi");// u.getPatientName()
			pst.setBoolean(2, false);// u.isPatientResult()
			status=pst.executeUpdate();
			conn.close();
			
		} catch(Exception ex){
			System.out.println(ex);
		}
		
		return status;
	}

}
