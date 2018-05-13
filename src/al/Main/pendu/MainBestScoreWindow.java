package al.Main.pendu;

import java.util.TreeMap;

import al.Controller.pendu.ControllerAproposView;
import al.Controller.pendu.ControllerBestScoreView;
import al.view.pendu.AproposView;
import al.view.pendu.BestScoreView;
import javafx.application.Application;
import javafx.stage.Stage;

/*
 * @description:  cette classe lance la fentre qui affiche les 5 meilleures scores
 */
public class MainBestScoreWindow extends Application {
	private TreeMap<String,Integer> bestscore ;
	/**
	 * 
	 * @param bestscore
	 */
	public MainBestScoreWindow(TreeMap<String,Integer> bestscore ){
		this.bestscore=bestscore;
	}
	@Override
	public void start(Stage arg0) throws Exception {
		BestScoreView bstscore = new BestScoreView(this.bestscore); 
		ControllerBestScoreView ctrlapropos = new ControllerBestScoreView(bstscore);
		
	}
}
