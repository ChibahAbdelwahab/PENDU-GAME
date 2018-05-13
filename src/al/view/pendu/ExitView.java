package al.view.pendu;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/*
 *@description : cette classe se charge de la creation et du possitionnement des differents composants graphique 
 */
public class ExitView {

	
	private Label scorelbl;
	private Label pseudolbl;
	private Button enregistrer ;
	private Button nonenregistrer;
	private Button annuler;
	private Stage exitstage;
	private AnchorPane root = new AnchorPane();
	private Scene scene;
	private LoginView view;
	/**
	 * 
	 * @param view
	 */
	public ExitView(LoginView view){
		this.view=view;
		//Scene
		scene = new Scene(root,450,400);
		this.exitstage= new Stage();
		this.exitstage.setResizable(false);
		this.exitstage.setAlwaysOnTop(true);
		//Background
		ImageView img = new ImageView(new Image("al/Image/pendu/close.PNG"));
		img.fitWidthProperty().bind(scene.widthProperty());
		img.fitHeightProperty().bind(scene.heightProperty());
		//Lable du score
		scorelbl= new Label ("score");
		scorelbl.setTextFill(Color.RED);
		scorelbl.setLayoutX(320);
		scorelbl.setLayoutY(120);
		scorelbl.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
		 
		//Lable du pseudo 
		pseudolbl= new Label("pseudo");
		pseudolbl.setTextFill(Color.RED);
		pseudolbl.setLayoutX(80);
		pseudolbl.setLayoutY(120);
        pseudolbl.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
        
        //Button
		enregistrer= new Button("Enregistrer");
		enregistrer.setPrefSize(80, 20);
		enregistrer.setLayoutX(70);
		enregistrer.setLayoutY(250);
		
		//Button
		nonenregistrer= new Button("NonEnregistrer");
		nonenregistrer.setPrefSize(80, 20);
		nonenregistrer.setLayoutX(180);
		nonenregistrer.setLayoutY(250);
		
		//Button
		annuler= new Button("Annuler");
		annuler.setPrefSize(80, 20);
		annuler.setLayoutX(290);
		annuler.setLayoutY(250);
	    
		
		root.getChildren().addAll(img,enregistrer,nonenregistrer,annuler,scorelbl,pseudolbl);
		this.exitstage.setScene(scene);
		this.exitstage.show();
		
		
		
		
	}

	public LoginView getV() {
		return view;
	}


	public Label getScorelbl() {
		return scorelbl;
	}

	public Label getPseudolbl() {
		return pseudolbl;
	}

	public Button getEnregistrer() {
		return enregistrer;
	}

	public Button getNonenregistrer() {
		return nonenregistrer;
	}

	public Button getAnnuler() {
		return annuler;
	}
	
	

}
