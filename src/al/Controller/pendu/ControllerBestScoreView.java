package al.Controller.pendu;

import al.view.pendu.BestScoreView;
import javafx.stage.Stage;

/*
 * @Description: 
 */
public class ControllerBestScoreView {
	private BestScoreView bstscoreview;
	/**
	 * 
	 * @param bstscoreview
	 */
	public ControllerBestScoreView (BestScoreView bstscoreview){
		this.bstscoreview=bstscoreview;
		// traitement de click sur le button fermer de bestscoreview
		this.bstscoreview.getFermer().setOnAction(e->{
			Stage s = (Stage)this.bstscoreview.getFermer().getScene().getWindow();
			s.close();
		});
	}
}
