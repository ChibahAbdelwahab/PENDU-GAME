package al.Controller.pendu;

import al.view.pendu.AproposView;
import javafx.stage.Stage;

/*
 * @Description: Classe ControllerAproposView de charge des evenements de la fenetre d'apropos  
 */
public class ControllerAproposView {
	private AproposView aproposview;
	/**
	 * 
	 * @param aproposview
	 */
	public ControllerAproposView(AproposView aproposview){
		this.aproposview=aproposview;
		// Traitement de click sur le button fermer de la view apropos
		this.aproposview.getFermer().setOnAction(e->{
			Stage s = (Stage)this.aproposview.getFermer().getScene().getWindow();
			s.close();
		});
	}
}
