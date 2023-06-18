package churimon;

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
		this.wazaDmgRate	=	"1.0"				;	//わざ（ダメージ倍率）
	}
	
	//コンストラクタ2(引数あり)
	Monster2 ( String tn, String nm ) {
		//フィールドの初期化
		this();
		this.trainer 	=	tn		;	//トレーナー
		this.name		=	nm	;	//なまえ
	}
	
	//コンストラクタ3(引数あり)
	Monster2 ( String tn, String nm, int lvl ) {
		//フィールドの初期化
		this();
		this.lv			=	lvl		;	//初期レベル
		
		if( this.lv >= 2 ) {
			Monster1 monster1 = new Monster1();
			monster1.levelUp(lvl);
		}
		
	}

}
