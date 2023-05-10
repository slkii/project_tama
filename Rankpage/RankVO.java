package Rankpage;

public class RankVO { 
	
//private String id;
private String Dv_ID;
//private int cod;
//private int hp;
//private int tr;
private int pt;


//public RankVO(String Dv_ID, int pt) {
//   super();
//   
////   this.id = id;
//   this.Dv_ID = Dv_ID;
////   this.cod = cod;
////   this.hp = hp;
////   this.tr = tr;
//   this.pt = pt;
//}




public RankVO(String Dv_ID, int pt) {
   super();
   this.Dv_ID = Dv_ID;
   this.pt = pt;
}




public RankVO() {
   super();
}


//public String getId() {
//   return id;
//}

//public void setId(String id) {
//   this.id = id;
//}

public String getNa() {
   return Dv_ID;
}

public void setNa(String Dv_ID) {
   this.Dv_ID = Dv_ID;
}

//public int getCod() {
//   return cod;
//}
//
//public void setCod(int cod) {
//   this.cod = cod;
//}
//
//public int getHp() {
//   return hp;
//}
//
//public void setHp(int hp) {
//   this.hp = hp;
//}
//
//public int getTr() {
//   return tr;
//}
//
//public void setTr(int tr) {
//   this.tr = tr;
//}

public int getPt() {
   return pt;
}

public void setPt(int pt) {
   this.pt = pt;
}




}


