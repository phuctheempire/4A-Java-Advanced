
package TDSerialisable;

import java.io.Serial;
import java.io.Serializable;
import java.util.*;
public class Personne implements Serializable {
    private String numeroSecu;
//    private Date dateDeNaissance;
    private String Nom;
    private String Prenom;
    private Genre Gender;

    public Personne( String _numSecu, String _nom, String _prenom, Genre _gender){
        this.numeroSecu = _numSecu;
//        this.dateDeNaissance = _dateNaissance;
        this.Gender = _gender;
        this.Nom = _nom;
        this.Prenom = _prenom;
    }

    public String toString(){
        return this.numeroSecu+"|"+this.Nom+"|"+this.Prenom+"|"+this.Gender.toString();
    }



}
