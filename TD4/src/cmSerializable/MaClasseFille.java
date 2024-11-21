package cmSerializable;

import java.io.Serializable;

public class MaClasseFille extends MaClasseMere implements Serializable {

  private int valeur = 0;

  public MaClasseFille() {
    System.out.println("Invocation contructeur MaClasseFille");
  }

  public MaClasseFille(final String nom, int valeur) {
    super(nom);
    this.valeur = valeur;
  }

  public int getValeur() {
    return this.valeur;
  }

  public void setValeur(int valeur) {
    this.valeur = valeur;
  }
}