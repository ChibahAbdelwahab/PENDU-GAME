package al.model.pendu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;
import java.util.StringTokenizer;
/**
 * Classe Session gestion de la partie de jeu ,initialisation des mots du fichier texte 
 * @author CHIBAH BELDJILLALI
 *
 */
public class Session {
	private final int longeurMinimale = 6 ; 							  //Nombre de caractere minimal dans un mot 
	private Compte joueur ;
	private static String nomFichier;
	private  static final int motParSession = 10;                         // Le nombre de mot a jouer par session 
	private Mot[] motSession = new Mot[motParSession];                    // la liste des mots proposés
	private int Score=0;                                                  // score de la session
	private Mot currentMot;                                               // le mot Actuel auquel on joue
	private int indicecurentmot=0;
	

	
	public Session (Compte joueur) throws IOException   {
		
		this.joueur=joueur;
		initialisation ();     				//importer les mot du fichier et creation des mots 
	}
	/**
	 * Initialisation creation des mots de la session 
	 * @throws IOException
	 */
	private void initialisation() throws IOException {
		
			//Tableaux dynamiques transitoires
		ArrayList<String> motsFichier =new ArrayList<String> ();
		ArrayList<String> typeIndicationsFichier =new ArrayList<String> ();
		ArrayList<String> indicationsFichier =new ArrayList<String> ();
			int indice  =0;
	        BufferedReader in = null;
	        String ligne;
	        try {
	            in = new BufferedReader(new InputStreamReader(new FileInputStream("src/al/mots.poo"), "UTF-8"));
	            while ((ligne = in.readLine())!= null){
	            	
	            	//Recuperation de la ligne 
		            StringTokenizer tok = new StringTokenizer(ligne,";?");
		           
		            //Recuperation des champs de la ligne 
		            typeIndicationsFichier.add(tok.nextToken());
		            indicationsFichier.add(tok.nextToken());
		            motsFichier.add(tok.nextToken());
		           
		            if(motsFichier.get(motsFichier.size()-1).length()<=longeurMinimale){ 				//Longeur du mot non suffisante 
		            	typeIndicationsFichier.remove(motsFichier.size()-1);							//Supression du mot 
		            	indicationsFichier.remove(motsFichier.size()-1);	
		            	motsFichier.remove(motsFichier.size()-1);
		            	}
		            }                      
	        	} finally {
	        		if (in != null) 
	                in.close();                  
	        }
	    	Random rand = new Random();
	       
	        for (int i=0;i<motParSession;i++){
	        	indice=rand.nextInt(motsFichier.size()-1);
	        	
	        	//Creation du mot 
				motSession[i]=new Mot(motsFichier.get(indice),indicationsFichier.get(indice),TypeIndication.valueOf(typeIndicationsFichier.get(indice)));

	        	//Supression de l'element choisis precedemment 
	        	motsFichier.remove(indice);
	        	typeIndicationsFichier.remove(indice);
	        	indicationsFichier.remove(indice);
	        }
			
	        
	  }
	  
	  public int scoreSession(){
		
		  return Score;
	  }
		public int getScore() {
			return Score;
		}


		public void setScore(int score) {
			Score = score;
		}

		public Mot getCurrentMot() {
			return currentMot;
		}


		public void setCurrentMot(Mot currentMot) {
			this.currentMot = currentMot;
		}


		public int getIndicecurentmot() {
			return indicecurentmot;
		}


		public void setIndicecurentmot(int indicecurentmot) {
			this.indicecurentmot = indicecurentmot;
		}
	
	
		public Compte getJoueur() {
			return joueur;
		}


		public void setJoueur(Compte joueur) {
			this.joueur = joueur;
		}
		public static String getNomFichier() {
			return nomFichier;
		}


		public static void setNomFichier(String nomFichier) {
			Session.nomFichier = nomFichier;
		}


		public Mot[] getMotSession() {
			return motSession;
		}


		public void setMotSession(Mot[] motSession) {
			this.motSession = motSession;
		}



		public static int getMotparsession() {
			return motParSession;
		}


	

}
