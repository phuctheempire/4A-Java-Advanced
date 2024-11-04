package CAF;
import SpecialTypes.Genre;
import java.util.Date;
import java.util.ArrayList;

public class Personne {
	private String numeroSecu;
	private Date dateDeNaissance;
	private String nom;
	private String prenom;
	private Genre genre;
	private ArrayList<Personne> parents = new ArrayList<Personne>();
	private ArrayList<Personne> enfants = new ArrayList<Personne>();
	
	

	public Personne() {
		this("", null,"","",null, null, null, new Personne[0]);
	};
	public Personne(String _numeroSecu, Date _dateDeNaissance, String _nom, String _prenom, Genre _genre) {
		this(_numeroSecu, _dateDeNaissance,_nom,_prenom,_genre, null, null, new Personne[0]);
	}
	public Personne (String _numeroSecu, Date _dateDeNaissance, String _nom, String _prenom, Genre _genre,
	Personne _parent1, Personne _parent2){
		this(_numeroSecu, _dateDeNaissance,_nom,_prenom,_genre, _parent1, _parent2, new Personne[0]);
	}
	
	public Personne(String _numeroSecu, Date _dateDeNaissance, String _nom, String _prenom, Genre _genre,
	Personne[] _enfants) {
		this(_numeroSecu, _dateDeNaissance,_nom,_prenom,_genre, null, null, _enfants);
	}
	
	public Personne(String _numeroSecu, Date _dateDeNaissance, String _nom, String _prenom, Genre _genre,
	Personne _parent1, Personne _parent2, Personne[] _enfants) {
		this.numeroSecu = _numeroSecu;
		this.dateDeNaissance = _dateDeNaissance;
		this.nom = _nom;
		this.prenom = _prenom;
		this.genre = _genre;
		if ( _parent1 != null ) {
			this.parents.add(_parent1);
		}
		if ( _parent2 != null ) {
			this.parents.add(_parent2);
		}
		for (int i = 0; i< _enfants.length ; i++) {
			this.enfants.add(_enfants[i]);
		};
	}
	
	public void printInfo() {
		System.out.print("Personne: "+this+"\n");
		System.out.print("Nom: "+this.nom+"\n");
		System.out.print("Prenom: "+this.prenom+"\n");
		
	}
	
	public void getParents() {
		System.out.print("Les parents sont: \n");
		for (int i = 0; i < this.parents.size(); i++ ) {
			this.parents.get(i).printInfo();
		}
	}
}
