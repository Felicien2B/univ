package util;

public class Humain extends Personnage {
	private int nbDeplacements;
	private int niveau;
	
	/**Constructeur
	 * @param nom Nom de l'humain
	 * @param age Âge de l'humain
	 */
	public Humain(String nom, int age) {
		super(nom, age);
		nbDeplacements = 0;
		niveau = 1;
	}
	
	@Override
	public void deplacer(int destination, int gain) {
		setPosition(destination);
		getProprietaire().modifierPoints(gain);
		nbDeplacements++;
		if (nbDeplacements == 4 || nbDeplacements == 6)
			niveau++;
	}
	
	/**Méthode nouvelle position souhaitée de l'humain
	 * @return Entier représentant la position souhaitée
	 */
	public int positionSouhaitee() {
		int pos = getPosition();
		pos += niveau * nbDeplacements+1;
		return pos;
	}
	
	@Override
	public String toString() {
		return "Humain " + super.toString();
	}

}
