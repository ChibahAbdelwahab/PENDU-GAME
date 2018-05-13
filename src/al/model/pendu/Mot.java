package al.model.pendu;

import java.util.Random;
/**
 * Mot regroupe un tableau de cases de jeu , et effectue le calcul du score total
 * @author CHIBAH BELDJILLALI 
 *
 */
public class Mot {
	private final int maxPropZero=3;
	private Case[] cases ; 		// Tableau de cases 
	private int nbCases;
	private boolean fin;
	private String motCorrect;
	private int score,malus;
	private int nbProp=0,nbMulti=0,nbZero=0;
	private String indication;
	private TypeIndication typeIndication;
	private int coeff;
	

	/**
	 * Contructeur
	 * @param Correct			Le mot correct 
	 * @param indication		l'indication	
	 * @param typeIndication	le type de l'indication
	 */
	public Mot(String correct , String indication, TypeIndication typeIndication) {
		this.motCorrect=correct;
		this.setIndication(indication);
		this.setTypeIndication(typeIndication);
		chargement();
		coeff=typeIndication.getCoeff();
	}
	
	/**
	 * Chargement des case du mot aleatoirement 
	 */
	private void chargement() {
		nbCases=motCorrect.length(); //Nombre de cases == Longeur de la chaine 
		cases=new Case[nbCases];
		int i = 0,indice=0 ;
		Random rand = new Random();
		while (i<nbCases){
			char lettre= motCorrect.charAt(i);
			indice=rand.nextInt(3);
			switch(indice){					//Nombre Aleatoire pour le choix du type
			case 0 : 				    //Case zeroChances
				if(nbZero+nbProp<=maxPropZero){
					cases[i]=new ZeroChances(lettre);
					nbZero++;
					i++;
					score+=3;
					}
				break;
			case 1 : 				//Case MultiChances
				cases[i]=new MultiChances(lettre);
				nbMulti++;
				i++;
				score+=2;
				break;
			case 2 :				//Case Proposition
				if(nbZero+nbProp<=maxPropZero){
					cases[i]= new Proposition(lettre);
					nbProp++;
					i++;
					score+=1;
					}
				break ;
			}
		}
		
	}
	
	/**
	 * Calcul du Score sur le mot 
	 * @return le Score total 
	 */
	public int calculScore(){    
		score=0;
		malus=0;
		for(int i = 0 ; i<nbCases;i++)					// Cumul du score pour les cases correctes 
			score+=cases[i].CalculeScore();
			score=score*coeff;
		//Traitement du Malus
		if((nbProp+nbMulti)>=5) //calcul du malus
		   for(int i = 0 ; i< nbCases; i++)
			  if(cases[i] instanceof Malus)
				 malus+=((Malus)cases[i]).calculMalus(); //cumul du malus (malus<=0)
		//Calcul du score final 
		score=score+malus;
		return score;
	}
	
	public Case getCase(int i) {
		return cases[i];
	}
	
	public boolean isFin() {
		return fin;
	}

	public boolean isReussis() {
		for(int i = 0 ; i<nbCases;i++)
			if(!cases[i].isFin())
				return false ;	
		return true;
	}

	public String getMotCorrect() {
		
		return motCorrect;
	}

	public int getScore() {
		
		return score;
	}

	public int getNbProp() {
		return nbProp;
	}

	public int getNbMulti() {
		return nbMulti;
	}

	public int getNbZero() {
		return nbZero;
	}

	public int getNbCases() {
		return nbCases;
	}
	public void setNbCases(int nbCases) {
		this.nbCases = nbCases;
	}

	public String getIndication() {
		return indication;
	}

	public void setIndication(String indication) {
		this.indication = indication;
	}

	public TypeIndication getTypeIndication() {
		return typeIndication;
	}

	public void setTypeIndication(TypeIndication typeIndication) {
		this.typeIndication = typeIndication;
	}

	
}
