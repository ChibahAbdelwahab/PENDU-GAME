package al.model.pendu;

import java.util.Arrays;
import java.util.Random;

/** 
 * Classe proposition Hertie de la classe case choix entre les propositions proposées 
 * @author CHIBAH BELDJILLALI 
 *
 */

public class Proposition extends Case  implements Malus{
	private static final int chanceInitial=1;						//Nombre de chances initales 
	private static final int score=2	;							// Score pour une reponse correcte 
	private static final int malus = -1;							//Malus reponse incorrecte 
	private char[] propositions = new char [4];     				// Propositions de la case 
	
	
	
	public Proposition(char lettreCorrecte) {
		super(lettreCorrecte, "Proposition", chanceInitial);
		propositionsAleatoires();									//Generer des proposition aleatoires  et differentes 
	}

	@Override
	public int CalculeScore() {		 							    //rend score si il est correcte 
		if(isCorrect())
		return  score ;					
		return 0;			
	}		

		
	
	/**
	 * Calcul du malus de la case 
	 */
	@Override
	public int calculMalus() {									
		return malus*(getNbTentativeqRatées());					
	}

	
	/**
	 * Generer des proposition aleatoires differentes 
	 */
	public void propositionsAleatoires(){				
		Random r = new Random();					
		char [] alph = new char[27];
		
		//Remplir a un tableau de caracteres 
		for(int i = 0 ; i< 26 ; i++){
			alph[i]=(char)(i+ 'a');
			}
		//Tableau pour les 4 propositions possibles ;
		propositions[0]=getLettreCorrecte();
		alph=remove(alph,getLettreCorrecte()-'a');
		
		for(int i = 1 ; i<=3;i++){
			int random = r.nextInt(alph.length-1);
			propositions[i]=alph[random];
			alph=remove(alph ,random);
			}
		Arrays.sort(propositions);
	}
	public char[] getProposition(){
		return propositions;
	}
	 public char[] remove(char[] symbols, int i)
	   {
	           char[] copy = new char[symbols.length-1];
	               System.arraycopy(symbols, 0, copy, 0, i);
	               System.arraycopy(symbols, i+1, copy, i, symbols.length-i-1);
	               return copy;	       
	   }

}
