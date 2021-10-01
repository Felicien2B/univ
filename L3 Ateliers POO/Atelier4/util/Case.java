package util;

public class Case {
	private int gain;
	private Personnage perso;
	private Obstacle obs;
	
	/**Constructeur
	 * @param obs Obstacle sur une case
	 * @param gain Nombre de points � ajouter � un joueur
	 */
	public Case(Obstacle obs, int gain) {
		this.obs = obs;
		this.gain = gain;
	}
	
	/**Constructeur sans obstacle
	 * @param gain 
	 */
	public Case(int gain) {
		this(null, gain);
	}
	
	/**Accesseur
	 * @return Gain 
	 */
	public int getGain() {
		return gain;
	}
	
	/**Accesseur
	 * @return P�nalit� s'il y en a une 
	 */
	public int getPenalite() {
		int penalite = 0;
		if (!sansObstacle())
			penalite = obs.getPenalite(); //P�nalit� si un obstacle est sur la case
		if (!sansPerso())
			penalite = gain; //Retire le gain au joueur si la case est d�j� occup�e
		return penalite;
	}
	
	/**M�thode positionnant le personnage sur la case
	 * @param perso Personnage � placer
	 */
	public void placerPersonnage(Personnage perso) {
		if (estLibre())
			this.perso = perso;
	}
	
	/**M�thode positionnant l'obstacle sur la case
	 * @param obs Obstacle � placer
	 */
	public void placerObstacle(Obstacle obs) {
		if (estLibre())
			this.obs = obs;
	}
	
	/**M�thode enlever le personnage de la case
	 */
	public void enleverPersonnage() {
		perso = null;
	}
	
	/**M�thode v�rifiant si la case est libre
	 * @return true si case libre, false si case occup�e
	 */
	public boolean estLibre() {
		return (sansObstacle() && sansPerso());
	}
	
	/**M�thode v�rifiant l'absence d'un obstacle sur la case
	 * @return true si pas d'obstacle, false si obstacle
	 */
	public boolean sansObstacle() {
		return (obs == null);
	}
	
	/**M�thode v�rifiant l'absence d'un obstacle sur la case
	 * @return true si pas de perso, false si perso
	 */
	public boolean sansPerso() {
		return (perso == null);
	}
	
	@Override
	public String toString() {
		String msg = "";
		if (!sansObstacle())
			msg = "Obstacle (p�nalit� = " + getPenalite() + ")";
		else if (!sansPerso())
			msg = perso.toString() + " (p�nalit� = " + getPenalite() + ")";
		else
			msg = "Libre (gain = " + gain + ")";
		return msg;
	}

}
