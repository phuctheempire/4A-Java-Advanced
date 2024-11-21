package cmSerializable;

import java.io.Serializable;

public class Employe implements Serializable {
	
	public static final long serialVersionUID = 1L;
	
	private int id;
	protected static int nbEmp=0;
	private String nom;
	private transient String motDePasse="";
	

	public Employe(String _n){
		this.id = Employe.nbEmp++;
		this.nom = _n;
	}
	
	public void setMotDePasse(String m) {
		this.motDePasse = m;
	}
	
	public boolean checkMotDePasse(String t) {
		return t.equals(this.motDePasse);
	}
	
	public static int getNbEmployes(){
		return Employe.nbEmp;
	}
	
	public String getName(){
		return this.nom;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String toString(){
		return "id : "+this.id+" nom : "+this.nom;
	}
}
