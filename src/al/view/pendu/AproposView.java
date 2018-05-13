package al.view.pendu;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

/*
 * @description: cette classe gere tout ce qui est composants grphique concernant la fenetre apropos 
 * (creation des labels , button ...ext)
 */
public class AproposView {
	private Button fermer;
	private Text txt;
	private Stage aproposStage;
	AnchorPane root = new AnchorPane();
	Scene scene;
	/**
	 * 
	 */
	public AproposView(){
		//creation et positionement des diferentes composants graphique
		     //Scene
		scene = new Scene(root,576,365);
		this.aproposStage=new Stage();
		this.aproposStage.setResizable(false);
		     //button
		fermer = new Button("Fermer");
		fermer.setPrefSize(80, 20);
		fermer.setLayoutX(450);
		fermer.setLayoutY(270); 
		     // Background
		ImageView img = new ImageView(new Image("al/Image/pendu/Apropos.PNG"));
		root.getChildren().addAll(img,fermer);
		this.aproposStage.setScene(scene);
		this.aproposStage.show();
	}
	
	public Button getFermer() {
		return fermer;
	}

}
