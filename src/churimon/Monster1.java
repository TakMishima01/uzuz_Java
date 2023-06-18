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
	
	public void levelUp( int lu ) {
		this.lv			=	lu * 1 + this.lv				; //上昇レベル×1の値を既存値にプラスする
		this.hpMax	=	lu * 30 + this.hpMax	; //上昇レベル×30の値を既存値にプラスする
		this.atk			=	lu * 5 + this.atk			; //上昇レベル×5の値を既存値にプラスする
		this.def		=	lu * 5 + this.def			; //上昇レベル×5の値を既存値にプラスする
		this.spd		=	lu * 5 + this.spd			; //上昇レベル×5の値を既存値にプラスする
		this.hp			=	this.hpMax					; //更新後のhp_maxの値を代入する
	}
	
	public void setWaza ( String wn , String wdr ) {
		if ( wdr.matches("^[0-9]+¥.[0-9]$") ) {
			this.wazaNm = wn;
			this.wazaDmgRate = wdr;
		}else {
			System.out.println("[ERROR]わざの設定に失敗しました");
		}
	}
	
	public String getStatus () {
		String st = this.name + "lv" + this.lv + "HP" + this.hp + "/" + this.hpMax ;
		return st ;  //ステータス情報(一部フィールドの情報)を文字列で返す
	}
	
	public int useWaza () {
		BigDecimal atk = new BigDecimal(this.atk);
        BigDecimal wdr = new BigDecimal(this.wazaDmgRate);
        int dmg = atk.intValue() * wdr.intValue() ; //相手に値渡しするダメージ:こうげき×わざのダメージ倍率
		return dmg ; //相手にダメージ値を渡す
	}
	
	public int damaged (int dmg) {
		
		BigDecimal calc1 = new BigDecimal(1);
		BigDecimal calc120 = new BigDecimal(120);
		BigDecimal def = new BigDecimal(this.def);
		
		BigDecimal dmgSubRate = calc1.divide( calc1.add ( def.divide ( calc120 ) ) ).setScale( 2 , RoundingMode.DOWN); //ダメージ減算率:1 / (1+ぼうぎょ÷120)※小数第3位切り捨て
		
		BigDecimal calcDmg = BigDecimal.valueOf(useWaza()).multiply(dmgSubRate);// 実際に受けるダメージ:値渡しされたダメージ値×ダメージ減算率
		
		int dmgd = 0;
		
		if (this.hp > calcDmg.intValue()) {
			dmgd = this.hp - calcDmg.intValue(); //HP>ダメージであればダメージを差し引いた値 をHPに代入
		}else {
			dmgd = 0; //HP<ダメージであればHPに0を代入
		}
		
		return dmgd;
	}
	
	

}
