package forme3d;

public class Sphere extends Forme3D {
	private double rayon;
	
	public Sphere(double rayon) {
		super("sphere");
		this.rayon = rayon;
	}
	
	public double calculSurface() {
		return 4*Math.PI * Math.pow(rayon,2);
	}
	
	public double calculVolume() {
		return Math.PI * Math.pow(rayon,3);
	}
	
	public String toString() {
		return super.toString() + "Sphere de rayon " + rayon;
	}
	
	public boolean equals(Object obj) {
		return (obj instanceof Sphere && obj != null)
				&& (rayon == ((Sphere)obj).rayon);
	}
}
