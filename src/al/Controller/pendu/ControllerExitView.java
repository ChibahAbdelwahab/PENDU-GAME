package al.Controller.pendu;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map.Entry;

import al.model.pendu.Jeu;
import al.model.pendu.Session;
import al.view.pendu.ExitView;
import javafx.stage.Stage;
/**
 * @description : classe controllerExitView se charge des evenements de la fenetre d'enrigtrement 
 * 
 *
 */
public class ControllerExitView {
	private ExitView exitview;
	private Session ses;
	private Jeu jeu;
	/**
	 * 
	 * @param exitview
	 * @param ses
	 * @param jeu
	 */
	public ControllerExitView(ExitView exitview, Session ses,Jeu jeu){
			this.exitview=exitview;
			this.ses=ses;
			this.jeu=jeu;
			this.exitview.getPseudolbl().setText(this.ses.getJoueur().getPseudo());
			this.exitview.getScorelbl().setText(String.valueOf(this.ses.getScore()));
		
              //traitement de click sur les differents buton de la fenetre d'enregistrement.
			this.exitview.getAnnuler().setOnAction(e->{
			Stage s = (Stage)this.exitview.getAnnuler().getScene().getWindow();
			s.close();
			this.exitview.getV().remetreenordre();
			this.exitview.getV().st.setScene(this.exitview.getV().getScene());
			});
		
			this.exitview.getEnregistrer().setOnAction(e->{
			if(jeu.getBestScorejeu().containsKey(ses.getJoueur().getPseudo())){
				int x = Math.max(jeu.getBestScorejeu().get(ses.getJoueur().getPseudo()), ses.getJoueur().getMeilleurScore());
				jeu.getBestScorejeu().remove(ses.getJoueur().getPseudo());
				jeu.getBestScorejeu().put(ses.getJoueur().getPseudo(),x);
			}
			else
				jeu.getBestScorejeu().put(ses.getJoueur().getPseudo(),ses.getJoueur().getMeilleurScore());
			try{
			    BufferedWriter sortie = new BufferedWriter(new FileWriter("src/al/save.txt", true));
			    sortie.write(ses.getJoueur().getPseudo()+" "+ses.getJoueur().getMeilleurScore()+"\n");
			    sortie.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			Stage s = (Stage)this.exitview.getAnnuler().getScene().getWindow();
			s.close();
			this.exitview.getV().remetreenordre();
			this.exitview.getV().st.setScene(this.exitview.getV().getScene());
		});
			
			this.exitview.getNonenregistrer().setOnAction(e->{
			Stage s = (Stage)this.exitview.getAnnuler().getScene().getWindow();
			s.close();
			this.exitview.getV().remetreenordre();
			this.exitview.getV().st.setScene(this.exitview.getV().getScene());
			
		});
	}

}
