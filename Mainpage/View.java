package Mainpage;

import java.util.ArrayList;
import java.util.Scanner;

import Rankpage.RankVO;
import eat.EAT_VO;
import eat.play_main;
import 개발자등록page.캐릭터생성;

public class View {

	private static Object Insert;

	public static void main(String[] args) {
		int cnt;
		String ID = null;
		String Dv_ID = null;
		Scanner sc = new Scanner(System.in);
		while(true) {
			
		System.out.println("                  _  _                                        _      _ \r\n"
				+ "                 | |(_)                                      | |    | |\r\n"
				+ "  ___   ___    __| | _  _ __    __ _  __      __  ___   _ __ | |  __| |\r\n"
				+ " / __| / _ \\  / _` || || '_ \\  / _` | \\ \\ /\\ / / / _ \\ | '__|| | / _` |\r\n"
				+ "| (__ | (_) || (_| || || | | || (_| |  \\ V  V / | (_) || |   | || (_| |\r\n"
				+ " \\___| \\___/  \\__,_||_||_| |_| \\__, |   \\_/\\_/   \\___/ |_|   |_| \\__,_|\r\n"
				+ "                                __/ |                                  \r\n"
				+ "                               |___/                                   ");	
			
		System.out.print("[1]회원가입 [2]로그인 [3]회원탈퇴 [4]프로그램 종료 >> ");
		int num = sc.nextInt();
		int count = 0; // 실행 -> 넘어가기
		int mcount =0; // 키우기 -> 넘어가기
		if(count == 0) {
		 if (num==1) { // 회원가입 Q_101
			DS_DAO signup = new DS_DAO(); //DS_DAO 를 Signup 객체로 
			
			System.out.print("사용하실 ID 를 입력하세요 >> ");
			ID = sc.next();
			
			System.out.print("사용하실 password를 입력하세요 >> ");
			String password = sc.next();
			cnt = signup.Signup(ID, password);
			if(cnt >0) {
				System.out.println("등록되었습니다.");
			} else {
				System.out.println("중복된 ID 입니다.");
			}
		} else if(num==2) { //로그인 Q_104
			DS_DAO login = new DS_DAO(); 
			
			System.out.print("접속하실 ID를 입력하세요 >> ");
			ID = sc.next();
			System.out.print("패스워드를 입력하세요 >> ");
			String password = sc.next();
			
			cnt = login.login(ID, password);
			if(cnt==1) {
				System.out.println("로그인 성공!");
				count++;
			
				 // 로그인 성공시 메인페이지 출력 멈추고 위의 메소드 실행.
			} else if(cnt==0) {
				System.out.println("패스워드가 틀립니다.");
			} else if(cnt==-1) {
				System.out.println("존재하지 않는 ID 입니다.");
			} 
			
			
		} else if (num == 3) { // 회원탈퇴 Q_102
		
			
			DS_DAO signup_delete = new DS_DAO();
			
			System.out.print("탈퇴하실 회원ID를 입력하세요 >> ");
			ID = sc.next();
			
			 cnt = signup_delete.Signup_delete(ID);
			if(cnt >0) {
				System.out.println("입력하신 ID가 삭제되었습니다.");
			} else {
				System.out.println("존재하지 않는 ID 입니다.");
			}
			
		} else if (num == 4) { //프로그램 종료 Q_103
			
			System.out.print("프로그램을 종료합니다.");
			break;
		}
	}//count =0일때 실행구문
		
		 if (count ==1) {
			System.out.println("개발자 키우기가 로드되었습니다.");
			System.out.println();
//			String ID = "";
//			String Dv_ID = "";
			while(true) {
				System.out.println("=================================");
			
			System.out.print("[1]개발자 등록 [2]개발자 키우기 [3]랭킹 조회 [4]로그아웃 >> "); //기능 3개 구현, 로그아웃 추가, 정의서에 수정
			System.out.println();
			System.out.println("=================================");
			int num1 = sc.nextInt();
			
			if(num1 ==1 ) { //개발자등록 실행
				System.out.print("사용자 ID 입력 >> ");
				ID = sc.next();
				System.out.print("등록하실 개발자 닉네임 >> ");
				Dv_ID = sc.next();
				캐릭터생성 insert_Status = new 캐릭터생성();
				cnt = insert_Status.insert_Status(ID,Dv_ID,0,5,5,0); // 개발자등록 객체 생성
			
				if(cnt>0) {
					System.out.println("개발자가 생성되었습니다.");
				} else {
					System.out.println("중복된 개발자이름 입니다.");
				}
			} else if(num1 ==2) { //개발자 키우기 실행
				
				mcount++;
				if(mcount == 1) {
//					eat.EAT_VO pig = new eat.EAT_VO(0, 5, 5, 0,null,null);
//					Scanner scan = new Scanner(System.in);
//					eat.play_main pm = new eat.play_main();
							
					eat.EAT_VO pig = new eat.EAT_VO(0, 5, 5, 0,null,null);
					Scanner scan = new Scanner(System.in);
					eat.play_main pm = new eat.play_main();
					ArrayList<eat.EAT_VO> all = pm.select();
					      
//					      System.out.println("==정보 불러오기 !!==");
					      
//					      ArrayList<eat.EAT_VO> all = pm.select(); 
//				        for (int i =0; i<all.size(); i++) {
//					         System.out.print(all.get(i).getCod());
//					         System.out.print(all.get(i).getHp());
//					         System.out.print(all.get(i).getTr());
//					         System.out.print(all.get(i).getTotalPT());
//					         
//					      }
					while(true) { // 개발자 키우기 반복실행
					System.out.print("[1] 코딩하기 [2] 밥먹기 [3] 잠자기 [4] 조회 [5] 그만하기 >> "); //종료 -> 그만하기로 변경
				int cho = sc.nextInt();
				if (cho == 1) {
					pm.coding();
					System.out.println();
					System.out.println("      　  ┌─────────────────────────┐");
					System.out.println("    　    │코딩공부 시작.. 싫지만 해야해..│");
					System.out.println("   　     │      java..java...      │");
					System.out.println("  　      └─────────────────────────┘");
					System.out.println("==================현재POINT==================");
					System.out.println("코딩 : " + pm.COD + " / " + "체력 : " + pm.HP + " / " + "피로도 : " + " " + pm.TR
							+ " / 총 포인트 = " + pm.PT);
					System.out.println("============================================");
					System.out.println("");

					if (pm.HP >= 10) {
						System.out.println();
						System.out.println("______  _____  _____                        \r\n"
								+ "|  _  \\|_   _||  ___|                       \r\n"
								+ "| | | |  | |  | |__             __ _   __ _ \r\n"
								+ "| | | |  | |  |  __|           / _` | / _` |\r\n"
								+ "| |/ /  _| |_ | |___  _  _  _ | (_| || (_| |\r\n"
								+ "|___/   \\___/ \\____/ (_)(_)(_) \\__, | \\__, |\r\n"
								+ "                                __/ |  __/ |\r\n"
								+ "                               |___/  |___/ ");
						System.out.println("[과식사] 성인병으로 사망하였습니다...");
						System.out.println();
						
						break;
					}
					if (pm.HP < 1) {
						System.out.println();
						System.out.println("______  _____  _____                        \r\n"
								+ "|  _  \\|_   _||  ___|                       \r\n"
								+ "| | | |  | |  | |__             __ _   __ _ \r\n"
								+ "| | | |  | |  |  __|           / _` | / _` |\r\n"
								+ "| |/ /  _| |_ | |___  _  _  _ | (_| || (_| |\r\n"
								+ "|___/   \\___/ \\____/ (_)(_)(_) \\__, | \\__, |\r\n"
								+ "                                __/ |  __/ |\r\n"
								+ "                               |___/  |___/ ");
						System.out.println("[아사] 굶어죽었습니다...");
						System.out.println();
						break;
					}
					if (pm.TR >= 10) {
						System.out.println();
						System.out.println("______  _____  _____                        \r\n"
								+ "|  _  \\|_   _||  ___|                       \r\n"
								+ "| | | |  | |  | |__             __ _   __ _ \r\n"
								+ "| | | |  | |  |  __|           / _` | / _` |\r\n"
								+ "| |/ /  _| |_ | |___  _  _  _ | (_| || (_| |\r\n"
								+ "|___/   \\___/ \\____/ (_)(_)(_) \\__, | \\__, |\r\n"
								+ "                                __/ |  __/ |\r\n"
								+ "                               |___/  |___/ ");
						
						System.out.println("[과로사] 사망하였습니다...");
						System.out.println();
						
						break;
					}
				} else if (cho == 2) {
					pm.eat();

					System.out.println("          　  ┌───────────────┐");
					System.out.println("         　   │ 식사시간이닷!!>< │");
					System.out.println("        　    │    냠냠 쩝접    │");
					System.out.println("       　     └───────────────┘");
					System.out.println("==================현재POINT==================");
					System.out.println("코딩 : " + pm.COD + " / " + "체력 : " + pm.HP + " / " + "피로도 : " + " " + pm.TR
							+ " / 총 포인트 = " + pm.PT);
					System.out.println("===========================================");

					if (pm.HP >= 10) {
						System.out.println();
						System.out.println("______  _____  _____                        \r\n"
								+ "|  _  \\|_   _||  ___|                       \r\n"
								+ "| | | |  | |  | |__             __ _   __ _ \r\n"
								+ "| | | |  | |  |  __|           / _` | / _` |\r\n"
								+ "| |/ /  _| |_ | |___  _  _  _ | (_| || (_| |\r\n"
								+ "|___/   \\___/ \\____/ (_)(_)(_) \\__, | \\__, |\r\n"
								+ "                                __/ |  __/ |\r\n"
								+ "                               |___/  |___/ ");
						System.out.println("[과식사] 성인병으로 사망하였습니다...");
						System.out.println();
						break;
					}
					if (pm.HP < 1) {
						System.out.println();
						System.out.println("______  _____  _____                        \r\n"
								+ "|  _  \\|_   _||  ___|                       \r\n"
								+ "| | | |  | |  | |__             __ _   __ _ \r\n"
								+ "| | | |  | |  |  __|           / _` | / _` |\r\n"
								+ "| |/ /  _| |_ | |___  _  _  _ | (_| || (_| |\r\n"
								+ "|___/   \\___/ \\____/ (_)(_)(_) \\__, | \\__, |\r\n"
								+ "                                __/ |  __/ |\r\n"
								+ "                               |___/  |___/ ");
						System.out.println("[아사] 굶어죽었습니다...");
						System.out.println();
						break;
					}
					if (pm.TR >= 10) {
						System.out.println();
						System.out.println("______  _____  _____                        \r\n"
								+ "|  _  \\|_   _||  ___|                       \r\n"
								+ "| | | |  | |  | |__             __ _   __ _ \r\n"
								+ "| | | |  | |  |  __|           / _` | / _` |\r\n"
								+ "| |/ /  _| |_ | |___  _  _  _ | (_| || (_| |\r\n"
								+ "|___/   \\___/ \\____/ (_)(_)(_) \\__, | \\__, |\r\n"
								+ "                                __/ |  __/ |\r\n"
								+ "                               |___/  |___/ ");
						
						System.out.println("[과로사] 사망하였습니다...");
						System.out.println();
						break;
					}
				} else if (cho == 3) {
					if (pm.TR > 0) {
						pm.sleep();

						System.out.println("         　   ┌───────────────┐");
						System.out.println("          　  │피곤해.. 잘꺼야ㅜㅜ│");
						System.out.println("           　 │....zzzzzZZZZ  │");
						System.out.println("            　└───────────────┘");
						System.out.println("==================현재POINT==================");
						System.out.println("코딩 : " + pm.COD + " / " + "체력 : " + pm.HP + " / " + "피로도 : " + " " + pm.TR
								+ " / 총 포인트 = " + pm.PT);
						System.out.println("===========================================");
						System.out.println("");
					} else if (pm.TR <= 0) {
						System.out.println("");
						System.out.println("       ※※※※※※※※※※※※");
						System.out.println("        잠을 잘 수 없습니다.");
						System.out.println("       ※※※※※※※※※※※※");
						System.out.println("");

				}
					if (pm.HP >= 10) {
						System.out.println();
						System.out.println("______  _____  _____                        \r\n"
								+ "|  _  \\|_   _||  ___|                       \r\n"
								+ "| | | |  | |  | |__             __ _   __ _ \r\n"
								+ "| | | |  | |  |  __|           / _` | / _` |\r\n"
								+ "| |/ /  _| |_ | |___  _  _  _ | (_| || (_| |\r\n"
								+ "|___/   \\___/ \\____/ (_)(_)(_) \\__, | \\__, |\r\n"
								+ "                                __/ |  __/ |\r\n"
								+ "                               |___/  |___/ ");
						System.out.println("[과식사] 성인병으로 사망하였습니다...");
						System.out.println();
						break;
					}
					if (pm.HP < 1) {
						System.out.println();
						System.out.println("______  _____  _____                        \r\n"
								+ "|  _  \\|_   _||  ___|                       \r\n"
								+ "| | | |  | |  | |__             __ _   __ _ \r\n"
								+ "| | | |  | |  |  __|           / _` | / _` |\r\n"
								+ "| |/ /  _| |_ | |___  _  _  _ | (_| || (_| |\r\n"
								+ "|___/   \\___/ \\____/ (_)(_)(_) \\__, | \\__, |\r\n"
								+ "                                __/ |  __/ |\r\n"
								+ "                               |___/  |___/ ");
						System.out.println("[아사] 굶어죽었습니다...");
						System.out.println();
						break;
					}
					if (pm.TR >= 10) {
						System.out.println();
						System.out.println("______  _____  _____                        \r\n"
								+ "|  _  \\|_   _||  ___|                       \r\n"
								+ "| | | |  | |  | |__             __ _   __ _ \r\n"
								+ "| | | |  | |  |  __|           / _` | / _` |\r\n"
								+ "| |/ /  _| |_ | |___  _  _  _ | (_| || (_| |\r\n"
								+ "|___/   \\___/ \\____/ (_)(_)(_) \\__, | \\__, |\r\n"
								+ "                                __/ |  __/ |\r\n"
								+ "                               |___/  |___/ ");
						
						System.out.println("[과로사] 사망하였습니다...");
						System.out.println();
						break;
					}

				} else if (cho == 4) {
					
					System.out.println("");
					System.out.println("　코딩 : " + pm.COD + " / " + "체력 : " + pm.HP + " / " + "피로도 : " + " " + pm.TR
							+ " / 총 포인트 = " + pm.PT);
					System.out.println("");

				}else if (cho == 5) {
					System.out.println("종료합니다");
					break;
				} else {
					System.out.println("잘못입력하셨습니다");
				}

			}

		}
				
//				if(cho == 1) {
//					pm.coding();
//					if(pm.HP >=10) {
//			               System.out.println("과식사!");
//			               continue;
//			            }
//					if (pm.HP<1) {
//				               System.out.println("아사!");
//				               break;
//				            }
//					if(pm.TR>=10) {
//			               System.out.println("과로사!");
//			               break;
//			           }
//					
//				}if (cho ==2)	{
//					pm.eat();
//					if(pm.HP >=10) {
//						System.out.println("과식사!");
//			               break;
//			            }
//			           if (pm.HP<1) {
//			               System.out.println("아사!");
//			               break;
//			            }
//			           if(pm.TR>=10) {
//			               System.out.println("과로사!");
//			               break;
//			           }
//			         }if(cho==3) {
//			            if(pm.TR >0) {            
//			            pm.sleep();
//			            }else if(pm.TR <= 0 ) {
//			                   System.out.println("");
//			                   System.out.println("       ※※※※※※※※※※※※");
//			                  System.out.println("        잠을 잘 수 없습니다.");
//			                  System.out.println("       ※※※※※※※※※※※※");
//			                  System.out.println("");
//			            }
//			            if(pm.HP >=10) {
//			               System.out.println("과식사!");
//			               break;
//			            }
//			           if (pm.HP<1) {
//			               System.out.println("아사!");
//			               break;
//			            }
//			           if(pm.TR>=10) {
//			               System.out.println("과로사!");
//			               break;
//			           }
//			            
//			         }if(cho == 4) {
//			            pm.check();
//			         }if(cho == 5) {
//			            System.out.println("종료합니다");
//			            mcount--;
//			            break;
//			         }else {
//			            System.out.println("잘못입력하셨습니다");
//			         }
//
//
//			}
				
				}else if(num1 ==3 ) {
				Rankpage.Rank check = new Rankpage.Rank();
				System.out.println("=========랭킹조회=========");
			      System.out.println("닉네임	  │포인트");
			      ArrayList<RankVO> all = check.select();
			      
			    
//			      캐릭터생성 insert_Status = new 캐릭터생성();
//					int cnt = insert_Status.insert_Status(ID,Dv_ID,0,5,5,0); // 개발자등록 객체 생성

			      for (int i = 0; i < all.size(); i++) {

//			         System.out.print(all.get(i).getId() + "   │");
			         System.out.print(all.get(i).getNa() + "  	  │");
			         System.out.print(all.get(i).getPt() + "   "+" ");
			         System.out.println();
			      }

			   } // 랭킹조회
			   
			
			else if(num1 == 4) { //로그아웃 실행
				count--;
				System.out.println("로그아웃합니다.");
				break;
				
			}
				
			} // while 반복

} // 개발자 등록 페이지로 넘어옴
}
		}
	}
	
