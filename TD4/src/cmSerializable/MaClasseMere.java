package cmSerializable;

public class MaClasseMere {

	  protected String nom = null;

	  public String getNom() {
	    return this.nom;
	  }

	  public void setNom(final String nom) {
	    this.nom = nom;
	  }

	  public MaClasseMere() {
	    System.out.println("Invocation contructeur MaClasseMere");
	  }

	  public MaClasseMere(String nom) {
	    super();
	    this.nom = nom;
	  }
	}