package al.Controller.pendu;

import java.util.ArrayList;


import com.fxexperience.javafx.animation.FadeInDownTransition;
import com.fxexperience.javafx.animation.FadeOutUpTransition;
import com.fxexperience.javafx.animation.FlipTransition;
import com.fxexperience.javafx.animation.PulseTransition;
import com.fxexperience.javafx.animation.ShakeTransition;
import com.fxexperience.javafx.animation.TadaTransition;

import al.Main.pendu.MainExitWindow;
import al.model.pendu.Alphabet;
import al.model.pendu.Case;
import al.model.pendu.Jeu;
import al.model.pendu.Mot;
import al.model.pendu.MultiChances;
import al.model.pendu.Proposition;
import al.model.pendu.Session;
import al.model.pendu.ZeroChances;
import al.view.pendu.LoginView;
import al.view.pendu.ViewPartie;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
/**
 * Controller de la partie de jeu 
 * @author CHIBAH BELDJILLALI 
 */
public class ControllerPartie {
	private final int maxMotsRatés = 6 ;
	private Session session;
	private ViewPartie view;
	private int indiceMot ;
	private ArrayList<Button> caseDeJeu ;
	private  ArrayList<Button> propBtn ;
	private int score,scoreTotal=0 ; 
	private int indiceCase;
	private Button caseSelectionner ;
	private Mot [] motsSession;
	private int nbMotsRatés;
	private ImageView imagePrec;					//Utilisée pour remetre l'image du type de la case apres une tentative ratée
	private boolean PassagePossible=true;				//Posisblité de jouer sur une autre case : clique sur multichance => pas de passage jusqu'a tentatives = 0
	private boolean obligationMultichance=false;
	private FlipTransition flip ;
	private LoginView v;
	private Jeu jeu;
	public ControllerPartie( ViewPartie view , Session session,LoginView v,Jeu jeu) {
		this.session=session;
		this.view=view;
		this.view.setScorePrec(session.getJoueur().getMeilleurScore());
		this.caseDeJeu=view.getCurrentTexts();
		this.propBtn=view.getPropBtn();
		motsSession=session.getMotSession();
		this.v=v;
		this.jeu=jeu;
		//	Ajout des Evenements 
		
		//	Selection du bouton clicker 
		for(int i = 0 ; i <view.getCurrentTexts().size();i++){	
			view.getCurrentTexts().get(i).setOnAction(bouttonClicker);
		}
		//Retour a la fenetre principale
		view.getRetourBoutton().setOnMouseClicked(e->{
			PulseTransition pulse = new PulseTransition(view.getRetourBoutton());
			pulse.setOnFinished(ee->{
				retourMenu();
			});
			pulse.play();
		});
		
		//	Selection de la case clicker parmis les propositions 
		for(int i = 0 ; i <4;i++){
			propBtn.get(i).setOnAction(propPressed);
		}
		
		//	Recuperation du caractere a evaluer  
		view.getAnchorpane().setOnKeyPressed(e->{
			try{
				String text = e.getText().toString();
				char lettre=(char) (text.charAt(0)-97);
				if(motsSession[indiceMot].getCase(indiceCase).getClass()!=Proposition.class){			//Si la case selectionner n'est pas de type proposition	
					if(PassagePossible)
						imagePrec=(ImageView) caseSelectionner.getGraphic();
					if(!motsSession[indiceMot].getCase(indiceCase).isFin())								// si l'evaluation est possible sur la case 	
							caseSelectionner.setGraphic(new Alphabet().getImage(lettre));						//Afficher le caratere diretement sur la case selectionner 
					lettre=e.getText().toLowerCase().charAt(0);
					evaluer(lettre);
					}
				}catch(Exception exception){}//Click sur une touche non valide 
			});
		lancement();
		ajoutEvenement();
		
	}
	
	/**
	 * Fin de la session sur reussite ou echec 
	 */
	private void finDeLaSession() {
		session.getJoueur().setMeilleurScore(scoreTotal);
		session.setScore(scoreTotal);
		Stage stage = new Stage();
		MainExitWindow exit = new MainExitWindow(v,session,jeu);
		try {
			exit.start(stage);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	private void retourMenu() {
		this.v.remetreenordre();
		this.v.st.setScene(this.v.getSceneinitiale());
		
		
	}
	/**
	 * tentative sur la case selectionner 
	 * @param lettre	le caractere a evaluer 
	 */
	private void evaluer(char lettre) {
		view.retirerProposition();
		if(PassagePossible){
		Mot mot = motsSession[indiceMot];
		Case caseDeJeu = mot.getCase(indiceCase);
		
		caseDeJeu.evaluer(lettre);
		
		if(caseDeJeu.isFin()){				//fin du jeu sur la case 
			if(caseDeJeu.isCorrect())		//Case correcte
				caseCorrect();
			else							//Case incorrecte passage au mot suivant 	
				motRaté();
			}else{								//reponse incorrecte , chances restantes
				essaieRater(indiceCase);				
		}
		
		if((caseDeJeu.getClass()==MultiChances.class)&&(!caseDeJeu.isFin()))
			{
			obligationMultichance=true;
			//caseSelectionner.setGraphic(new ImageView("/Image/multi"+caseDeJeu.getNbChances()+".png"));
		}else
			obligationMultichance=false;
		actualiserScore();
		}
		
		
	}
	
	/**
	 * Actualisation du score de la Session 
	 */
	private void actualiserScore(){
		score=motsSession[indiceMot].calculScore();
		view.setScoreText(score+scoreTotal);
	}

	private void motRaté() {
		FadeOutUpTransition transout = null ;
		PassagePossible=false;
		for(int i = 0 ; i <motsSession[indiceMot].getNbCases();i++){
				final Button button = caseDeJeu.get(i);
				transout =new FadeOutUpTransition(button);
				if(i==motsSession[indiceMot].getNbCases()-1)
				transout.setOnFinished(e->{
					//view.affichageCases(motsSession[indiceMot+1].getNbCases());
					for(int k = 0 ; k <motsSession[indiceMot+1].getNbCases();k++){
						new FadeInDownTransition(caseDeJeu.get(k)).play();
						PassagePossible=true;
					}
					
					
						motSuivant();
				});
				transout.play();
		}
		nbMotsRatés++;
		if(nbMotsRatés==maxMotsRatés)
			finDeLaSession();
		view.setNbMotsRatés(nbMotsRatés);
	}


	private void motSuivant() {
		view.retirerProposition();
		if(indiceMot==motsSession.length-1)
			finDeLaSession();
		actualiserScore();
		scoreTotal=score+scoreTotal;
		view.incrementer();
		view.affichageReponse(motsSession[indiceMot].getMotCorrect(), indiceMot);
		indiceMot++;
		view.setIndication(motsSession[indiceMot].getTypeIndication(), motsSession[indiceMot].getIndication());
		ajoutEvenement();
	}





	private void essaieRater(int i) {
		ShakeTransition shake = new ShakeTransition(caseSelectionner);
		PassagePossible=false;
		shake.setOnFinished(e->{
			if(motsSession[indiceMot].getCase(indiceCase).getClass()==MultiChances.class)
				caseDeJeu.get(i).setGraphic(new ImageView("al/Image/pendu/multi"+motsSession[indiceMot].getCase(indiceCase).getNbChances()+".png"));
			else
				caseDeJeu.get(i).setGraphic(imagePrec);
			PassagePossible=true;
		});
		shake.play();
		
	}

	private void caseCorrect() {
		
		//Animation de la case 
		flip= new  FlipTransition(caseSelectionner);
		PassagePossible=false;
		flip.setOnFinished(e->{
			PassagePossible=true;
			//Traitement des cas 
			if(motsSession[indiceMot].isReussis())
				motSuivant();
			selectionCaseSuivante();
		});
		flip.play();
		
		
	}
	private void selectionCaseSuivante(){
		
	}

	/**
	 * Initialisation du view 
	 */
	private void lancement() {
		score=0;
		indiceMot=0;
		view.setName(session.getJoueur().getPseudo());
		view.setScoreText(score);
		view.incrementer();
		view.affichageCases(motsSession[indiceMot].getNbCases());
		view.setIndication(session.getMotSession()[0].getTypeIndication(), session.getMotSession()[0].getIndication());
	}
	
	/**
	 * Ajout des evenement au click sur les cases de jeu 
	 * utilise la variable indiceMot 
	 */
	public void ajoutEvenement(){
		//Recuperation du mot a jouer au niveau actuel 
		Mot mot = motsSession[indiceMot];
		//Parcourt de toutes les cases de jeu et affectation d'evenement differents selon la case 
		
		//Reinitialisation des cases de jeu 
		view.initCases();
		for(indiceCase=0 ; indiceCase<mot.getNbCases();indiceCase++){
					//Affichage de la case
					caseDeJeu.get(indiceCase).setVisible(true);
					//Retirer l'evenement eja definis si existant
					effacerEvementExistant(indiceCase);
					//Ajout de l'evenement  selon le type 
					if(mot.getCase(indiceCase).getClass() == Proposition.class)
						ajoutEvenementCaseProp(indiceCase);
					else
						if(mot.getCase(indiceCase).getClass() == MultiChances.class)
						ajoutEvenementCaseMulti(indiceCase);
					else
						if(mot.getCase(indiceCase).getClass() == ZeroChances.class)
						ajoutEvenementCaseZero(indiceCase);
				}
	}
	/**
	 * Retirer l'evenement deja existant au click sur la case 
	 * @param i le numero de la case 
	 */
	private void effacerEvementExistant(int i) {
		if(caseDeJeu.get(i).getOnMouseClicked()!=null){
			caseDeJeu.get(i).removeEventHandler(MouseEvent.MOUSE_CLICKED, clickProp);
		}
		
	}


	/**
	 * Ajout d'un evenement Pour une case Zero Chance 
	 * @param i 	numero de la case dans les cases de jeu
	 */
	private void ajoutEvenementCaseZero(int i) {
		caseDeJeu.get(i).setGraphic(new ImageView("al/Image/pendu/zero.png"));
		caseDeJeu.get(i).setOnMouseClicked(e->{
			view.retirerProposition();
		});
		
	}


	private void ajoutEvenementCaseMulti(int i) {
		caseDeJeu.get(i).setGraphic(new ImageView("al/Image/pendu/multi3.png"));	
		caseDeJeu.get(i).setOnMouseClicked(e->{
			obligationMultichance();
			view.retirerProposition();
		});
	}


	private void ajoutEvenementCaseProp(int i) {
		caseDeJeu.get(i).setGraphic(new ImageView("al/Image/pendu/prop.png"));
		caseDeJeu.get(i).setOnMouseClicked(e->{
			if(!motsSession[indiceMot].getCase(i).isFin() )
				if(PassagePossible&&(!obligationMultichance()))
				view.ajouterproposition(((Proposition)(motsSession[indiceMot].getCase(indiceCase))).getProposition());
			else 
				finCase();
		});
	}
	
	/**
	 * Fin de jeu sur la case clicker
	 */
	private void finCase() {
		
			
	}
	private final EventHandler<MouseEvent> clickProp= new EventHandler<MouseEvent>(){
		@Override
		public void handle(MouseEvent e) {
			view.ajouterproposition(((Proposition)(motsSession[indiceMot].getCase(indiceCase))).getProposition());
		}
		
	};
	/**
	 * 	Evenement de click sur une case contenant une des propositions
	 * 	Evaluation de la touche clicker sur la case selectionner 
	 */
	private final EventHandler<ActionEvent> propPressed = new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent e) {
			//Recuperation de l'indice de la case selectionner 
			int ind = propBtn.indexOf((Button)(e.getSource()));
		
			//Recuperation de la lettre contenue dans cette case 
			char lettre =((Proposition)(motsSession[indiceMot].getCase(indiceCase))).getProposition()[ind] ;
			
			//Ajout du caratere choisis dans la case Proposition et evaluation 
			caseSelectionner.setGraphic(new Alphabet().getImage(lettre-'a'));
			evaluer(lettre);
			e.consume();
			
		}
	};
	
	/**
	 *	Evenement au click sur un boutton 
	 *	Recuperation du Bouton clicker dans caseSelectionner 
	 */
	private final EventHandler<ActionEvent> bouttonClicker= new EventHandler<ActionEvent>(){
		@Override
		public void handle(ActionEvent e) {
			if(!obligationMultichance()){
				caseSelectionner=(Button) e.getSource();
				indiceCase=caseDeJeu.indexOf(caseSelectionner);
				view.setCaseClicke(caseSelectionner);
				new PulseTransition(caseSelectionner).play();	
			}
		}
			
	};
	/**
	 * Traitement de l'obligation de jeu sur une case multichance 
	 */
	private boolean obligationMultichance(){
		if(obligationMultichance)
			new TadaTransition(caseSelectionner).play();
		return obligationMultichance;
	}
	
	public LoginView getV() {
		return v;
	}
	
}
