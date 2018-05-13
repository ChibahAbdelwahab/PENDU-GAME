package al.view.pendu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

import com.sun.javafx.collections.MappingChange.Map;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.stage.Stage;

public class BestScoreView {
	private Button fermer;
	private AnchorPane root = new AnchorPane();
	private Stage scorestage;
	private Scene scene;
	private Text txt;
	private TreeMap <String,Integer> bestscore ;
	private HashMap <String,Integer> hashbestscore ;
	Label l1= new Label();
	Label s1= new Label("");
	private final int nbScore=5;
	/**
	 * 
	 * @param bestscore
	 * @throws IOException
	 */
	
	public BestScoreView(TreeMap <String,Integer> bestscore) throws IOException{
		// Label
		this.bestscore=bestscore;
		l1.setLayoutX(80);
		l1.setLayoutY(100);
		
		s1.setLayoutX(330);
		s1.setLayoutY(100);
		
		l1.setFont(new Font (20));
		l1.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
		
		l1.setTextFill(Color.RED);
		s1.setFont(Font.font(java.awt.Font.MONOSPACED, 20));
		
		s1.setTextFill(Color.RED);
		ArrayList<Entry<String, Integer>> list =  new ArrayList(this.bestscore.entrySet());
		//trie de la list contenant les 
		Collections.sort(list , new Comparator<Entry<String, Integer>>() {
			@Override
	        public int compare(Entry<String, Integer> o1,Entry<String, Integer> o2 ) {
	            return o1.getValue().compareTo(o2.getValue());
	        }
	    });
		
		int i=list.size()-1;
		while(i>Math.max(0, list.size()-1-nbScore))
		{
			 StringTokenizer tok = new StringTokenizer(list.get(i).toString(),"=");
			 while(tok.hasMoreTokens())
			 {
				 l1.setText(l1.getText()+tok.nextToken()+"\n");
				 s1.setText(s1.getText()+tok.nextToken()+"\n"); 
			 }
			i--;
		}
		
		scene = new Scene(root,436,274);
		this.scorestage=new Stage();
		this.scorestage.setResizable(false);
		//Buttons
		fermer = new Button("Fermer");
		fermer.setPrefSize(80, 20);
		fermer.setLayoutX(290);
		fermer.setLayoutY(230);
		//texte
		txt = new Text("Les Heros du Pendu ");
		txt.setLayoutX(110);
		txt.setLayoutY(45);
		txt.setFont(new Font(25));
		txt.setWrappingWidth(400);
		txt.setFill(Color.WHITE);
		txt.setTextAlignment(TextAlignment.JUSTIFY);
		//Background
		ImageView img = new ImageView(new Image("al/Image/pendu/save.png"));
		img.fitHeightProperty().bind(scene.heightProperty());
		img.fitWidthProperty().bind(scene.widthProperty());
		
		root.getChildren().addAll(img,txt,fermer,l1,s1);
		this.scorestage.setScene(scene);
		this.scorestage.show();
		
		
	}

	public Button getFermer() {
		return fermer;
	}
	
	


	
	
	

}
