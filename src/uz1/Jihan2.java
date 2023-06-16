package uz1;

public class Jihan2 {

	public static void main(String[] args) {
		String[] coins = new String[args.length] ; 													//硬貨を受け取る配列を作成
		coins = args; 																								//agrsからcoinsへ投入された硬貨の情報を代入
		int price = Integer.parseInt(args[args.length - 1]);
		int total = 0; 																								//合計金額の初期値
		int change = 0;
		
		for (int i = 0 ; i < coins.length - 1 ; i++) { 														//硬貨の枚数分繰り返す
			
			int coin = Integer.parseInt(coins[i]); 			 											//硬貨を１枚ずつ取り出す
			
			if( coin == 1 || coin == 5) {
				
				System.out.println("警告：" + coin + "円玉は使えません");  				//１円玉と５円玉は警告を出力
				
			}else if(coin == 10 || coin == 50 || coin == 100 || coin == 500){	
				
				total = total + coin;																				//１０円、５０円、１００円、５００円の場合はtotalに足す
				
			}else {
				
				System.out.println("警告：" + coin + "は硬貨として適切な値ではありません");// 硬貨として適切でないものは警告を出力
				
			}
		}
		change = total - price;																			//お釣りの計算
		System.out.println("ただいまの投入金額は" + total + "円です");			//投入金額の表示
		System.out.println(change + "円のお釣りです。ありがとうございました。"); // お釣りの表示 

	}

}
