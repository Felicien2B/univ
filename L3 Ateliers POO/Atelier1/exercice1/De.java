package exercice1;

import java.util.*;

public class De {
	private static final int FACESMIN = 3;
	private static final int FACESMAX = 120;
	private static Random r = new Random();
	private static int nbDes = 0;
	protected String nom;
	protected int nbFaces;
	
	/**
	 * Constructeur du dé
	 * @param nom le nom du dé
	 * @param nbFaces le nombre de faces du dé
	 */
	public De(String nom, int nbFaces) {
		if (nom == "" || nom == null) {
			this.nom = "Dé n°" + (nbDes+1); //Nom par défaut si le nom est vide
		}
		else {this.nom = nom;}
		
		this.nbFaces = 6; //Nombre de faces par défaut
		this.setNbFaces(nbFaces);
		nbDes++;
	}
	
	//Constructeur du dé sans paramètre
	public De() {
		this(null, 6); //Dé à 6 faces par défaut
	}
	
	/**
	 * Accesseur
	 * @return Retourne le nom du dé
	 */
	public String getNom() {
		return nom;
	}
	
	/**
	 * Accesseur
	 * @return Retourne le nombre de faces du dé
	 */
	public int getNbFaces() {
		return nbFaces;
	}
	
	/**
	 * Modificateur
	 * @param nbFaces le nombre de faces du dé	 
	 */
	public void setNbFaces(int nbFaces) {
		if (nbFaces < FACESMIN || nbFaces > FACESMAX) {
			System.err.println("Nombre de faces du dé incorrect");
		}
		else {this.nbFaces = nbFaces;}
	}
	
	//Lancer le dé
	public int lancer() {
		return r.nextInt(nbFaces)+1 ;
	}
	
	//Lancer le dé plusieurs fois
	public int lancer(int nbLancer) {
		int meilleurLancer = 0;
		for(int i=1; i<nbLancer; i++) {
			int numero = lancer();
			if(numero > meilleurLancer) { //On garde le meilleur lancer
				meilleurLancer = numero;
			}
		}
		return meilleurLancer;
	}
	
	//Caractéristiques du dé
	public String toString() {
		return "Nom : " + nom + "\nNombre de faces : " + nbFaces;
	}
	
	//Comparaison de deux dés
	public boolean equals(Object obj) {
		boolean res = false;
		if (obj instanceof De) {
			De objDe = (De)obj;
			res = objDe.nbFaces == this.nbFaces && objDe.nom.equals(this.nom);
		}
		return res;
	}
	
	
}
