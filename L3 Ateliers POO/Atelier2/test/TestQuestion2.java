package test;

import util.*;

public class TestQuestion2 {

	public static void main(String[] args) {
		//Création de 1 employé, 2 managers, 1 secrétaire
		Employe em1 = Employe.createEmploye("Test", "Employé", 1, 2, 1990, 8, "RueTest", "88888", "TestVille", 2000, 12, 12, 2015);
		Secretaire se1 = Secretaire.createSecretaire("Test", "Secretaire", 6, 7, 1990, 8, "RueTest", "88888", "TestVille", 2000, 12, 12, 2015);
		Manager ma1 = Manager.createManager("Test", "Manager", 3, 4, 1992, 9, "RueTest", "99999", "VilleTest", 2000, 12, 12, 2015);
		Manager ma2 = Manager.createManager("Test", "Manager", 6, 7, 1990, 8, "RueTest", "88888", "TestVille", 2000, 12, 12, 2015);
	}
}
