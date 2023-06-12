package uz2;
public class Ex2_03_1_Referee {
	
	
	//---定数----------------------------------------------------------
	final String HAND_G = "グー" ;     //ジャンケンの手（グー）
	final String HAND_C = "チョキ" ;   //ジャンケンの手（チョキ）
	final String HAND_P = "パー" ;     //ジャンケンの手（パー）
	
	
	//---フィールド----------------------------------------------------
	private String name       ;   //名前
	
	
	//---コンストラクタ------------------------------------------------
	Ex2_03_1_Referee(String nm){
		this.name = nm;   //名前
	}
	
	
	//---メソッド------------------------------------------------------
	
	//ジャンケンの開始を宣言する
	void startJanken(){
		
		messageReferee("じゃんけん・・・ぽん！！！！！");
		
	}
	
	//プレイヤーの手を確認する
	void checkHand( Ex2_03_1_Player p ){
	
		//結果を確認し、審判が宣言する
		if( (p.getHandStatus()).equals( HAND_G ) ){
			
			//「グー」の場合
			messageReferee(p.getName() + "さんの手はグーでした！");
			
		}else if( (p.getHandStatus()).equals( HAND_C ) ){
			
			//「チョキ」の場合
			messageReferee(p.getName() + "さんの手はチョキでした！");
			
		}else if( (p.getHandStatus()).equals( HAND_P ) ){
			
			//「パー」の場合
			messageReferee(p.getName() + "さんの手はパーでした！");
			
		}else{
			
			//不正な場合はエラーメッセージを出力
			System.out.println("[ERROR]ジャンケンの判定が不正です。");
			
		}
	}
	
	//ジャンケンの判定＆結果発表をする
	void judgeJanken(Ex2_03_1_Player p1,Ex2_03_1_Player p2){
		
		//はじめに「結果は・・・」と審判が言う
		messageReferee("結果は・・・");
		
		//結果を判定し、結果に応じたメッセージを審判が言う
		if( (p1.getHandStatus()).equals( p2.getHandStatus() ) ){
			
			//あいこの場合
			messageReferee("あいこ！勝負つかず！");
			
		}else if(     (p1.getHandStatus().equals( HAND_G ) && p2.getHandStatus().equals( HAND_C ))
		           || (p1.getHandStatus().equals( HAND_C ) && p2.getHandStatus().equals( HAND_P ))
		           || (p1.getHandStatus().equals( HAND_P ) && p2.getHandStatus().equals( HAND_G ))  ) {
			
			//プレイヤー1が勝利した場合
			messageReferee(p1.getName() + "さんの勝利！");
			
		}else if(     (p2.getHandStatus().equals( HAND_G ) && p1.getHandStatus().equals( HAND_C ))
		           || (p2.getHandStatus().equals( HAND_C ) && p1.getHandStatus().equals( HAND_P ))
		           || (p2.getHandStatus().equals( HAND_P ) && p1.getHandStatus().equals( HAND_G ))  ) {
			
			//プレイヤー2が勝利した場合
			messageReferee(p2.getName() + "さんの勝利！");
			
		}else{
			
			//不正な場合はエラーメッセージを出力
			System.out.println("[ERROR]ジャンケンの判定が不正です。");
			
		}
	}
	
	//審判としてメッセージを表示する
	void messageReferee(String msg){
		
		System.out.println( this.name + "「" + msg + "」");
		
	}
	
	public String getName() {
		return this.name;
	}
}
