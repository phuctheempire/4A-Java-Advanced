package cmSerializable;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class ExemplePerso3 implements Serializable {

  private String champ1;
  private String champ2;

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
    return "ExemplePerso3 [champ1=" + this.champ1 + ", champ2=" + this.champ2 + "]";
  }

  private void readObject(final ObjectInputStream ois) throws IOException, 
  ClassNotFoundException {
	  this.champ1 = (String) ois.readObject();
	  this.champ2 = (String) ois.readObject();
  }
  private void writeObject(final ObjectOutputStream oos) throws IOException {
    oos.writeObject(this.champ1);
    oos.writeObject(this.champ2);
  }

}