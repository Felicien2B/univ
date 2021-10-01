package util;

public abstract class Personnage {
	private String nom;
	private int age;
	private int position;
	private Joueur proprietaire;
	
	/**Constructeur
	 * @param nom Nom du personnage
	 * @param age Âge du personnage
	 */
	public Personnage(String nom, int age) {
		this.nom = nom;
		this.age = age;
	}
	
	/**Accesseur
	 * @return Position du personnage
	 */
	public int getPosition() {
		return position;
	}
	
	/**Accesseur
	 * @return Propriétaire du personnage
	 */
	protected Joueur getProprietaire() {
		return proprietaire;
	}
	
	/**Modificateur de la position du personnage
	 */
	protected void setPosition(int pos) {
		this.position = pos;
	}
	
	/**Modificateur du propriétaire du personnage
	 */
	protected void setProprietaire(Joueur proprietaire) {
		this.proprietaire = proprietaire;
	}
	
	/**Méthode déplacer le personnage
	 * @param destination Case où se rend le personnage
	 * @param gain Nombre de points de la case
	 */
	public void deplacer(int destination, int gain) {
		this.position = destination;
		proprietaire.modifierPoints(gain);
	}
	
	/**Méthode donner une pénalité de points
	 * @param penalite Penalité de points
	 */
	public void penaliser(int penalite) {
		proprietaire.modifierPoints(-penalite);
	}
	
	@Override
	public String toString() {
		return nom;
	}
	
	public abstract int positionSouhaitee();

}
