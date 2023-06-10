package uz2;

public class Referee {
	
	//定数----------------------------------
	
	final String HAND_G = "グー" ;
	final String HAND_C = "チョキ" ;
	final String HAND_P = "パー" ;
	
	//フィールド----------------
	String name;
	
	//コンストラクタ-----------------------------
	
	Referee(String nm){
		this.name = nm;
	}
	
	//メソッド-----------------------------------
	
	void startJanken() {
		messageReferee("じゃんけん・・・ぽん！！！！！");
	}
	
	//プレイヤーの手を確認する
	void checkHand (Player2 p) {
		if ( (p.handStatus).equals(HAND_G) ) {
			messageReferee(p.name + "さんの手はグーでした！");
			
		}else if( (p.handStatus).equals(HAND_C) ) {
			messageReferee(p.name + "さんの手はチョキでした！");
			
		}else if( (p.handStatus).equals(HAND_P) ) {
			messageReferee(p.name + "さんの手はパーでした！");

		}else {
			System.out.println("[ERROR]ジャンケンの判定が不正です。");	
		}
	}
	
	//ジャンケンの判定と結果発表を行う
	void judgeJanken(Player2 p1, Player2 p2) {
		messageReferee("結果は・・・");
		
		if ((p1.handStatus).equals(p2.handStatus)) {
			System.out.println("あいこ！勝負つかず！");
		}else if( 		(p1.handStatus.equals(HAND_G) && p2.handStatus.equals(HAND_C) ) 
						|| 	(p1.handStatus.equals(HAND_C) && p2.handStatus.equals(HAND_P) )
						||	(p1.handStatus.equals(HAND_P) && p2.handStatus.equals(HAND_G) ) ) {
			System.out.println(p1.name + "さんの勝利！");
		}else if( 		(p2.handStatus.equals(HAND_G) && p1.handStatus.equals(HAND_C) ) 
						|| 	(p2.handStatus.equals(HAND_C) && p1.handStatus.equals(HAND_P) )
						||	(p2.handStatus.equals(HAND_P) && p1.handStatus.equals(HAND_G) ) ) {
			System.out.println(p2.name + "さんの勝利！");
		}else {
			System.out.println("[ERROR]じゃんけんの判定が不正です。");
		}
	}
	
	//審判としてのメッセージを表示
	void messageReferee(String msg) {
		System.out.println( this.name + "「" + msg + "」");
	}
	
//public static String judge(String nm1, String hd1, String nm2, String hd2) {
//		
//		String name1 = nm1;
//		String hand1 = hd1;
//		String name2 = nm2;
//		String hand2 = hd2;
//		String judge = "";
//		
//		//勝敗を判断
//		if((hand1 == "グー" && hand2 == "チョキ") || (hand1 == "チョキ" && hand2 == "パー") || (hand1 == "パー" && hand2 == "グー")) {
//			judge = name1 + "さんの勝利！";
//		}else if((hand1 == "グー" && hand2 == "パー") || (hand1 == "チョキ" && hand2 == "グー") || (hand1 == "パー" && hand2 == "チョキ")) {
//			judge = name2 + "さんの勝利！";
//		}else if(hand1 == hand2 ) {
//			judge = "あいこ！勝負つかず！";
//		}
//		return judge;
//		
//	}

}
