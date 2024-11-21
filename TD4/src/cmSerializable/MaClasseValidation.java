package cmSerializable;

import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectInputValidation;
import java.io.Serializable;

public class MaClasseValidation implements Serializable, ObjectInputValidation {
  private String nom;

  public String getNom() {
    return this.nom;
  }

  public void setNom(final String nom) {
    this.nom = nom;
  }

  @Override
  public void validateObject() throws InvalidObjectException {
    if (this.nom == null) {
      throw new InvalidObjectException("Le champ nom ne doit pas être vide");
    }
  }

  private void readObject(final ObjectInputStream in) throws IOException,     ClassNotFoundException {
    in.registerValidation(this, 0);
    in.defaultReadObject();
  }
}