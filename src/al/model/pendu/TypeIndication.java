package al.model.pendu;
/**
 * Classe Enumeration pour le Type d'indication 
 * @author CHIBAH BELDJILLALI 
 *
 */
public enum TypeIndication {
	SYNONYME,ANTONYME,DEFINITION;
	private static final int coeffDef = 3 ;
	private static final int coeffSyn = 2;
	private static final int coeffAnt = 1 ;
	
	
	/**
	 * Recuperation du coefficiant selon le type 
	 * @return	le type de l'indication 
	 */
	public int getCoeff(){
		switch(this){
		case SYNONYME:
			return coeffSyn;
		case ANTONYME:
			return coeffAnt;
		case DEFINITION:
			return coeffDef;
		}
		return 0;
	}
	}
