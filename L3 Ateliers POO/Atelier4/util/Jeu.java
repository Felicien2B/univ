package util;

import java.util.*;

public class Jeu {
	private static final int NBJOUEURMAX = 6;
	private static final int NBCASES = 50;
	private String titre;
	private ArrayList<Joueur> listeJoueurs;
	private Case[] cases;
	private int nbEtapes;
	private int nbObstacles;
	private static int scoreMax;
	private static Random r = new Random();
	
	/**Constructeur
	 * @param titre Titre du jeu
	 * @param nbEtapes Nombre de d�placements � r�aliser par chacun des personnages
	 * @param nbObstacles Nombre maximum d'obstacles pr�sents
	 */
	public Jeu (String titre, int nbEtapes, int nbObstacles) {
		this.titre = titre;
		this.nbEtapes = nbEtapes;
		this.nbObstacles = nbObstacles;
		listeJoueurs = new ArrayList<Joueur>();
		cases = new Case[NBCASES];
	}
	
	/**Ajoute un joueur � la liste des joueurs
	 * @param j Joueur � ajouter
	 */
	public void ajouterJoueur(Joueur j) {
		if (listeJoueurs.size() < NBJOUEURMAX)
			listeJoueurs.add(j);
		else
			System.err.println("Le nombre max de joueurs a �t� atteint");
	}
	
	/**Cr�e et renvoie la liste des personnages
	 * @return Liste de tous les personnages de tous les joueurs
	 */
	public ArrayList<Personnage> tousLesPersos() {
		ArrayList<Personnage> listePersos = new ArrayList<Personnage>();
		for (Joueur j:listeJoueurs) {
			if (j.peutJouer())
				listePersos.addAll(j.getListePersos());
			else
				System.err.println(j.getNom() + " ne peut pas jouer");
		}
		return listePersos;
	}
	
	/**Initialise le tableau de cases
	 */
	public void initialiserCases() {
		int nbObs = 0; //Nombre d'obstacles cr��s
		for (int i=0; i<NBCASES; i++) {
			int gain = r.nextInt(NBCASES) + 1;
			cases[i] = new Case(gain);
			if (gain%5 == 0 && nbObs < nbObstacles
					&& i != NBCASES-1) { //Pas d'obstacle sur la derni�re case
				Obstacle obs = new Obstacle(gain*2);
				cases[i].placerObstacle(obs);
				nbObs++;
			}
		}
	}
	
	/**Lance le jeu
	 */
	public void lancerJeu() {
		initialiserCases();
		ArrayList<Personnage> listePersos = tousLesPersos();
		for (Personnage perso:listePersos) {
			int i = 0;
			while (!cases[i].estLibre() && i < NBCASES)
				i++;
			cases[i].placerPersonnage(perso);
			perso.setPosition(i);
		}
		afficherCases();
		System.out.println("Le jeu commence");
		int posSouhaitee = 0;
		for (int nEtape=0; nEtape<nbEtapes; nEtape++) {
			for (Personnage perso:listePersos) {
				posSouhaitee = perso.positionSouhaitee();
				if (posSouhaitee >= NBCASES) //Si la position souhait�e d�passe le tableau, on la remplace par la derni�re case
					posSouhaitee = NBCASES-1;
				Case caseSouhaitee = cases[posSouhaitee];
				if (caseSouhaitee.estLibre()) {
					cases[perso.getPosition()].enleverPersonnage(); //On enl�ve le personnage de sa position
					caseSouhaitee.placerPersonnage(perso); //On le place sur sa nouvelle position
					perso.deplacer(posSouhaitee, caseSouhaitee.getGain()); //On garde la nouvelle position en m�moire et on ajoute le gain au joueur
				}
				else {
					int penalite = caseSouhaitee.getPenalite();
					perso.penaliser(penalite);
				}
			}
			afficherCases();
		}
		afficherResultats();
	}
	
	/**Renvoie le joueur gagnant
	 * @return Joueur qui a le plus de points
	 */
	public Joueur getGagnant() {
		int nbPointsMax = -1;
		Joueur gagnant = null;
		for (Joueur j:listeJoueurs) {
			int nbPoints = j.getPoints();
			if (nbPoints > nbPointsMax) {
				nbPointsMax = nbPoints;
				gagnant = j;
			}	
		}
		return gagnant;
	}
	
	/**Affichage des cases
	 */
	public void afficherCases() {
		for (int i=0; i<NBCASES; i++) {
			System.out.println("Case " + i + " : " + cases[i]);
		}
		System.out.println("");
	}
	
	/**Affichage des participants
	 */
	public void afficherParticipants() {
		System.out.println("LISTE DES JOUEURS");
		for (Joueur j:listeJoueurs) {
			System.out.println("-------------------------\n" + j);
		}
	}
	
	/**Affichage des r�sultats
	 */
	public void afficherResultats() {
		Joueur gagnant = getGagnant();
		int pointsGagnant = gagnant.getPoints();
		System.out.println("JEU " + titre + "\n***********************************************\n");
		afficherParticipants();
		System.out.println("***********************************************\nRESULTATS\n"
				+ "Le gagnant est " + gagnant.getNom() + " avec " + pointsGagnant + " points");
		if (pointsGagnant > scoreMax) {
			System.out.println("Record battu : Ancien score maximum " + scoreMax);
			scoreMax = pointsGagnant;
		}
		else
			System.out.println("Record : " + scoreMax);
	}

}
