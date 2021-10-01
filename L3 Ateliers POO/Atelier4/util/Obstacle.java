package util;

public class Obstacle {
	private int penalite;
	
	/**Constructeur
	 * @param penalite Nombre de points de p�nalit�
	 */
	public Obstacle(int penalite) {
		this.penalite = penalite;
	}
	
	/**Accesseur
	 * @return retourne la p�nalit�
	 */
	public int getPenalite() {
		return penalite;
	}
}
