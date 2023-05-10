package 개발자등록page;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class 캐릭터생성 {

   

private Connection conn;

   public void connect() {
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");

         String url = "jdbc:oracle:thin:@211.228.36.134:1521:xe";
         String user = "C##project";
         String password = "12345";

         conn = DriverManager.getConnection(url, user, password);

         if (conn == null) {
            System.out.println("연결실패");
         } else {
            System.out.println("연결성공");
         }

      } catch (Exception e) {

         e.printStackTrace();
      }
   }

   public int insert_Status(String ID, String Dv_ID, int COD, int HP, int TR, int pt) { //insert -> insert_Status 로 변경
      // *****connect() 호출하기
      connect();
      String sql = "insert into DeveloperStatus values (?, ?, ?, ?, ?, ?)"; // 값 변경해둠
      PreparedStatement pst = null;

      try {
         pst = conn.prepareStatement(sql);
         pst.setString(1, ID);
         pst.setString(2, Dv_ID);
         pst.setInt(3, 0);
         pst.setInt(4, 5);
         pst.setInt(5, 5);
         pst.setInt(6, 0);

         int cnt = pst.executeUpdate();

         System.out.println(cnt);
         return cnt;
         // try 리턴값

      } catch (SQLException e) {

         e.printStackTrace();

      } finally {

         try {
            pst.close();
            conn.close();

         } catch (SQLException e) {

            e.printStackTrace();
         }

      }

      return 0;
      // insert 메소드 리턴값

   
}

}
