package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Databasetest {

	public static void main(String[] args) {

		Connection con = null;
		
		Statement st; // sql문장 실행
	
		ResultSet rs; //실행된 결과
		
	
		try {
			
			con = (Connection)DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/POS" , "root" , "root");
			st = con.createStatement();
			
			if(con != null) {
				
			
			    System.out.println("데이터베이스가 연결되었습니다 ");
				
			}
		}
			catch(Exception e) {
			System.out.println("데이터베이스 연결 오류 " + e.getMessage());
		}
		
	}
	
}