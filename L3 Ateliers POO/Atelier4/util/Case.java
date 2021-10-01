package util;

public class Case {
	private int gain;
	private Personnage perso;
	private Obstacle obs;
	
	/**Constructeur
	 * @param obs Obstacle sur une case
	 * @param gain Nombre de points à ajouter à un joueur
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
	 * @return Pénalité s'il y en a une 
	 */
	public int getPenalite() {
		int penalite = 0;
		if (!sansObstacle())
			penalite = obs.getPenalite(); //Pénalité si un obstacle est sur la case
		if (!sansPerso())
			penalite = gain; //Retire le gain au joueur si la case est déjà occupée
		return penalite;
	}
	
	/**Méthode positionnant le personnage sur la case
	 * @param perso Personnage à placer
	 */
	public void placerPersonnage(Personnage perso) {
		if (estLibre())
			this.perso = perso;
	}
	
	/**Méthode positionnant l'obstacle sur la case
	 * @param obs Obstacle à placer
	 */
	public void placerObstacle(Obstacle obs) {
		if (estLibre())
			this.obs = obs;
	}
	
	/**Méthode enlever le personnage de la case
	 */
	public void enleverPersonnage() {
		perso = null;
	}
	
	/**Méthode vérifiant si la case est libre
	 * @return true si case libre, false si case occupée
	 */
	public boolean estLibre() {
		return (sansObstacle() && sansPerso());
	}
	
	/**Méthode vérifiant l'absence d'un obstacle sur la case
	 * @return true si pas d'obstacle, false si obstacle
	 */
	public boolean sansObstacle() {
		return (obs == null);
	}
	
	/**Méthode vérifiant l'absence d'un obstacle sur la case
	 * @return true si pas de perso, false si perso
	 */
	public boolean sansPerso() {
		return (perso == null);
	}
	
	@Override
	public String toString() {
		String msg = "";
		if (!sansObstacle())
			msg = "Obstacle (pénalité = " + getPenalite() + ")";
		else if (!sansPerso())
			msg = perso.toString() + " (pénalité = " + getPenalite() + ")";
		else
			msg = "Libre (gain = " + gain + ")";
		return msg;
	}

}
