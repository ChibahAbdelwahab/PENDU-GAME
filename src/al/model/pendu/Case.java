package al.model.pendu;
/**	
 *	Classe abstraite case contient les methode d'evaluation et de changement de l'etat de la case
 * @author CHIBAH BELDJILLALI
 *
 */
public abstract class Case {
	private int score;
	private String type;
	private char lettreCorrecte;
	private int nbChances ; 	
	private int nbTentativeqRatées=0;
	private boolean fin,correct=false;
	
	public Case(char lettreCorrecte , String type , int nbChances) {	// Recuperation de la lettre correcte le type et le nombres de chances possibles
		this.lettreCorrecte=lettreCorrecte;
		this.type=type;	
		this.nbChances=nbChances;
		
	}

	/**
	 * Evaluation d'un caractere sur la case 
	 * @param c le caractere a evaluer 
	 */
	public  void evaluer(char c ){			//Tentative sur la case
		nbChances--;
		if(!fin){
			if(c==lettreCorrecte){ 			//lettre evaluée correcte
				fin=true;
				setCorrect(true);
			}else
				nbTentativeqRatées++;
			if(nbChances==0)
					fin=true;
			}
		
	}
	public abstract int CalculeScore();	//Affectation d'une valeur au score (Malus) selon le type et les resultats  

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	public void setNbChances(int n ){
		nbChances=n;
	}
	public int getNbChances(){
		return nbChances;
	}
	public char getLettreCorrecte() {
		return lettreCorrecte;
	}

	public boolean isFin() {
		return fin;
	}


	public void setFin(boolean fin) {
		this.fin = fin;
	}


	public boolean isCorrect() {
		return correct;
	}

	public void setCorrect(boolean correct) {
		this.correct= correct;
	}


	public int getNbTentativeqRatées() {
		return nbTentativeqRatées;
	}


	public void setNbTentativeqRatées(int nbTentativeqRatées) {
		this.nbTentativeqRatées = nbTentativeqRatées;
	}
	
	
}
