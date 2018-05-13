package al.Main.pendu;

import al.Controller.pendu.ControllerPartie;
import al.model.pendu.Jeu;
import al.model.pendu.Session;
import al.view.pendu.LoginView;
import al.view.pendu.ViewPartie;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 * 
 @author CHIBAH BELDJILLALI 
 */
public class Main extends Application {
  private Session ses;
  private LoginView v;
  private Jeu jeu;
  public Main (Session ses,LoginView v, Jeu jeu){
	  this.ses=ses;
	  this.v=v;
	  this.jeu=jeu;
  }
	@Override
	public void start(Stage primaryStage) {
		ViewPartie view = new ViewPartie();
		ControllerPartie controllerPartie =new ControllerPartie(view,this.ses,v,jeu);
		primaryStage.setScene(view.getScene());
		primaryStage.show();
		//System.out.println("satrt main done");
	}

	public static void main(String[] args) {
		launch(args);
	}
}
