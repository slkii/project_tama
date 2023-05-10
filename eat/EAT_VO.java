package eat;


public class EAT_VO {

	      private int cod ;
	      private int hp =5;
	      private int tr =5;
	      private int pt;
	      private String id;
	      private String na;
	      
	      public EAT_VO() {
	    	  
	      }
	      
		public EAT_VO(int cod, int hp, int tr, int pt, String id, String Dv_ID) {
			
			super();
			this.cod = cod;
			this.hp = hp;
			this.tr = tr;
			this.pt = pt;
			this.id = id;
			this.na = Dv_ID;
		}
		public int getCod() {
			return cod;
		}
		public void setCod(int cod) {
			this.cod = cod;
		}
		public int getHp() {
			return hp;
		}
		public void setHp(int hp) {
			this.hp = hp;
		}
		public int getTr() {
			return tr;
		}
		public void setTr(int tr) {
			this.tr = tr;
		}
		public int getPT() {
			return pt;
		}
		public void setPT(int pt) {
			this.pt = pt;
		}
		public String getId() {
			return id;
		}
		public void setId(String id) {
			this.id = id;
		}
		public String getNa() {
			return na;
		}
		public void setNa(String na) {
			this.na = na;
		}
		
		
	      
	     
	      
	}