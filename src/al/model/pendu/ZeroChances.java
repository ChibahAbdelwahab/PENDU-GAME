package al.model.pendu;
/**
 * Classe ZeroChances 
 * @author CHIBAH BELDJILLALI 
 *
 */
public class ZeroChances extends Case {
	private static final int chanceInitial=1;		//Nombre de chances initales 
	private static final int score=3;				// Score pour une reponse correcte dans la case

	
	
	public ZeroChances(char lettreCorrecte) {
		super(lettreCorrecte,"ZeroChances",chanceInitial);
	}

	
	@Override
	public int CalculeScore() {
		if(isCorrect())
		return score;				// Score complet si reponse corecte
		return 0 ; 				// Score incorrect sinon 
	}		
	
	
	
}
