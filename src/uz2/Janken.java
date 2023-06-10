package uz2;

public class Janken {

	public static void main(String[] args) {
		
		//コンストラクタを生成
		Player player_1 = new Player(args[0]);
		Player player_2 = new Player(args[1]);
		
		//じゃんけんの手をランダムで生成
		player_1.makeHnadStatus();
		player_2.makeHnadStatus();
		
		//結果を表示
		System.out.println("じゃんけん・・・ぽん！！！！！");
		System.out.println(player_1.name + "さんの手：" + player_1.handStatus);
		System.out.println(player_2.name + "さんの手：" + player_2.handStatus);
		System.out.println("結果は・・・");
		System.out.println(judge(player_1.name, player_1.handStatus, player_2.name, player_2.handStatus));
	}
	
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
