package CAF;

public class Caisse {
	private int numeroCaisse;
	private int departement;
	private Allocataire[] allocataires;
	
	public Caisse() {
		this(0,0);
	}
	
	public Caisse(int _numCaisse, int _dep) {
		this.departement = _dep;
		this.numeroCaisse = _numCaisse;
	}
	
	public Allocataire[] getAllocataires() {
		return this.getAllocataires();
	}
}
