package al.Main.pendu;

import java.io.File;
import java.io.InputStream;

import al.Controller.pendu.ControllerLoginView;
import al.model.pendu.Jeu;
import al.view.pendu.LoginView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.application.Application;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


/*
 * @description : cette classe est le point de depart de l'execution.
 *        
 */
public class pricipale extends Application {
	/**
	 * 
	 * @param args
	 */

	public static void main(String[] args) {
		launch(args);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
             Jeu jeu = new Jeu();   
			 LoginView view23= new LoginView();
           	 ControllerLoginView clt=new ControllerLoginView(view23,jeu);
        	 clt.Control();
	}
}
