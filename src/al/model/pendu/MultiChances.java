package al.model.pendu;

/**
 * Case a chances multiples 
 * @author CHIBAH BELDJILLALI 
 *
 */

public class MultiChances extends Case implements Malus {
	private static final byte chanceInitial=3;
	private static final byte score=1;
	private static final int malus = -2 ;
	
	public MultiChances(char lettreCorrecte) {
		super(lettreCorrecte, "MultiChances", chanceInitial);
		
	}

	@Override
	public int CalculeScore() {
		if(isCorrect())
		return score;						
		return 0;
		
	}

	@Override
	public int calculMalus() {
		return malus*(getNbTentativeqRatées());	
	}
	
	 
}
