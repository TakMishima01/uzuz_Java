package churimon;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster2 {
	
	//フィールド設定
	String 	character 		;	//種族
	String 	trainer 				;	//トレーナー
	String 	name				;	//なまえ
	int		lv						;	//レベル
	int		hp					;	//HP
	int		atk					;	//こうげき
	int		def					;	//ぼうぎょ
	int		spd					;	//すばやさ
	int		hpMax				;	//HP初期値
	String	wazaNm			;	//わざ（なまえ）
	String	wazaDmgRate	;	//わざ（ダメージ倍率）
	
	//コンストラクタ1(引数なし)
	Monster2 () {
		//フィールドの初期化
		this.character 	=	"(unknown)"	;	//種族
		this.trainer 		=	"(wild)"			;	//トレーナー
		this.name			=	"(noname)"		;	//なまえ
		this.lv				=	1						;	//レベル
		this.hp				=	80						;	//HP
		this.atk				=	15						;	//こうげき
		this.def			=	10						;	//ぼうぎょ
		this.spd			=	10						;	//すばやさ
		this.hpMax		=	80						;	//HP初期値
		this.wazaNm	=	"たいあたり"	;	//わざ（なまえ）
		this.wazaDmgRate	=	"1.0"			;	//わざ（ダメージ倍率）
		
		System.out.println("no1");
		
		
	}
	
	//コンストラクタ2(引数あり)
	Monster2 ( String tn, String nm ) {
		//フィールドの初期化
		this();
		this.trainer 	=	tn		;	//トレーナー
		this.name		=	nm	;	//なまえ
		
		System.out.println("no2");
		
	}
	
	//コンストラクタ3(引数あり)
	Monster2 ( String tn, String nm, int lev ) {
		//フィールドの初期化
		this(tn, nm);		
		
		if( lev > 1 ) {
			levelUp(lev - 1);
		}
		
	}
	
	//メソッド---------------------------------------------------
	
	public String toString() {
		return 
				"character:" 	+ this.character 	+ "/" + 
				"trainer:" 			+ this.trainer 		+ "/" + 
				"name:" 			+ this.name 		+ "/" + 
				"lv:" 					+ this.lv 				+ "/" + 
				"hp:" 				+ this.hp 				+ "/" + 
				"atk:" 				+ this.atk 			+ "/" + 
				"def:" 				+ this.def 			+ "/" + 
				"spd:" 				+ this.spd 			+ "/" + 
				"hpMax:" 			+ this.hpMax 		+ "/" + 
				"wazaNm:" 		+ this.wazaNm 	+ "/" + 
				"wazaDmgRate:" + this.wazaDmgRate + "/" ;
	}
	
	void levelUp( int lu ) {
		lv			=	lu * 1 + lv				; //上昇レベル×1の値を既存値にプラスする
		hpMax	=	lu * 30 + hpMax	; //上昇レベル×30の値を既存値にプラスする
		atk		=	lu * 5 + atk			; //上昇レベル×5の値を既存値にプラスする
		def		=	lu * 5 + def			; //上昇レベル×5の値を既存値にプラスする
		spd		=	lu * 5 + spd			; //上昇レベル×5の値を既存値にプラスする
		hp		=	hpMax					; //更新後のhp_maxの値を代入する
	}
	
	void setWaza ( String wn , String wdr ) {
		
		final String WAZA_DMG_RATE_REGEXP = "^[0-9]+\\.[0-9]$";
		
		if ( wdr.matches(WAZA_DMG_RATE_REGEXP) ) {
			wazaNm = wn;
			wazaDmgRate = wdr;
		}else {
			System.out.println("[ERROR]わざの設定に失敗しました");
		}
	}
	
	String getStatus () {
		String st = this.name + "lv" + this.lv + "HP" + this.hp + "/" + this.hpMax ;
		return st ;  //ステータス情報(一部フィールドの情報)を文字列で返す
	}
	
	int useWaza () {
		BigDecimal atk = new BigDecimal(this.atk);
        BigDecimal wdr = new BigDecimal(this.wazaDmgRate);
        
        System.out.println(atk + ":" + wdr);
        
        int dmg = (atk.multiply(wdr)).intValue() ; //相手に値渡しするダメージ:こうげき×わざのダメージ倍率
        
        System.out.println(dmg);
        
		return dmg ; //相手にダメージ値を渡す
	}
	
	int damaged (int dmg) {
		
		System.out.println(dmg);
		
		BigDecimal calc1 = new BigDecimal(1);
		BigDecimal calc120 = new BigDecimal(120);
		BigDecimal def = new BigDecimal(this.def);
				
		BigDecimal dmgSubRate = calc1.divide( calc1.add ( def.divide ( calc120, 2 , RoundingMode.DOWN) ), 2 , RoundingMode.DOWN) ; //ダメージ減算率:1 / (1+ぼうぎょ÷120)※小数第3位切り捨て
		
		System.out.println(dmgSubRate);
		
		BigDecimal calcDmg = BigDecimal.valueOf(useWaza()).multiply(dmgSubRate);// 実際に受けるダメージ:値渡しされたダメージ値×ダメージ減算率
		
		System.out.println(calcDmg);
		
		int dmgd = 0;
		
		if (this.hp > calcDmg.intValue()) {
			dmgd = this.hp - calcDmg.intValue(); //HP>ダメージであればダメージを差し引いた値 をHPに代入
		}else {
			dmgd = 0; //HP<ダメージであればHPに0を代入
		}
		
		System.out.println(dmgd);
		
		return dmgd;
	}
	

}
