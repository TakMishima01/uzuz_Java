package churimon;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Monster3 {
	
	//フィールド設定
	private String 	character 		;	//種族
	private String 	trainer 				;	//トレーナー
	private String 	name				;	//なまえ
	private int		lv						;	//レベル
	private int		hp					;	//HP
	private int		atk					;	//こうげき
	private int		def					;	//ぼうぎょ
	private int		spd					;	//すばやさ
	private int		hpMax				;	//HP初期値
	private String	wazaNm			;	//わざ（なまえ）
	private String	wazaDmgRate	;	//わざ（ダメージ倍率）
	
	final String WAZA_DMG_RATE_REGEXP = "^[0-9]+\\.[0-9]$";
	final String DMG_CORRECTION_120 = "120" 	;
	final String DMG_CORRECTION_1 	= "1" 		;
	
	//コンストラクタ1(引数なし)
	Monster3 () {
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
		
	}
	
	//コンストラクタ2(引数あり)
	Monster3 ( String tn, String nm ) {
		this();
		this.trainer 	=	tn		;	//トレーナー
		this.name		=	nm	;	//なまえ
				
	}
	
	//コンストラクタ3(引数あり)
	Monster3 ( String tn, String nm, int lev ) {
		this(tn, nm);		
		
		if( lev > 1 ) {
			levelUp(lev - 1);
		}
		
	}
	
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
	
	public void levelUp( int lu ) {
		lv			=	lu * 1 	+ lv				; //上昇レベル×1の値を既存値にプラスする
		hp		=	lu * 30 + hp				; //上昇レベル×30の値を既存値にプラスする
		atk		=	lu * 5 	+ atk			; //上昇レベル×5の値を既存値にプラスする
		def		=	lu * 5 	+ def			; //上昇レベル×5の値を既存値にプラスする
		spd		=	lu * 5 	+ spd			; //上昇レベル×5の値を既存値にプラスする
		hpMax	=	hp							; //更新後のhp_maxの値を代入する
	}
	
	public void setWaza ( String wn , String wdr ) {
		
		
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
	
	public int useWaza () {
		BigDecimal bdatk = new BigDecimal( atk );
        BigDecimal bdwdr = new BigDecimal(wazaDmgRate);
                
        int dmg = ( ( bdatk.multiply(bdwdr ) ).setScale( 0, RoundingMode.DOWN ) ).intValue() ; //相手に値渡しするダメージ:こうげき×わざのダメージ倍率
                
		return dmg ; //相手にダメージ値を渡す
	}
	
	public int damaged (int orgDmg) {
			
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


	public String getCharacter() {
		return character;
	}

	public void setCharacter(String character) {
		this.character = character;
	}

	public String getTrainer() {
		return trainer;
	}

	public void setTrainer(String trainer) {
		this.trainer = trainer;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLv() {
		return lv;
	}

	public void setLv(int lv) {
		this.lv = lv;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public int getDef() {
		return def;
	}

	public void setDef(int def) {
		this.def = def;
	}

	public int getSpd() {
		return spd;
	}

	public void setSpd(int spd) {
		this.spd = spd;
	}

	public int getHpMax() {
		return hpMax;
	}

	public void setHpMax(int hpMax) {
		this.hpMax = hpMax;
	}

	public String getWazaNm() {
		return wazaNm;
	}

	public void setWazaNm(String wazaNm) {
		this.wazaNm = wazaNm;
	}

	public String getWazaDmgRate() {
		return wazaDmgRate;
	}

	public void setWazaDmgRate(String wazaDmgRate) {
		this.wazaDmgRate = wazaDmgRate;
	}
	


}
