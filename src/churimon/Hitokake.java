package churimon;

public class Hitokake extends Monster3 {
	
	Hitokake(){
		
		super.setCharacter("ヒトカケ");
		
	}
	
	Hitokake( String tn, String nm ){
		
		super(tn, nm);
		super.setCharacter("ヒトカケ");
		
	}
	
	Hitokake( String tn, String nm, int lev ){
		
		super(tn, nm, lev);
		super.setCharacter("ヒトカケ");
		
	}
	
	public void levelUp( int lu ) {
		setLv	( lu * 1 + getLv() )		; //上昇レベル×1の値を既存値にプラスする
		setHp	( lu * 29 + getHp() )	; //上昇レベル×30の値を既存値にプラスする
		setAtk	( lu * 8 + getAtk() )		; //上昇レベル×5の値を既存値にプラスする
		setDef	( lu * 5 + getDef() )		; //上昇レベル×5の値を既存値にプラスする
		setSpd (lu * 9 + getSpd() )		; //上昇レベル×5の値を既存値にプラスする
		setHpMax( getHp() )				; //更新後のhp_maxの値を代入する
	}

}
