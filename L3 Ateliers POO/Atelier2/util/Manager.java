package util;

import java.util.GregorianCalendar;

public class Manager extends Employe {
	protected Secretaire secretaire;
	private static final double BONUSSALAIRE = 0.5;

	/**Constructeur de Manager
     * @param leNom le nom de la personne
	 * @param lePrenom le prénom de la personne
	 * @param laDate la date de naissance de la personne
	 * @param lAdresse l'adresse de la personne
     * @param salaire le salaire de l'employé
     * @param dateEmbauche la date d'embauche de l'employé
     */
    private Manager(String leNom, String lePrenom, GregorianCalendar laDate,
    				  Adresse lAdresse, double salaire, GregorianCalendar dateEmbauche) {
    	super(leNom, lePrenom, laDate, lAdresse, salaire, dateEmbauche);
    }
    
    /**Constructeur de Manager
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
    private Manager(String leNom, String lePrenom, int j, int m, int a,
    				  int numero, String rue, String code_postal, String ville,
    				  double salaire, int jEmbauche, int mEmbauche, int aEmbauche) {
        this(leNom, lePrenom, new GregorianCalendar(a,m,j), new Adresse(numero,rue,code_postal,ville),
        	 salaire, new GregorianCalendar(aEmbauche,mEmbauche,jEmbauche));
    }
    
    /** Méthode createManager
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
	 * @return Retourne les informations du nouveau manager si les informations sont correctes
	 */
    public static Manager createManager(String leNom, String lePrenom, int j, int m, int a,
			  					 int numero, String rue, String code_postal, String ville,
			  					 double salaire, int jEmbauche, int mEmbauche, int aEmbauche) {
    	Manager ma = null;
    	if(salaire > 0) {
    		ma = new Manager(leNom, lePrenom, j, m, a, numero, rue, code_postal, ville,
  				  			 salaire, jEmbauche, mEmbauche, aEmbauche);
    	}
    	return ma;
    }
    
    /**Méthode modifierSecretaire
     * Modifie le secrétaire associé à un manager
	 * @param secretaire Nouveau secretaire
	 */
    public void modifierSecretaire(Secretaire secretaire) {
    	this.secretaire = secretaire;
    }
    
    /** Méthode augmenterLeSalaire
     * Augmente le salaire d'un manager suivant un pourcentage donné, avec un bonus d'ancienneté
	 * @param pourcentage Pourcentage d'augmentation du salaire (sans bonus)
	 */
    public void augmenterLeSalaire(double pourcentage) {
    	if (pourcentage > 0) {
    		pourcentage += calculAnnuite() * BONUSSALAIRE; //+0.5% pour chaque année
    		double salaire = getSalaire();
    		salaire += salaire * (pourcentage/100);
    		setSalaire(salaire);
    	}
    }
}
