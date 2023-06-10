package uz2;

//import java.util.Random;

public class Player {
	
	//定数----------------------------------
	
	final String HAND_G = "グー" ;
	final String HAND_C = "チョキ" ;
	final String HAND_P = "パー" ;

	//フィールド------------------------
	String name ;
	String handStatus ;
	
	//コンストラクタ-----------------------------
	
	Player(String nm){
		this.name = nm;
	}
	
	//メソッド-----------------------------------
	
	void makeHnadStatus() {
		
		int random1to3 = 1 + (int)(Math.random() * 3.0);
		
		switch(random1to3) {
			case 1 :
				this.handStatus = HAND_G ;
				break;
			case 2 :
				this.handStatus = HAND_C ;
				break;
			case 3 :
				this.handStatus = HAND_P ;
				break;
			
		}
		
//		Random random = new Random();
//		int hand = random.nextInt(3);
//		
//		if(hand == 0) {
//			handStatus = "グー";
//		}else if(hand == 1){
//			handStatus = "チョキ";
//		} else {
//			handStatus = "パー";
//		}
	}
	
	
}
