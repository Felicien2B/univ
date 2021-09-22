package exercice1;

public class TestDe {

	public static void main(String[] args) {
		//Création de 2 dés
		De d1 = new De("Number One", 6);
		System.out.println(d1);
		d1.setNbFaces(120); //Changement du nombre de faces du dé d1
		System.out.println("Nouveau nombre de faces : " + d1.getNbFaces());
		De d2 = new De();
		System.out.println(d2);
		
		System.out.println("Lancer des dés : " + d1.lancer() + ", " + d2.lancer());
		System.out.println("Lancer des dés 5 fois : " + d1.lancer(5) + ", " + d2.lancer(5));
		
		//Création d'un dé identique au dé d2
		De d3 = new De("Dé n°2", 6);
		System.out.println(d3);
		
		//Tests toString et equals
		System.out.println("\nTest toString\n" + d1 + "\n" + d2 + "\n" + d3);
		System.out.println("\nTest equals");
		System.out.println("equals avec dés différents : " + d1.equals(d2));
		System.out.println("equals avec dés identiques : " + d2.equals(d3));
		
		//Création d'un dé pipé
		De d4 = new DePipe("Pipé", 80, 75);
		System.out.println("\n" + d4);
		System.out.println("Lancer le dé d4 : " + d4.lancer());
		
		//Création d'un dé à effet mémoire
		De d5 = new DeEffetMemoire("Mémoire", 3);
		System.out.println("\n" + d5);
		int lancerPrecedent = 0;
		System.out.print("Lancer le dé d5 10 fois :");
		for(int i=0; i<10; i++) {
			int lancerSuivant = d5.lancer();
			//Vérification des répétitions : les nombres se répétant s'affichent en rouge
			if (lancerPrecedent == lancerSuivant) {
				System.err.print(" " + lancerSuivant);
			}
			else {System.out.print(" " + lancerSuivant);}
			lancerPrecedent = lancerSuivant;	
		}
	}
}
