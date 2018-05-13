package al.Controller.pendu;

import java.io.File;

import java.io.IOException;

import al.model.pendu.AuthentificationException;
import al.model.pendu.Compte;
import al.model.pendu.Jeu;
import al.Main.pendu.Main;
import al.Main.pendu.MainAproposWindow;
import al.Main.pendu.MainBestScoreWindow;
import al.Main.pendu.MainRegleWindow;
import al.Main.pendu.Song;
import al.model.pendu.Session;
import al.view.pendu.LoginView;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;


/**
 * 
 * @Description : classe Controller login view se charge de tous les evenement de la fenetre d'entrée
 *
 */

public class ControllerLoginView {
	 
	 private boolean switchbtn=false;
	 private LoginView view;
	 private MediaPlayer mediaPlayer;
	 boolean play = false;
	 private Song song;
	 private Compte cmptransit =null;
	 private Jeu game;
	 /**
	  * 
	  * @param logview
	  * @param jeu
	  * @throws Exception
	  */
     public ControllerLoginView (LoginView logview,Jeu jeu) throws Exception{	
				 song = new Song("src/al/Media/pendu/Maid.mp3");
		         game = jeu;
		         this.view=logview;
		         }
	
     
     //  traitement de click sur les diferents button de fenetre login login 
      
	public void Control()
	{
		this.view.getMeilleurScore().setOnAction(e->{
			Stage bstscorestage = new Stage();
			MainBestScoreWindow bstscore = new MainBestScoreWindow(game.getBestScorejeu());
			try {
				bstscore.start(bstscorestage);
			} catch (Exception e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		});
		this.view.getStartplay().setOnAction(new EventHandler<ActionEvent>() 
		{public void handle(ActionEvent e){try {
			traitClic();
		} catch (IOException e1) {
			e1.printStackTrace();
		}}});
		
		this.view.getRegle().setOnAction(e->{
			Stage reglestage= new Stage();
			MainRegleWindow regle = new MainRegleWindow();
			try {
				regle.start(reglestage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		});
		
		this.view.getApropos().setOnAction(e->{
			Stage aproposstage = new Stage();
			MainAproposWindow apropos = new MainAproposWindow();
			try {
				apropos.start(aproposstage);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		});
		this.view.getSon().setOnAction(e->{
			ImageView img1 = new ImageView(new Image("al/Image/pendu/soundoff.PNG"));
			ImageView img2 = new ImageView(new Image("al/Image/pendu/soundon.PNG"));
			if (!play){
				this.song.mediaPlayer.pause();
				this.view.getSon().setGraphic(img1);
			    play=true;
			}	
			else{
				this.song.mediaPlayer.play();
				this.view.getSon().setGraphic(img2);
				play=false;
			}
		});
	}
	
	/* traitement d'evenement de click du bouton de lancement de jeu 
	 * 
	 */
	public void traitClic() throws IOException{
		Session s = null;
		Compte cmp =null;

	if (!switchbtn){
			try{
				int scorePrec=0 ;
				try{
					scorePrec=game.getBestScorejeu().get(this.view.getTxtinfield()); 
				}catch(NullPointerException pot ){}
				cmptransit =new Compte(this.view.getTxtinfield(),scorePrec);
				game.ajouterCompte(cmptransit);
				this.view.settxtinStartplay("Lancer le jeu");
				switchbtn=true;
				ImageView img = new ImageView(new Image("al/Image/pendu/valide.jpg"));
				img.fitWidthProperty().bind(this.view.getmessagelbl().widthProperty());
				img.fitHeightProperty().bind(this.view.getmessagelbl().heightProperty());
				img.resize(5, 5);
				img.fitHeightProperty();
				this.view.Settextmessageok("Pseudo Validé");
			}
				catch(AuthentificationException e){
				this.view.Settextmessage("Pseudo invalide");
			
		}
	}
	else {
				s = new Session(cmptransit);
				Main m =new Main(s,this.view,game);
				m.start(this.view.st);
				switchbtn=false;
			}
     }
}
			

			
	
	
	
		
	




