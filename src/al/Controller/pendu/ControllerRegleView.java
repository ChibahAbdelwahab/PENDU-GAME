package al.Controller.pendu;

import al.view.pendu.RegleView;

import javafx.stage.Stage;
/*
 * @Destription : Classe ControllerRegleView se charge des evenements de la fenetre de regles
 */

public class ControllerRegleView {
	RegleView regleview;
	/**
	 * 
	 * @param regleview
	 */
	public ControllerRegleView(RegleView regleview){
		this.regleview=regleview;
		this.regleview.getFermer().setOnAction(e->{
			Stage s =(Stage) this.regleview.getFermer().getScene().getWindow();
			s.close();
		});
	}
	
	

}
