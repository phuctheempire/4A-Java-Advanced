package cmSerializable;

import java.io.ObjectStreamField;
import java.io.Serializable;

public class ExemplePerso1 implements Serializable {

  private String champ1;
  private String champ2;

  private static final ObjectStreamField[] serialPersistentFields = 
    { new ObjectStreamField("champ1", String.class) };

  public String getChamp1() {
    return this.champ1;
  }

  public String getChamp2() {
    return this.champ2;
  }

  public void setChamp2(final String champ2) {
    this.champ2 = champ2;
  }

  public void setChamp1(final String champ1) {
    this.champ1 = champ1;
  }

  @Override
  public String toString() {
    return "ExemplePerso1 [champ1=" + this.champ1 + ", champ2=" + this.champ2 + "]";
  }
}