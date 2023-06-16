package uz1;

public class CalcCakeSum {

	public static void main(String[] args) {
		
//		・商品は以下の5種類とする。
//		- ショートケーキ :320円 - モンブラン :350円 - チョコレートケーキ:370円 - いちごのタルト :400円 - チーズケーキ :300円
		
		
		String cakes[] = args;
		String cake = "";
		int total = 0;
		int subtotal = 0;
		double discount = 0.8;
		double tax = 1.08;
		
		int shortcakePrice = 320;
		int montBlancPrice = 350;
		int chocolateCakePrice = 370;
		int strawberryTartePrice = 400;
		int cheeseCakePrice = 300;
		
		for (int i = 0 ; i < cakes.length; i += 2 ) {
			cake = "";
			cake = cakes[i];
			int orderQuantity = 0;
			
			switch (cake) {
				case "ショートケーキ":
					
					orderQuantity = Integer.parseInt(cakes[i + 1]);//注文数の取得
					
					subtotal = subtotal + shortcakePrice * orderQuantity;// 金額の計算
					
					break;
				case "モンブラン":
					
					orderQuantity = Integer.parseInt(cakes[i + 1]);//注文数の取得
					
					subtotal = subtotal + montBlancPrice * orderQuantity;// 金額の計算
					
					break;
				case "チョコレートケーキ":
					
					orderQuantity = Integer.parseInt(cakes[i + 1]);//注文数の取得
					
					subtotal = subtotal + chocolateCakePrice * orderQuantity;// 金額の計算
					
					break;
				case "いちごのタルト":
					
					orderQuantity = Integer.parseInt(cakes[i + 1]);//注文数の取得
					
					subtotal = subtotal + strawberryTartePrice * orderQuantity;// 金額の計算
					
					break;
				case "チーズケーキ":
					
					orderQuantity = Integer.parseInt(cakes[i + 1]);//注文数の取得
					
					subtotal = subtotal + cheeseCakePrice * orderQuantity;// 金額の計算
					
					break;
					
			}
		}
		
//		System.out.println(subtotal);
	
		if (subtotal >= 1000) {  //割引の計算

			subtotal = (int)(subtotal * discount);
			
		}
//		System.out.println(subtotal);
		
		total = (int)(subtotal * tax);  //合計金額の計算
		
		System.out.println("合計金額は" + (int)total + "です。");

	}

}
