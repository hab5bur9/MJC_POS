package pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

public class Databasejisung {

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
			
			String sql = "select * from headoffice";
			rs = st.executeQuery(sql);
			System.out.println(sql);
			
			ResultSetMetaData rsmd = rs.getMetaData();

			// 열의 개수
			int colCount = rsmd.getColumnCount();

			System.out.println("열의 개수:" + colCount);

			// 커서가 맨 마지막 행으로 이동

			rs.last();

			// 행의 개수

			int rowCount = rs.getRow();

			System.out.println("행의 개수:" + rowCount);

			// 열제목 출력

			for (int i=1; i<=colCount; i++) {

				System.out.print(rsmd.getColumnName(i) + "\t");

			}

			System.out.println("\n");

			

			// 첫번째 행으로 커서 이동

			// rs.first();

			// 마지막 행 바로 다음으로 커서 이동

			// rs.afterLast();

			// 지정된 커서 행으로 이동

			// rs.absolute(2);;

			// 첫행 바로 이전으로 커서 이동 (초기 위치)

			rs.beforeFirst();

			

//			while (rs.next()) {

//				

//			}

			

			for (int r=1; r<=rowCount; r++) { // 행

				rs.next();

				for (int c=1; c<=colCount; c++) { // 열

					System.out.print(rs.getObject(c) + "\t");

				}

				System.out.println();

			}

			
		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			if (rs != null) {

				try {

					rs.close();

				} catch (SQLException e) {

					e.printStackTrace();

				}

			}

			if (st != null) {

				try {

					rs.close();

				} catch (SQLException e) {

					e.printStackTrace();

				}

			}

			if (con != null) {

				try {
					rs.close();
					
				} catch (SQLException e) {

					e.printStackTrace();
				}
			}
		
		}
		

	}


}


