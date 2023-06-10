package Ex;

import java.sql.Time;

public class calcSalary {

	public static void main(String[] args) {
		
		
		// 計算用の数値を定数で用意
//		final long ONE_HOUR_BY_MILLI_SEC = 1000 * 60 * 60; // 1時間のミリ秒換算
		final long ONE_MIN_BY_MILLI_SEC  = 1000 * 60;      // 1分のミリ秒換算
//		final int  ONE_HOUR_BY_MIN       = 60;             // 1時間の分換算

		final int REST_TIME1 = 45 ; //休憩時間(分)（6時間超〜8時間以下）
		final int REST_TIME2 = 60 ; //休憩時間(分)（8時間超）
		final int REGULAR_WORKING_HOURS = 480;//所定労働時間　8時間（480分）		
		
		final int HOURLY_WAGE = 900; //時給900円
		final double OVERTIME_WORK_FARE_RATE = 1.25;  // 残業代通常の1.25倍
		final int REGULAR_WORK_FARE = HOURLY_WAGE * REGULAR_WORKING_HOURS;//時給×所定労働時間
		
		
		// バイトの開始時間と終了時間をコマンドライン引数から受け取る
		Time startTime  = Time.valueOf(args[0]);
		Time finishTime = Time.valueOf(args[1]);
		
		
		// getTimeメソッドを使って労働時間をミリ秒（0.001秒単位）で取得する
		// ※getTime()メソッドの戻り値はlong型であることに注意
		long workingTime = finishTime.getTime() - startTime.getTime();
		
		// ミリ秒で取得した労働時間を○時間△分の形式に直す
//		int workingHour = (int)( workingTime / ONE_HOUR_BY_MILLI_SEC );                      // 時間に換算
//		int workingMin  = (int)( ( workingTime / ONE_MIN_BY_MILLI_SEC ) % ONE_HOUR_BY_MIN ); // 分に換算
		
		//休憩時間・残業代計算用にミリ秒で取得した労働時間を△分の形式に直す
		int workingMin2  = (int)(  workingTime / ONE_MIN_BY_MILLI_SEC ); // 分に換算
		
		
		// 給料の計算----------------------------------------------------------------------
		double calcSalary = 0; //計算用の変数（給料）
		double calcWorkingMin = 0; //計算用の変数（労働時間）
		double overtimeWorkFare = 0;  // 残業代初期値
		int salary = 0;//計算後の給料
		
		System.out.println(workingMin2);

		//労働時間から休憩時間を引く-------------------------------------------------------
		if(workingMin2 > 360 && 480 >= workingMin2) { //6時間＝360分、8時間＝480分
			calcWorkingMin = workingMin2 - REST_TIME1;
			System.out.println(1);
		}else if ( workingMin2 > 480){
			calcWorkingMin = workingMin2 - REST_TIME2;
			System.out.println(2);
		} else {
			calcWorkingMin = workingMin2;
			System.out.println(3);

		}
		
		//労働時間超過分の給料-----------------------------------------------------------------
		if(calcWorkingMin > 480) { // 8時間 = 480分
			
			//超過分給料の計算
			overtimeWorkFare = (calcWorkingMin - REGULAR_WORKING_HOURS) / 60 * HOURLY_WAGE * OVERTIME_WORK_FARE_RATE;
			
			calcSalary = REGULAR_WORK_FARE + overtimeWorkFare;// 所定労働時間給＋労働時間超過分の給料
		} else {
			calcSalary = Math.floor((double)calcWorkingMin / 60 * HOURLY_WAGE);
		}
		
		salary = (int)calcSalary;
		
		
//		System.out.println(calcWorkingMin);
//		System.out.println(calcSalary);
//		System.out.println(salary);
		
		// 出力
//		System.out.println("本日の労働時間は" + workingHour + "時間" + workingMin + "分です。");
		System.out.println("本日の給料は" + salary +  "円です。");
		

		
	}

}
