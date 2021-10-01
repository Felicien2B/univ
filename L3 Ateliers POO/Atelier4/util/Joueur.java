package util;

import java.util.*;

public class Joueur {
	private String nom;
	private String code;
	private static int nbJoueurs = 0;
	private int nbPoints;
	private ArrayList<Personnage> listePersos;
	
	/**Constructeur
	 * @param nom Nom du joueur
	 */
	public Joueur(String nom) {
		this.nom = nom;
		nbJoueurs++;
		this.code = "J" + nbJoueurs;
		nbPoints = 0;
		listePersos = new ArrayList<Personnage>();
	}
	
	/**Accesseur
	 * @return Nom du joueur
	 */
	public String getNom() {
		return nom;
	}
	
	/**Accesseur
	 * @return Liste des personnages du joueur
	 */
	public ArrayList<Personnage> getListePersos() {
		return listePersos;
	}
	
	/**Accesseur
	 * @return Nombre de points du joueur
	 */
	public int getPoints() {
		return nbPoints;
	}
	
	/**Méthode d'ajout de personnage
	 * @param p Personnage à ajouter
	 */
	public void ajouterPersonnage(Personnage p) {
		listePersos.add(p);
		p.setProprietaire(this);
	}
	
	/**Méthode modification des points d'un personnage
	 * @param nb Nombre de points à ajouter ou retirer
	 */
	public void modifierPoints(int nb) {
		if (nbPoints > -nb)
			nbPoints += nb;
		else nbPoints = 0;
	}
	
	/**Vérifie si le joueur possède au moins un personnage
	 */
	public boolean peutJouer() {
		return listePersos.size() >= 1;
	}
	
	@Override
	public String toString() {
		String msg = code + " " + nom + " (" + nbPoints + ") ";
		if (peutJouer())
			msg += "avec " + listePersos.size() + " personnages";
		else msg += "aucun personnage";
		return msg;
	}
}
