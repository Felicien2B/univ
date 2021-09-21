package exercice1;

public class TestDe {

	public static void main(String[] args) {
		//Création de 2 dés
		De d1 = new De("Number One", 6);
		System.out.println("Nom : " + d1.getNom());
		System.out.println("Nombre de faces : " + d1.getNbFaces());
		d1.setNbFaces(120); //Changement du nombre de faces du dé d1
		System.out.println("Nouveau nombre de faces : " + d1.getNbFaces());
		De d2 = new De();
		System.out.println("Nom : " + d2.getNom());
		System.out.println("Nombre de faces : " + d2.getNbFaces());
		
		System.out.println("Lancer des dés : " + d1.lancer() + ", " + d2.lancer());
		System.out.println("Lancer des dés (5 fois) : " + d1.lancer(5) + ", " + d2.lancer(5));
		
		//Création d'un dé identique au dé d2
		De d3 = new De();
		System.out.println("Nom : " + d3.getNom());
		System.out.println("Nombre de faces : " + d3.getNbFaces());
		
		System.out.println("\nTest toString\n" + d1 + "\n" + d2 + "\n" + d3);
		System.out.println("\nTest equals");
		System.out.println("equals avec dés différents : " + d1.equals(d2));
		System.out.println("equals avec dés identiques : " + d2.equals(d3));
		
		//Création d'un dé pipé
		De d4 = new DePipe("", 80, 70);
		System.out.println("Nom : " + d4.getNom());
		System.out.println("Nombre de faces : " + d4.getNbFaces());
		System.out.println("Lancer le dé d4 : " + d4.lancer());
	}
}
