package al.view.pendu;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class RegleView {
	private Button fermer;
	private Stage regleStage;
	
	/*
	 * @description : cette classe charge de la creation et du possitionnement des differents composant graphiquee
	 */
	public RegleView(){
		AnchorPane root  = new AnchorPane();
		Scene scene = new Scene(root,683,482);
		this.regleStage=new Stage();
		this.regleStage.setResizable(false);
		//button
		fermer = new Button("Fermer");
		fermer.setPrefSize(80, 20);
		fermer.setLayoutX(520);
		fermer.setLayoutY(380);
	     //background
		ImageView img = new ImageView(new Image("al/Image/pendu/indication.PNG"));
		img.fitWidthProperty().bind(scene.widthProperty());
		img.fitHeightProperty().bind(scene.heightProperty());
		//background
		root.getChildren().addAll(img,fermer);
		this.regleStage.setScene(scene);
		this.regleStage.show();
	}
	
	public Button getFermer() {
		return fermer;
	}

}
