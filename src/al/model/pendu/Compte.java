package al.model.pendu;

/**
 * Compte verifie si le pseudo est valide et permet de garder le score du joueur 
 * @author CHIBAH BELDJILLALI 
 * 
 */
public class Compte  {
	private String pseudo;
	private int meilleurScore;


	private Session session;// Chaque Compte utilise une session à la fois
	public Compte(String pseudo, int meilleurScore) throws AuthentificationException  {
		this.pseudo = pseudo;
		this.meilleurScore = meilleurScore;
		if (!Character.isLetter(this.pseudo.charAt(0))) {
			throw new AuthentificationException("pseudo invalide, veuillez introduire un pseudo qui commence par un Char");
		}
			
		
		
	}
	@Override
	public int hashCode() {
		return pseudo.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Compte other = (Compte) obj;
		if (pseudo == null) {
			if (other.pseudo != null)
				return false;
		} else if (!pseudo.equals(other.pseudo))
			return false;
		return true;
	}
	
	
	public String getPseudo() {
		return pseudo;
	}
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}
	public int getMeilleurScore() {
		return meilleurScore;
	}
	public void setMeilleurScore(int meilleurScore) {
		this.meilleurScore =Math.max(this.meilleurScore, meilleurScore);
				
	}
	public Session getSession() {
		return session;
	}
	public void setSession(Session session) {
		this.session = session;
	}
	
	

}
