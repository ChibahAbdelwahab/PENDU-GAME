package al.view.pendu;
	
import java.util.Scanner;

import com.sun.prism.paint.Color;

import al.Controller.pendu.ControllerLoginView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.stage.*;
/*
 * @description : cette classe represente la fenetre d'entrée se charge de tout se qui positionnement creation des differents composants graphique
 * 
 */

public class LoginView {
	private Button startplay;
	private TextField  txt ;
	private Label nomUtilisateur;
	private Label message;
	private Button regle ;
	private Button meilleurScore;
	private Button apropos;
	private Button son;
	public Stage st;
	private Scene scene;
	private Scene sceneinitiale;
	/**
	 * 
	 */
	public LoginView()
	{
			AnchorPane root = new AnchorPane();
			//scene
			scene = new Scene(root,1000,654);
			this.st=new Stage();
			this.st.setResizable(false);
			//Background
			ImageView img = new ImageView(new Image("al/Image/pendu/last.PNG"));
			img.fitWidthProperty().bind(scene.widthProperty());
			img.fitHeightProperty().bind(scene.heightProperty());
			   // message d'erreur 
			message = new Label("");
			message.setStyle("-fx-background-color: rgba(0,0,0,0);");
			message.setVisible(true);
		    message.setLayoutX(395);
		    message.setLayoutY(282);
		       //   button de lancement du jeu  
			startplay= new Button("Valider");
			startplay.setLayoutX(410);
			startplay.setLayoutY(302);
			   /** button regle **/
			regle=new Button("Règles");
			regle.setPrefSize(120, 20);
			regle.setLayoutX(150);
			regle.setLayoutY(600);
			  //    button meilleurescore      
			meilleurScore = new Button("Meilleurs Scores");
			meilleurScore.setPrefSize(120, 20);
			meilleurScore.setLayoutX(450);
			meilleurScore.setLayoutY(600);
			    //   apropos button         
			apropos=new Button("Apropos");
			apropos.setPrefSize(120, 20);
			apropos.setLayoutX(750);
			apropos.setLayoutY(600);
			    // champ de saisie 
		    txt = new TextField();
		    txt.setLayoutX(355);
		    txt.setLayoutY(235);
		        //button son
		    son = new Button("");
		    son.setGraphic(new ImageView(new Image("al/Image/pendu/soundon.PNG")));
		    son.setMaxHeight(30);
		    son.setMaxWidth(30);
		    son.setStyle(
	                "-fx-background-radius: 90; " 
	        );
		    son.setLayoutX(50);
		    son.setLayoutY(475);
		    sceneinitiale=scene;
			root.getChildren().addAll(img,message,txt,startplay,regle,apropos,meilleurScore,son);
			this.st.setScene(scene);
			this.st.show();
	}
	
	//pour restaurer la fenetre de login a la fin de partie ou quand l'utilisateur veut retouner au menu
	public void remetreenordre(){
		startplay.setText("Valider");
		message.setText("");
		txt.setText("");
	}
	
	public Scene getScene() {
		return scene;
	}

	public Button getSon() {
		return son;
	}

	
	public Button getStartplay() {
		return startplay;
	}

	public void settxtinStartplay(String string) {
		this.startplay.setText(string); 
	}
	
	public String getTxtinfield() {
		return txt.getText();
	}
	public void Settextmessage(String string)
	{
		this.message.setTextFill(javafx.scene.paint.Color.RED);
		this.message.setText(string); 
	}
	
	public void Settextmessageok(String string)
	{
		this.message.setTextFill(javafx.scene.paint.Color.GREEN);
		this.message.setText(string); 
	}
	public void SetImagemessage(ImageView Img)
	{
		
		this.message.setGraphic(Img);
		
	}
	public Label getmessagelbl()
	{
		return this.message;
	}

	public Button getRegle() {
		return regle;
	}
	
	public Button getApropos() {
		return apropos;
	}

	public Button getMeilleurScore() {
		return meilleurScore;
	}
	public Scene getSceneinitiale() {
		return sceneinitiale;
	}
	
}
