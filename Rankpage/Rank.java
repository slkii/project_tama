package Rankpage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;

public class Rank {

   private Connection conn = null;
   PreparedStatement pst = null;
   ResultSet rs = null;
   public void connect() {
      try { // 컨트롤러
         Class.forName("oracle.jdbc.driver.OracleDriver");

         String url = "jdbc:oracle:thin:@211.228.36.134:1521:xe"; // localhost 자리에 ip 적어주면 해당 ip DB에 접속 가능
         String user = "C##PROJECT";
         String password = "12345";

         conn = DriverManager.getConnection(url, user, password);

         if (conn == null) { // 원래 view 가 맞음 이번엔 컨트롤러
            System.out.println("연결실패.....ㅠㅠ");
         } 

      } catch (Exception e) {
         e.printStackTrace();
      }

   } // connect

   public ArrayList<RankVO> select()  {
      
      connect();
      
      ArrayList<RankVO> allRank = new ArrayList<>();
      
      //update [table] set 값 = ' ', 
//      ArrayList<RankVO> allRank = new ArrayList<RankVO>();
      try {
         
    	  String sql = "SELECT Dv_ID, pt FROM DeveloperStatus order by pt desc "; //GROWNINGDEV 테이블 -> DeveloperStatus
//    	  pst.setString(1, Dv_ID);
//    	  pst.setInt(2, pt);
         pst = conn.prepareStatement(sql);
         
         rs = pst.executeQuery();
         
         while (rs.next()) {
        	 
//			rs.getString(1);
//             rs.getInt(2);
//            rs.getInt(3);
//            rs.getInt(4);
//            rs.getInt(5);

            RankVO ra = new RankVO(rs.getString(1), rs.getInt(2));
            allRank.add(ra);
            
         }
//         return allRank;
       
         
      } catch (SQLIntegrityConstraintViolationException e) {
    
      }
      catch (Exception e) {
         e.printStackTrace();
      }finally {
    		try {
    			if(rs != null) {
				rs.close();
    			}
    			if(pst != null) {
    				pst.close();
    			}
    			if(conn != null) {
    				conn.close();
    			}
			} catch (SQLException e) {
				e.printStackTrace();
			}
    	}
      
      return allRank;
//      return null;
      
   } // select 끝

}