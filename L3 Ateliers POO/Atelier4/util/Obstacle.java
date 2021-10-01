package util;

public class Obstacle {
	private int penalite;
	
	/**Constructeur
	 * @param penalite Nombre de points de pénalité
	 */
	public Obstacle(int penalite) {
		this.penalite = penalite;
	}
	
	/**Accesseur
	 * @return retourne la pénalité
	 */
	public int getPenalite() {
		return penalite;
	}
}
