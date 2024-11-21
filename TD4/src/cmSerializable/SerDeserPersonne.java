package cmSerializable;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

public class SerDeserPersonne {
  public static void main(final String[] args) {

    Personne3 personne = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    try {
      personne = new Personne3("Dupont", "Alice", 160, "code1234", new Date());
      System.out.println(personne);
      System.out.println("Serialisation");
      final FileOutputStream fichierOut = new FileOutputStream("c:/tmp/maclasseval.ser");
      oos = new ObjectOutputStream(fichierOut);
      oos.writeObject(personne);
      oos.flush();

      System.out.println("Deserialisation");
      final FileInputStream fichierIn = new FileInputStream("c:/tmp/maclasseval.ser");
      ois = new ObjectInputStream(fichierIn);
      personne = (Personne3) ois.readObject();
      System.out.println(personne);
    } catch (final java.io.IOException e) {
      e.printStackTrace();
    } catch (final ClassNotFoundException e) {
      e.printStackTrace();
    } finally {
      try {
        if (ois != null) {
          ois.close();
        }
        if (oos != null) {
          oos.close();
        }
      } catch (final IOException ex) {
        ex.printStackTrace();
      }
    }
  }
}