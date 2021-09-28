package test;

import java.util.*;
import util.*;
import forme2d.*;
import forme3d.*;

public class TestFormes {
	
	public static void main(String[] args) {
		//Liste des formes g�om�triques
		ArrayList<FormeGeometrique> formes = new ArrayList<FormeGeometrique>();
		
		//Instanciation des formes g�om�triques
		FormeGeometrique f1 = new Ellipse(1,4);
		FormeGeometrique f2 = new Cercle(5);
		FormeGeometrique f3 = new Rectangle(3,2);
		FormeGeometrique f4 = new Sphere(8);
		FormeGeometrique f5 = new Cylindre(5,10);
		
		//Ajout � la liste
		formes.add(f1);
		formes.add(f2);
		formes.add(f3);
		formes.add(f4);
		formes.add(f5);
		
		//Caract�ristiques, calculs surface, p�rim�tre/volume
		for (FormeGeometrique e:formes) {
			System.out.println("\n" + e + "\nSurface = " + e.calculSurface());
			if(e instanceof Forme2D) {
				System.out.println("P�rim�tre = " + ((Forme2D)e).calculPerimetre());
			}
			else {
				System.out.println("Volume = " + ((Forme3D)e).calculVolume());
			}
		}
		
		//compareSurface, equals
		System.out.println("\nTests compareSurface et equals");
		System.out.println(f1.id + " est plus petit que " + f2.id + " : " + f1.compareSurface(f2));
		System.out.println(f4.id + " est plus grand que " + f5.id + " : " + f4.compareSurface(f5));
		System.out.println(f1.id + " est diff�rent de " + f3.id + " : " + f1.equals(f3));
		FormeGeometrique f6 = new Rectangle(3,2);
		System.out.println(f3.id + " a les m�mes caract�ristiques que " + f6.id + " : " + f3.equals(f6));
		
		//Destruction de la liste
		formes = null;
	}
}
