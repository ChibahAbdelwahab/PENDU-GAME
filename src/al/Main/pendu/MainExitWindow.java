package al.Main.pendu;

import al.Controller.pendu.ControllerExitView;
import al.model.pendu.Jeu;
import al.model.pendu.Session;
import al.view.pendu.ExitView;
import al.view.pendu.LoginView;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainExitWindow extends Application{
	private LoginView view ;
	private Session ses;
	private Jeu jeu;
	/**
	 * 
	 * @param view
	 * @param ses
	 * @param jeu
	 */
	public MainExitWindow(LoginView view,Session ses,Jeu jeu){
		this.view=view;
		this.ses=ses;
		this.jeu=jeu;
	}
	public void start1(LoginView arg0) throws Exception {
		ExitView exitview = new ExitView(arg0); 
		ControllerExitView ctrlexit = new ControllerExitView(exitview,ses,jeu);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		this.start1(this.view);
	}

}
