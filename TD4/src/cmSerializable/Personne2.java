package cmSerializable;


import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Date;

public class Personne2 implements java.io.Externalizable {
	private String           nom        = "";
	private String           prenom     = "";
	private int              taille     = 0;
	private Date             dateNaiss  = null;
	private transient String codeSecret = "";

	public Personne2() {
	}

	public Personne2(final String nom, final String prenom, final int taille, final String
			codeSecret, final Date dateNaiss) {
		this.nom = nom;
		this.taille = taille;
		this.prenom = prenom;
		this.codeSecret = codeSecret;
		this.dateNaiss = dateNaiss;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(final String nom) {
		this.nom = nom;
	}

	public int getTaille() {
		return this.taille;
	}

	public void setTaille(final int taille) {
		this.taille = taille;
	}

	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(final String prenom) {
		this.prenom = prenom;
	}

	public String getCodeSecret() {
		return this.codeSecret;
	}

	public Date getDateNaiss() {
		return this.dateNaiss;
	}

	public void setDateNaiss(final Date dateNaiss) {
		this.dateNaiss = dateNaiss;
	}

	  @Override
	  public void writeExternal(final ObjectOutput out) throws IOException {
	    out.writeUTF(this.nom);
	    out.writeUTF(this.prenom);
	    out.writeObject(this.dateNaiss);
	    out.writeInt(this.taille);
	    out.writeUTF(this.codeSecret);
	  }

	  @Override
	  public void readExternal(final ObjectInput in) throws IOException, ClassNotFoundException {
	    this.nom = in.readUTF();
	    this.prenom = in.readUTF();
	    this.dateNaiss = (Date) in.readObject();
	    this.taille = in.readInt();
	    this.codeSecret = in.readUTF();
	  }
	
	public String toString() {
		return 	" nom : "+this.nom+"\n prenom : "+this.prenom+"\n taille : "+this.taille+"\n dateNaiss : "+this.dateNaiss+"\n codeSecret : "+this.codeSecret;
	}


}