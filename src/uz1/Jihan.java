package uz1;

public class Jihan {

	public static void main(String[] args) {
		int coinNum = args.length; //投入された硬貨の枚数
		int coinChk = 0 ; //チェック対象の硬貨の金額
		int coinSum = 0; //投入された硬貨の合計金額※使用可能な硬貨のみでの算出
		
		String[] coins = new String[args.length] ; 													//硬貨を受け取る配列を作成
		coins = args; 																								//agrsからcoinsへ投入された硬貨の情報を代入
		int total = 0; 																								//合計金額の初期値
		
		// 投入された硬貨を1枚ずつチェックし、合計金額を取得（使用できない場合はエラーメッセージを出力）
		for (int i = 0 ; i < coinNum ; i++) { 
//		for (int i = 0 ; i < coins.length ; i++) { 														//硬貨の枚数分繰り返す
			//今回のループでチェックする硬貨をセット
			coinChk = Integer.parseInt(args[i]);
//			int coin = Integer.parseInt(coins[i]); 			 											//硬貨を１枚ずつ取り出す
			// チェックと硬貨の種類に応じた処理を実施
			if(coinChk == 10 || coinChk == 50 || coinChk == 100 || coinChk == 500) {
//			if( coin == 1 || coin == 5) {
				
				//使用可能な硬貨であった場合、coinSumに加算
				coinSum += coinChk ;
				
//				System.out.println("警告：" + coin + "円玉は使えません");  				//１円玉と５円玉は警告を出力
			
			}else if(coinChk == 1 || coinChk == 5){	
//			}else if(coin == 10 || coin == 50 || coin == 100 || coin == 500){	
				
				//使用不可能な硬貨であった場合、エラーメッセージ（使用不可能な硬貨）を出力
				System.out.println("警告：" + coinChk + "円玉は使えません");
				
//				total = total + coin;																				//１０円、５０円、１００円、５００円の場合はtotalに足す
				
			}else {
				
				System.out.println("警告：" + coinChk + "は硬貨として適切な値ではありません");// 硬貨として適切でないものは警告を出力
				
			}
		}
//		System.out.println("ただいまの投入金額は" + total + "円です");
		System.out.println("ただいまの投入金額は" + coinSum + "円です");

	}

}
