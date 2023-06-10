package uz2;

public class Janken2 {

	public static void main(String[] args) {
		//コンストラクタを生成
		Player2 player_1 	= new Player2(args[0]);
		Player2 player_2 	= new Player2(args[1]);
		Referee referee 	= new Referee(args[2]);
		
		//じゃんけんの手をランダムで生成
		player_1.makeHnadStatus();
		player_2.makeHnadStatus();
		
		//結果を表示
		System.out.println(referee.name + "「じゃんけん・・・ぽん！！！！！」");
		System.out.println(referee.name + "「" + player_1.name + "さんの手は" + player_1.handStatus + "でした！");
		System.out.println(referee.name + "「" + player_2.name + "さんの手は" + player_2.handStatus + "でした！");
		System.out.println(referee.name + "「結果は・・・」");
		System.out.println(referee.name + "「"+ Referee.judge(player_1.name, player_1.handStatus, player_2.name, player_2.handStatus) + "」");
	}
	
	
}
