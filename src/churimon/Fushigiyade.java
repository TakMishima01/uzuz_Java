package churimon;

public class Fushigiyade extends Monster3 {
	
	Fushigiyade(){
		
		super.setCharacter("フシギヤデ");
		
	}
	
	Fushigiyade( String tn, String nm ){
		
		super(tn, nm);
		super.setCharacter("フシギヤデ");
		
	}
	
	Fushigiyade( String tn, String nm, int lev ){
		
		super(tn, nm, lev);
		super.setCharacter("フシギヤデ");
		
	}
	
	public void levelUp( int lu ) {
		setLv	( lu * 1 + getLv() )		; //上昇レベル×1の値を既存値にプラスする
		setHp	( lu * 31 + getHp() )	; //上昇レベル×30の値を既存値にプラスする
		setAtk	( lu * 6 + getAtk() )		; //上昇レベル×5の値を既存値にプラスする
		setDef	( lu * 7 + getDef() )		; //上昇レベル×5の値を既存値にプラスする
		setSpd	( lu * 8 + getSpd() )		; //上昇レベル×5の値を既存値にプラスする
		setHpMax( getHp() )				; //更新後のhp_maxの値を代入する
	}

}
