package uz2;

public class Referee {
	
	//フィールド----------------
	String name;
	
	//コンストラクタ-----------------------------
	
	Referee(String nm){
		this.name = nm;
	}
	
	//メソッド-----------------------------------
	
public static String judge(String nm1, String hd1, String nm2, String hd2) {
		
		String name1 = nm1;
		String hand1 = hd1;
		String name2 = nm2;
		String hand2 = hd2;
		String judge = "";
		
		//勝敗を判断
		if((hand1 == "グー" && hand2 == "チョキ") || (hand1 == "チョキ" && hand2 == "パー") || (hand1 == "パー" && hand2 == "グー")) {
			judge = name1 + "さんの勝利！";
		}else if((hand1 == "グー" && hand2 == "パー") || (hand1 == "チョキ" && hand2 == "グー") || (hand1 == "パー" && hand2 == "チョキ")) {
			judge = name2 + "さんの勝利！";
		}else if(hand1 == hand2 ) {
			judge = "あいこ！勝負つかず！";
		}
		return judge;
		
	}

}
