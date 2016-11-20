package at.ac.tuwien.big.leveldesign.ui.interpretation;

import at.ac.tuwien.big.leveldesign.ui.model.MonsterView;

public class MonsterStrengthInterpretaton {
	
	private final static int MAX_STRENGTH = 1000*100; //hp * damage/sec
	
	private final static double MAX_SIZE = 64;
	private final static double MIN_SIZE = 16;
	
	public double strengthSize(MonsterView monster) {
		
		double monsterStrength = (monster.getDamage()/monster.getSpeed())*monster.getHp();	
		double size = MAX_SIZE*(monsterStrength/MAX_STRENGTH);
		
		if(size<MIN_SIZE) return MIN_SIZE;
		else if(size>MAX_SIZE) return MAX_SIZE;
		return size;
		
	}
	
}
