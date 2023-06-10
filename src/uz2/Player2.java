package uz2;

import java.util.Random;

public class Player2 {

	//フィールド------------------------
	String name ;
	String handStatus ;
	
	//コンストラクタ-----------------------------
	
	Player2(String nm){
		this.name = nm;
	}
	
	//メソッド-----------------------------------
	
	void makeHnadStatus() {
		Random random = new Random();
		int hand = random.nextInt(3);
		
		if(hand == 0) {
			handStatus = "グー";
		}else if(hand == 1){
			handStatus = "チョキ";
		} else {
			handStatus = "パー";
		}
	}
}
