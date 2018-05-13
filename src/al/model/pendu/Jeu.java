package al.model.pendu;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TreeMap;
/**
 * Classe jeu gestion des scores deja existant dans un fichier 
 * @author CHIBAH BELDJILLALI 
 *
 */
public class Jeu  {
	


	private Set<Compte> joueurs = new HashSet<Compte>();
	private TreeMap<String, Integer> bestScorejeu = new TreeMap<String,Integer>(); // une map qui contient les meilleures scores du jeu avec le nom du joueur
	private HashMap<String, Integer> hashbestScorejeu = new HashMap<String,Integer>();
	private boolean exist ;
	
	
	
	public TreeMap<String, Integer> getBestScorejeu() {
		return bestScorejeu;
	}






	public Jeu () throws Exception {
	restaurer();
	}
	
	
	public void restaurer() throws Exception, IOException{
		
		BufferedReader in = null;
	      try {
	            in = new BufferedReader(new InputStreamReader(new FileInputStream("src/al/save.txt"), "UTF-8"));
	            String ligne;
	            String nom;
	            int score;
	            
	            while ((ligne = in.readLine())!= null){
	            	
	            	//Recuperation de la ligne 
		            StringTokenizer tok = new StringTokenizer(ligne," ");
		            
		            nom=tok.nextToken();
		            score=Integer.valueOf(tok.nextToken());
		            bestScorejeu.put(nom, score);
		            hashbestScorejeu.put(nom,score );
	            } 
	      }
	            catch(Exception e){
	            	
	            }
	        	 finally {
	        		if (in != null) 
	                in.close();                  
	        }
	}
	
	
	
	public void ajouterCompte   (Compte compte) throws AuthentificationException 
	{ 
		exist=joueurs.add(compte);
	}
	public boolean exist(){
		return exist;
	}
	
	
	
	public Set<Compte> getJoueurs() {
		return joueurs;
	}




	public void setJoueurs(Set<Compte> joueurs) {
		this.joueurs = joueurs;
	}


	
	

}
