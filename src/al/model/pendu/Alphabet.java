package al.model.pendu;

import javafx.scene.image.ImageView;
/**
 * Classe pour recuperer l'image correspondante au caractere demander 
 * @author CHIBAH BELDJILLALI
 *
 */
public class Alphabet {
	public Alphabet() {
		
	}
	public ImageView getImage(int i){
		if(i==27)
			return new ImageView("al/Image/pendu/hang.png");
		char caract;
		 caract =(char)(i + 'a');
		return new ImageView("al/Image/pendu/"+caract+".png");
	}
	
}
