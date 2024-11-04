package CAF;

public class Allocataire extends Personne{
	
	private double allocMensuelle;
	private Caisse caisse;
	
	public Allocataire() {
		this(0);
	}
	
	public Allocataire( double _alMensuel) {
		this.allocMensuelle = _alMensuel;
	}
}
