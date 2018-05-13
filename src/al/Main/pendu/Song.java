package al.Main.pendu;

import java.io.File;

import al.view.pendu.LoginView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
/*
 * @description : lance un fichier audio au debut de jeu
 */
public class Song {
	
	public MediaPlayer mediaPlayer;
	 String path= new String();
	 /**
	  * 
	  * @param path
	  */
		 public Song (String path){
			     this.path=path;
			     Media media = new Media(new File(this.path).toURI().toString());
			     mediaPlayer = new MediaPlayer(media);
		    	 mediaPlayer.setAutoPlay(true);
		 }
}
