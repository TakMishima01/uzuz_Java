package uz1;
/*-< 演習：Ex1_11_2 >---------------------------------
do-while文を使用して、6の目がでるまでサイコロを降り続けるプログラムを作成してください。
※1～6までのランダムなint型の数値（出目）を取得する方法 ： 1 + (int)(Math.random() * 6.0)
※サイコロを振るたびに出目を画面に表示してください。
※6の目が出たら「6が出たのでを終了します」と表示してください。
----------------------------------------------------*/
class Ex1_11_2 {
	public static void main (String[] args) {
		
//		System.out.println("サイコロを降って6が出るまで終了しません！");
//		
//		int number = 0 ;
//		do {
//			number = 0 ;  														//初期値の代入
//			number = 1 + (int)(Math.random() * 6);			//1~6の数字をランダムで取得
//			System.out.println(number);
//		}while( number < 6 );
//		System.out.println("6が出たので終了します");
		
		int dice = 0 ; //サイコロの目（初期値：０）
	
		//-------------------------
		//６の目が出るまでサイコロを振り続ける
		//-------------------------
		do  {
			
			//サイコロを振る（１〜６までのランダムな値を格納）
			dice = 1 + (int)(Math.random() * 6.0 );
			
			//サイコロの目を表示
			System.out.println(dice);
			
		} while ( dice != 6 );
		
		//終了メッセージを表示
		System.out.println("「６が出たので終了します」");
						
		
		
		
		
		
		
		
		
		
	}
}
