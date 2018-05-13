package al.Main.pendu;

import al.Controller.pendu.ControllerAproposView;

import al.view.pendu.AproposView;
import javafx.application.Application;
import javafx.stage.Stage;
/*
 * @description : cette classe se charge de la creation de la fenetre apropos
 */

public class MainAproposWindow extends Application {

	@Override
	public void start(Stage arg0) throws Exception {
		AproposView aproposview = new AproposView(); 
		ControllerAproposView ctrlapropos = new ControllerAproposView(aproposview);
		
	}

}
