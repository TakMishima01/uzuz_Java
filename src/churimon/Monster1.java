package churimon;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster1 {
	
	//フィールド設定
	String 	character 	=	"(unknown)"	;	//種族
	String 	trainer 			=	"(wild)"			;	//トレーナー
	String 	name			=	"(noname)"		;	//なまえ
	int		lv					=	1						;	//レベル
	int		hp				=	80						;	//HP
	int		atk				=	15						;	//こうげき
	int		def				=	10						;	//ぼうぎょ
	int		spd				=	10						;	//すばやさ
	int		hpMax			=	80						;	//HP初期値
	String	wazaNm		=	"たいあたり"	;	//わざ（なまえ）
	String	wazaDmgRate	=	"1.0"				;	//わざ（ダメージ倍率）
	
	final String WAZA_DMG_RATE_REGEXP = "^[0-9]+\\.[0-9]$";
	final String DMG_CORRECTION_120 = "120" 	;
	final String DMG_CORRECTION_1 	= "1" 		;

	
	//メソッド----------------------------------------
	
	public String toString() {
		return 
				"character:" 	+ character 	+ "/" + 
				"trainer:" 			+ trainer 		+ "/" + 
				"name:" 			+ name 		+ "/" + 
				"lv:" 					+ lv 				+ "/" + 
				"hp:" 				+ hp 				+ "/" + 
				"atk:" 				+ atk 			+ "/" + 
				"def:" 				+ def 			+ "/" + 
				"spd:" 				+ spd 			+ "/" + 
				"hpMax:" 			+ hpMax 		+ "/" + 
				"wazaNm:" 		+ wazaNm 	+ "/" + 
				"wazaDmgRate:" + wazaDmgRate + "/" ;
		
	}
	
	void levelUp( int lu ) {
		lv			=	lu * 1 	+ lv				; //上昇レベル×1の値を既存値にプラスする
		hp		=	lu * 30 + hp				; //上昇レベル×30の値を既存値にプラスする
		atk		=	lu * 5 	+ atk			; //上昇レベル×5の値を既存値にプラスする
		def		=	lu * 5 	+ def			; //上昇レベル×5の値を既存値にプラスする
		spd		=	lu * 5 	+ spd			; //上昇レベル×5の値を既存値にプラスする
		hpMax	=	hp							; //更新後のhp_maxの値を代入する
	}
	
	void setWaza ( String wn , String wdr ) {
		
		
		if ( wdr.matches(WAZA_DMG_RATE_REGEXP) ) {
			wazaNm = wn;
			wazaDmgRate = wdr;
		}else {
			System.out.println("[ERROR]わざの設定に失敗しました");
		}
	}
	
	String getStatus () {
		String st = "[" + this.name + "lv" + this.lv + "HP" + this.hp + "/" + this.hpMax + "]" ;
		return st ;  //ステータス情報(一部フィールドの情報)を文字列で返す
	}
	
	int useWaza () {
		BigDecimal bdatk = new BigDecimal( atk );
        BigDecimal bdwdr = new BigDecimal(wazaDmgRate);
                
        int dmg = ( ( bdatk.multiply(bdwdr ) ).setScale( 0, RoundingMode.DOWN ) ).intValue() ; //相手に値渡しするダメージ:こうげき×わざのダメージ倍率
                
		return dmg ; //相手にダメージ値を渡す
	}
	
	int damaged (int orgDmg) {
			
		BigDecimal bdOrgDm 		= new BigDecimal ( orgDmg );
		BigDecimal bdDmCr1 		= new BigDecimal(DMG_CORRECTION_1);
		BigDecimal bdDmCr120 	= new BigDecimal(DMG_CORRECTION_120);
		BigDecimal bdDef 			= new BigDecimal(def);
				
		BigDecimal dmRate = bdDmCr1.divide( bdDmCr1.add ( bdDef.divide ( bdDmCr120, 2 , RoundingMode.DOWN) ), 2 , RoundingMode.DOWN) ; //ダメージ減算率:1 / (1+ぼうぎょ÷120)※小数第3位切り捨て
				
		int dmg = (( bdOrgDm.multiply(dmRate)).setScale(0, RoundingMode.DOWN)).intValue();// 実際に受けるダメージ:値渡しされたダメージ値×ダメージ減算率
						
		if ( hp > dmg) {
			hp = hp - dmg; //HP>ダメージであればダメージを差し引いた値 をHPに代入
		}else {
			hp = 0; //HP<ダメージであればHPに0を代入
		}
			
		return dmg;
	}

}
