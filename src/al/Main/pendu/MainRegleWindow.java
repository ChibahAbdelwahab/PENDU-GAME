package al.Main.pendu;

import al.Controller.pendu.ControllerRegleView;
import al.view.pendu.RegleView;
import javafx.application.Application;
import javafx.stage.Stage;
/**
 * descrioption: cette classe se charge de cratioon de la fenetre d'entrée
 * @author DELL
 *
 */
public class MainRegleWindow extends Application{

	@Override
	public void start(Stage reglestage) throws Exception {
		
		RegleView reglewindow= new RegleView();		
		ControllerRegleView ctrlregle = new ControllerRegleView(reglewindow);
		
	}

}
