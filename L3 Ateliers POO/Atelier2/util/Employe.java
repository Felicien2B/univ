package util;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Employe extends Personne {
	private double salaire;
	private final GregorianCalendar dateEmbauche;
	
	/**
     * Constructeur d'Employe
     * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
     * @param salaire le salaire de l'employé
     * @param dateEmbauche la date d'embauche de l'employé
     */
    protected Employe(String leNom, String lePrenom, GregorianCalendar laDate,
    				  Adresse lAdresse, double salaire, GregorianCalendar dateEmbauche) {
    	super(leNom, lePrenom, laDate, lAdresse);
        this.salaire = salaire;
        this.dateEmbauche = dateEmbauche;
    }
    
    /**Constructeur d'Employe
     * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'année de naissance
	 * @param numero le n° de la rue
	 * @param rue la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville la ville ou la personne habite
     * @param salaire le salaire de l'employé
     * @param jEmbauche le jour de la date d'embauche
     * @param mEmbauche le mois de la date d'embauche
     * @param aEmbauche l'année de la date d'embauche
     */
    protected Employe(String leNom, String lePrenom, int j, int m, int a,
    				  int numero, String rue, String code_postal, String ville,
    				  double salaire, int jEmbauche, int mEmbauche, int aEmbauche) {
        this(leNom, lePrenom, new GregorianCalendar(a,m,j), new Adresse(numero,rue,code_postal,ville),
        	 salaire, new GregorianCalendar(aEmbauche,mEmbauche,jEmbauche));
    }
    
    /** Méthode createEmploye
     * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param j le jour de naissance
	 * @param m le mois de naissance
	 * @param a l'année de naissance
	 * @param numero le n° de la rue
	 * @param rue la rue
	 * @param code_postal le code postal de l'adresse
	 * @param ville la ville ou la personne habite
     * @param salaire le salaire de l'employé
     * @param jEmbauche le jour de la date d'embauche
     * @param mEmbauche le mois de la date d'embauche
     * @param aEmbauche l'année de la date d'embauche
	 * @return Retourne les informations du nouvel employé si les informations sont correctes
	 */
    public static Employe createEmploye(String leNom, String lePrenom, int j, int m, int a,
			  					 int numero, String rue, String code_postal, String ville,
			  					 double salaire, int jEmbauche, int mEmbauche, int aEmbauche) {
    	Employe em = null;
    	if(salaire > 0) {
    		em = new Employe(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville,
  				  			 salaire, jEmbauche, mEmbauche, aEmbauche);
    	}
    	return em;
    }
    
    /**
	 * Accesseur
	 * @return retourne le salaire de l'employé
	 */
	public double getSalaire(){
		return salaire;
	}
	
	/**
	 * Modificateur
	 * @param nouveauSalaire le nouveau salaire de l'employé
	 */
	protected void setSalaire(double nouveauSalaire) {
		salaire = nouveauSalaire;
	}
    
    /** Méthode augmenterLeSalaire
     * Augmente le salaire d'un employé suivant un pourcentage donné
	 * @param pourcentage Pourcentage d'augmentation du salaire
	 */
    public void augmenterLeSalaire(double pourcentage) {
    	if (pourcentage > 0) {
    		this.salaire += this.salaire * (pourcentage/100);
    	}
    }
    
    /** Méthode calculAnnuite
     * @return Nombre d'années que l'employé a passé dans l'entreprise
	 */
    public int calculAnnuite() {
    	Calendar rightNow = Calendar.getInstance();
    	return rightNow.get(Calendar.YEAR) - dateEmbauche.get(Calendar.YEAR)+1;
    }
}
