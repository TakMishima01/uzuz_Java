package uz2;

public class Janken2 {

	public static void main(String[] args) {
		
		//コマンドライン引数より文字列を受け取る
		String nameP1 			= args[0];
		String nameP2 			= args[1];
		String nameReferee 	= args[2];
		
		//インスタンス化
		Player2 	p1 	= new Player2(nameP1);
		Player2 	p2 	= new Player2(nameP2);
		Referee 	ref 	= new Referee(nameReferee);
		
//		Player2 player_1 	= new Player2(args[0]);
//		Player2 player_2 	= new Player2(args[1]);
//		Referee referee 	= new Referee(args[2]);
		
		// 審判がじゃんけんぽんと言う
		ref.startJanken();
		
		//プレイヤーそれぞれに手を出させる
		p1.makeHnadStatus();
		p2.makeHnadStatus();
		
		//審判がプレイヤーの手を公表する
		ref.checkHand(p1);
		ref.checkHand(p2);
		
		//審判が勝敗を判定する
		ref.judgeJanken(p1, p2);
		
		
		
		
		
		//じゃんけんの手をランダムで生成
//		player_1.makeHnadStatus();
//		player_2.makeHnadStatus();
		
		//結果を表示
//		System.out.println(referee.name + "「じゃんけん・・・ぽん！！！！！」");
//		System.out.println(referee.name + "「" + player_1.name + "さんの手は" + player_1.handStatus + "でした！");
//		System.out.println(referee.name + "「" + player_2.name + "さんの手は" + player_2.handStatus + "でした！");
//		System.out.println(referee.name + "「結果は・・・」");
//		System.out.println(referee.name + "「"+ Referee.judge(player_1.name, player_1.handStatus, player_2.name, player_2.handStatus) + "」");
	}
}
