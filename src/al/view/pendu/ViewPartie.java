package al.view.pendu;

import java.util.ArrayList;

import al.model.pendu.Alphabet;
import al.model.pendu.TypeIndication;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.effect.Effect;
import javafx.scene.effect.Glow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

/**
 * View de la partie de jeu contient les boutons de jeu , Score , indication et Pseudo 
 * @author CHIBAH BELDJILLALI 
 *
 */

public class ViewPartie {
	// 						Espace de travail
	private AnchorPane anchorpane = new AnchorPane();
	private StackPane root = new StackPane();
	private GridPane gridpane=new GridPane();
	private HBox box = new HBox();
	private HBox propBox = new HBox ();
	private Scene scene = new Scene(root,1000,654);
	//						Images 
	private ImageView imageDeFond = new ImageView("al/Image/pendu/background.png");
	//						Boutons 
	private ArrayList<ArrayList<Button>> texts = new ArrayList<ArrayList<Button>>();
	private ArrayList<Button> currentTexts = new ArrayList<Button>(11);
	private ArrayList<Button> propBtn = new  ArrayList<Button>(4);
	private Button retourBoutton = new Button();
	private Button caseClicke;
	
	//						Labels 
	private Label imagePendu = new Label("");
	private Label scorePrec =  new Label("");
	private Label nomJoueur = new Label("");
	private Label scoreText = new Label("");
	private Label nbMotsRatés = new Label("");
	private Label indication = new Label("");
	private Label typeIndication = new Label("");
	//						Autres
	private Alphabet a = new Alphabet();
	private int current = -1 ;
	private double boxPositionX;
	//						Constantes 
	private final int nbcases = 9; 
	private final int nbmots = 9 ;


	public ViewPartie() {
		//Ajout de l'image de fond 
		root.getChildren().add(imageDeFond);
		root.getChildren().add(anchorpane);

		
		//Ajout de la representaion du pendu 
		imagePendu.setLayoutX(750);
		imagePendu.setLayoutY(190);
		anchorpane.getChildren().add(imagePendu);
				
		//Affichage nom du joueur 
		nomJoueur.setLayoutX(780);
		nomJoueur.setLayoutY(175);
	    nomJoueur.setTextFill(Color.WHITESMOKE);
	    nomJoueur.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
	    final Effect glow = new Glow(0.3);
	    nomJoueur.setEffect(glow);	
		anchorpane.getChildren().add(nomJoueur);
		
		//Affichage du score 
		scoreText.setLayoutX(875);
		scoreText.setLayoutY(60);
		scoreText.setText("Score");
	    scoreText.setTextFill(Color.WHITESMOKE);
	    scoreText.setFont(Font.font(java.awt.Font.MONOSPACED, 15));
	    scoreText.setEffect(glow);
	    anchorpane.getChildren().add(scoreText);
		
	    //Affichage du score Precedent
		scorePrec.setLayoutX(850);
		scorePrec.setLayoutY(35);
		scorePrec.setText("Meilleure Score");
	    scorePrec.setTextFill(Color.WHITESMOKE);
	    scorePrec.setFont(Font.font(java.awt.Font.MONOSPACED, 10));
	    scorePrec.setEffect(glow);
	    anchorpane.getChildren().add(scorePrec);
	
	    //Affichae du nombre de mot ratés 
	    nbMotsRatés.setLayoutX(790);
	    nbMotsRatés.setLayoutY(85);
	    nbMotsRatés.setText("Mots \nRatés  \n   0");
	    nbMotsRatés.setTextFill(Color.WHITESMOKE);
	    nbMotsRatés.setFont(Font.font(java.awt.Font.MONOSPACED, 13));
	    nbMotsRatés.setEffect(glow);
	    nbMotsRatés.setRotate(32.0);
	    anchorpane.getChildren().add(nbMotsRatés);
	    
	    //Affichage de l'indication 
	    indication.setLayoutX(100);
	    indication.setLayoutY(575);
	    indication.setFont(Font.font(java.awt.Font.MONOSPACED, 14));
	    indication.setEffect(glow);
	    indication.setTextFill(Color.WHITESMOKE);
	    indication.setText("Indication  ");
	    anchorpane.getChildren().add(indication);
		
	    //Affichage de l'indication 
	    typeIndication.setLayoutX(480);
	    typeIndication.setLayoutY(510);
	    typeIndication.setFont(Font.font(java.awt.Font.MONOSPACED, 14));
	    typeIndication.setEffect(glow);
	    typeIndication.setTextFill(Color.WHITESMOKE);
	    typeIndication.setText("Indication  ");
	    anchorpane.getChildren().add(typeIndication);
	    
	    //Effect ombre pour les cases de jeu 
  		DropShadow dropShadow = new DropShadow();
  		dropShadow.setRadius(5.0);
  		dropShadow.setOffsetX(5.0);
  		dropShadow.setOffsetY(5.0);
  		dropShadow.setColor(Color.BLACK);
	  		
	  		
		//Boutton de retour 
	    retourBoutton.setGraphic(new ImageView("al/Image/pendu/ButtonRetour.png"));
	    retourBoutton.setLayoutX(55);
	    retourBoutton.setLayoutY(20);
	    retourBoutton.setStyle("-fx-background-color: rgba(231,217,217,0.0);");
	    retourBoutton.setEffect(dropShadow);								//Effect ombre pour la case 
	    retourBoutton.setTextFill(Color.BLACK);
	    anchorpane.getChildren().add(retourBoutton);
	    
		
		Button text;

		
		//initialisation des cases 
		for(int j = 0 ; j <= nbmots ; j ++ ){
			texts.add( new ArrayList<Button>());	
			for(int i = 0 ; i <= nbcases ; i++ ){
				text= new Button();
				text.setMaxHeight(20);
				text.setPrefWidth(20);
				text.setStyle("-fx-background-color: rgba(0, 0, 0, 0);");
				text.setGraphic(a.getImage(27)); 
				text.setEffect(dropShadow );
				texts.get(j).add(text);
				gridpane.add(texts.get(j).get(i), i, j);
			}
		}
		
		//positionnement dans un grid 
		gridpane.setAlignment(Pos.CENTER);
		gridpane.setLayoutX(180);
		gridpane.setLayoutY(100);
		anchorpane.getChildren().add(gridpane);
	
		//Initialisation des cases de jeu 
		for(int i = 0 ; i<= nbcases ; i++){
			this.currentTexts.add(new Button());									
			this.currentTexts.get(i).setMaxHeight(30);
			this.currentTexts.get(i).setMaxWidth(30);
			this.currentTexts.get(i).setStyle("-fx-background-color: rgba(231,217,217,0.3);");
			this.currentTexts.get(i).setEffect(dropShadow);								//Effect ombre pour la case 
			this.currentTexts.get(i).setTextFill(Color.BLACK);
		}
		
		box.getChildren().addAll(this.currentTexts);
		box.setLayoutX(gridpane.getLayoutX());
		box.setLayoutY(255);
		boxPositionX=box.getLayoutX();
		anchorpane.getChildren().add(box);
		
		//Initialisation des bouttons de propositions 
		for(int i = 0 ; i <= 3 ; i ++){
			propBtn.add(new Button());
			propBtn.get(i).setMaxSize(30,30);
			propBtn.get(i).setVisible(false);
			propBtn.get(i).setStyle("-fx-background-color: rgba(51,0,0,0.6);");
		}
		//Ajout des boutons dans le box des propositions 
		propBox.getChildren().addAll(propBtn);
		//Ajout du Box sur l'espace de travail 
		anchorpane.getChildren().add(propBox);
		
	}

	public void setScorePrec(int scorePrec) {
		this.scorePrec.setText("Meilleure Score\n    "+scorePrec);
	}

	
	/**
	 *  Passage au mot suivant 
	 *
	 */
	public void incrementer() {
		current++;
		if(current==10)
			current=0;
		for(int j =Math.max(current-1, 0) ; j <texts.size() ; j++){
			for(int i = 0 ; i <texts.get(j).size(); i ++  ){
				if(j==current){
					texts.get(j).get(i).setPrefHeight(50);
					texts.get(j).get(i).setMaxHeight(50);
					texts.get(j).get(i).setVisible(false);
				}else{
					texts.get(j).get(i).setVisible(true);
					texts.get(j).get(i).setMaxHeight(30);
					texts.get(j).get(i).setPrefHeight(30);
				}
			}
			}
		box.setLayoutY(gridpane.getLayoutY()+38*current);
	}
	
	/**
	 * Description Affichage des proposition pour le mot courant 
	 * @param prop  indice du caractere a proposer 
	 */
	public void ajouterproposition( char [] prop){
		
		propBox.setLayoutX(caseClicke.getLayoutX()+150);
		propBox.setLayoutY(box.getLayoutY()+45);
		propBox.toFront();	
		for(int i = 0 ; i <= 3;i++ ){
			propBtn.get(i).setGraphic(a.getImage(prop[i]-'a'));
			propBtn.get(i).setVisible(true);
		}
	}
	
	/**
	 * Retirer les proposition de l'affichage 
	 */
	public void retirerProposition(){
		for(int i = 0 ; i <= 3;i++ ){
			propBtn.get(i).setVisible(false);
		}
		propBox.toBack();
	}
	
	
	/**
	 * Affichage de la reponse correcte d'un mot au passage au suivant et desactivation des cases non utiles 
	 * @param reponse	la reponse correcte a afficher 
	 * @param ligne		la ligne du mot a afficher 
	 */
	public void affichageReponse(String reponse , int ligne){
		for(int i=0;i<texts.get(ligne).size();i++)
			if(i<reponse.length()){
				texts.get(ligne).get(i).setGraphic(a.getImage(reponse.charAt(i)-97));			//Affichage du caractere correcte
				texts.get(ligne).get(i).setVisible(true);
			}else
				texts.get(ligne).get(i).setVisible(false);										//Desactivation de la case pour une taille> longeur de la reponse 
		}
	
	
	
	
	public ArrayList<ArrayList<Button>> getTexts() {
		return texts;
	}
	public void setTexts(ArrayList<ArrayList<Button>> texts) {
		this.texts = texts;
	}
	public ArrayList<Button> getCurrentTexts() {
		return currentTexts;
	}
	public void setCurrentTexts(ArrayList<Button> currentTexts) {
		this.currentTexts = currentTexts;
	}
	public int getCurrent() {
		return current;
	}
	public void setCurrent(int current) {
		this.current = current;
	}

	public void setName(String name){
		this.nomJoueur.setText(name);
	}

	public Scene getScene(){
		return scene;
	}
	public Button getCaseClicke() {
		return caseClicke;
	}
	public void setCaseClicke(Button caseClicke) {
		this.caseClicke = caseClicke;
	}
	public ArrayList<Button> getPropBtn() {
		return propBtn;
	}
	public void setPropBtn( ArrayList<Button> propBtn) {
		this.propBtn = propBtn;
	}
	public Label getNomJoueur() {
		return nomJoueur;
	}
	public void setNomJoueur(Label nomJoueur) {
		this.nomJoueur = nomJoueur;
	}
	public Label getScoreText() {
		return scoreText;
	}
	public void setScoreText(int   scoreText) {
		this.scoreText.setText("Score \n  "+scoreText);
	}

	public AnchorPane getAnchorpane() {
		return anchorpane;
	}
	public void setAnchorpane(AnchorPane anchorpane) {
		this.anchorpane = anchorpane;
	}
	public Button getRetourBoutton() {
		return retourBoutton;
	}

	public void setRetourBoutton(Button retourBoutton) {
		this.retourBoutton = retourBoutton;
	}

	/**
	 * Affichage du nombre de mots ratés et actualisation de la represetation du pendu 
	 * @param nbMotsRatés		le nombre mots ratés actuel 
	 */
	public void setNbMotsRatés(int nbMotsRatés) {
		imagePendu.setGraphic(new ImageView("al/Image/pendu/pendu"+nbMotsRatés+".png"));
		this.nbMotsRatés.setText("Mots \nRatés  \n   "+nbMotsRatés);
	}

	/**
	 * Permet d'actualiser l'affichage de l'indication ainsi que son type 
	 * @param type	le type de l'indicaiton 
	 * @param indication	L'indication en chaine de caracteres 
	 */
	public void setIndication(TypeIndication type , String indication){
		typeIndication.setText(type.toString());
		this.indication.setText(indication);
	}
	
	public void decalageGrid(int decalage) {
		box.setLayoutX(boxPositionX-20*decalage);
	}


	public void initCases() {
		for(int i= 0 ; i <= nbcases; i ++ )
			currentTexts.get(i).setVisible(false);
	}

	/**
	 * *Affichage des cases de jeu selon la taille du mot 
	 * @param nb nombre de caracteres dans le mot 
	 */
	public void affichageCases(int nb) {
		initCases();
		for(int i= 0 ; i < nb; i ++ )
			currentTexts.get(i).setVisible(true);
		
	}
	
}
