package churimon;

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
	
	public void levelUp(int lu) {
		
	}

}
