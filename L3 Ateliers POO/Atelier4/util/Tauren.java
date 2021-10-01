package util;

public class Tauren extends Personnage {
	private int taille;
	
	/**Constructeur
	 * @param nom Nom du Tauren
	 * @param age �ge du Tauren
	 * @param taille Taille du Tauren
	 */
	public Tauren(String nom, int age, int taille) {
		super(nom, age);
		this.taille = taille;
	}
	
	/**M�thode nouvelle position souhait�e du Tauren
	 * @return Entier repr�sentant la position souhait�e
	 */
	public int positionSouhaitee() {
		int pos = getPosition();
		pos += (int)(Math.floor((Math.random()) * taille)+1);
		//Nombre al�atoire entre 0 et <1 multipli� par la taille,
		//arrondi � l'entier inf�rieur, + 1 pour avoir un nombre entre 1 et la taille
		return pos;
	}
	
	@Override
	public String toString() {
		return "Tauren " + super.toString();
	}

}
