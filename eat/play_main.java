package eat;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Mainpage.View;



public class play_main  {
	
	private static final String String = null;
	EAT_VO EV = new EAT_VO();
	Mainpage.View Dv_ID = new Mainpage.View();
	public int COD;
	public int HP=5;
	public int TR;
	public int PT;
	public int result; // 메인페이지 패키지에서 쓰기 위해 변수를 public 으로 돌려서 모두가 사용할 수 있게 선언.
	
	 private Connection conn;
	 private PreparedStatement pst = null;
	 private ResultSet rs = null;
	
	public void connect() {
	      try { 
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

	   } 
	
	
	
	//셀렉트
	
	public  ArrayList<EAT_VO> select() {
        // 테이블에 저장된 모든 정보를 select해서 ArrayList로 타입으로 return받기 
   
   connect();
   
   //ArryList 만들어주기 
   ArrayList<EAT_VO> alllist = new ArrayList<>();
   
   String sql = "select * from DeveloperStatus";    //테이블정보가져오기 
//   PreparedStatement pst = null;

   try {
      pst = conn.prepareStatement(sql);

      rs = pst.executeQuery();
//      pst.setString(1, Dv_ID);
      while (rs.next()) { // return boolean타입
         
         String ID = rs.getString(1);
         String Dv_ID = rs.getString(2); //
         int cod = rs.getInt(3);
         int hp = rs.getInt(4);
         int tr = rs.getInt(5);
         int pt = rs.getInt(6);
         
      
         EAT_VO list =new EAT_VO(cod, hp, tr, pt,"" ,"");
         
         
         alllist.add(list);  //->ArrayList while 밖에서 만들어주고 추가는 while문 안에서 
         
   
         
      }//while 끝 
      return alllist;   
      //return alllist ;    //ArrayList 리턴 받으니까 
      
   } catch (SQLException e) {
      e.printStackTrace();
   }finally {
	   close();
   }
   
   return null;

}
	
	
	
	
	
	
	
	
	
	//업데이트
	public int Update(int cod, int hp, int tr, int pt, String Dv_ID) {

	      connect();
	      
	      pst = null;
	      
	      String sql = "UPDATE DeveloperStatus SET cod = ?, hp = ?, tr = ?, pt = ? WHERE Dv_ID = ? ";
//	      ResultSet sc;
//		String info = Mainpage.View.ID(sc.next());
	      int cnt = 0;

	      try {
	         pst = conn.prepareStatement(sql);
	         pst.setInt(1, cod);
	         pst.setInt(2, hp);
	         pst.setInt(3, tr);
	         pst.setInt(4, pt);
	         pst.setString(5, Dv_ID);
//	         pst.setString(5, Dv_ID); //  데이터베이스에 있는 Dv_ID -> view 에서 입력받은 개발자이름값을 대입해야함.

	         cnt = pst.executeUpdate();

	      } catch (SQLException e) {
	         e.printStackTrace();
	      }finally {
	    	  close();
	      }
	      
	      return cnt;

//	      return 0;
	   }



	private void close() {
		try {
			if(rs != null) {
				rs.close();
			}
			if(pst != null) {
				pst.close();
			}
			if(conn!= null) {
				conn.close();
			}
		} catch (Exception e2) {
			// TODO: handle exception
		}
	}

	
	//키우기메소드들
	
	public void coding() {

		COD += 1;
		HP -= 1;
		TR += 1;
		PT = (COD + HP) - TR;
		
		Update(COD, HP, TR, PT,"");
		
	}

	public void eat() {

		COD += 0;
		HP += 1;
		TR += 0;
		PT = (COD + HP) - TR;
		
//		COD = EV.getCod() + 0;
//		HP = EV.getHp() + 1;
//		TR = EV.getTr() + 0;
//		PT = (COD + HP)- TR;
//		EV.setPT(PT);
		
		int cnt = Update(COD, HP, TR, PT, "");
		
	}

	public void sleep() {

		COD += 0;
		HP += 0;
		TR -= 1;
		PT = (COD + HP) - TR;
		
		Update(COD, HP, TR, PT, "");

	}
	public void check() {
	      
	    System.out.println("코딩능력 : " + COD + " / " + "체력 : "+ HP + " / " + "피로도 : "+TR + " / " + "포인트 : " + PT);
	    
	   }

}
