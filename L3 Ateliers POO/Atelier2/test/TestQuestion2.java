package test;

import util.*;

public class TestQuestion2 {

	public static void main(String[] args) {
		//Création de 1 employé, 2 managers, 1 secrétaire
		Employe em1 = Employe.createEmploye("Test", "Employé", 1, 2, 1990, 8, "RueTest", "88888", "TestVille", 2000, 12, 12, 2015);
		Manager ma1 = Manager.createManager("Test", "Manager", 3, 4, 1992, 9, "RueTest", "99999", "VilleTest", 2000, 12, 12, 2015);
		Manager ma2 = Manager.createManager("Test", "Manager", 6, 7, 1990, 8, "RueTest", "88888", "TestVille", 2000, 12, 12, 2015);
		Secretaire se1 = Secretaire.createSecretaire("Test", "Secretaire", 6, 7, 1990, 8, "RueTest", "88888", "TestVille", 2000, 12, 12, 2015);
		
		//Ajout managers au secrétaire
		se1.ajoutManager(ma1);
		se1.ajoutManager(ma2);
		System.out.println("Nombre de managers : " + se1.getNbManagers());
		
		//Augmentation de salaire de 10%
		em1.augmenterLeSalaire(10);
		ma1.augmenterLeSalaire(10);
		ma2.augmenterLeSalaire(10);
		se1.augmenterLeSalaire(10);
		System.out.println("Salaire de em1 : " + em1.getSalaire() + " €");
		System.out.println("Salaire de ma1 : " + ma1.getSalaire() + " €");
		System.out.println("Salaire de ma2 : " + ma2.getSalaire() + " €");
		System.out.println("Salaire de se1 : " + se1.getSalaire() + " €");
	}
}
