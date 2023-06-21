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
		super.setLv( lu * 1 + super.getLv() )					; //上昇レベル×1の値を既存値にプラスする
		super.setHp( lu * 29 + this.getHp() )	; //上昇レベル×30の値を既存値にプラスする
		super.setAtk( lu * 8 + this.getAtk() )					; //上昇レベル×5の値を既存値にプラスする
		super.setDef( lu * 5 + this.getDef() )					; //上昇レベル×5の値を既存値にプラスする
		super.setSpd (lu * 9 + this.getSpd() )					; //上昇レベル×5の値を既存値にプラスする
		super.setHpMax( this.getHp() )							; //更新後のhp_maxの値を代入する
	}

}
