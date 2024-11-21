package cmSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDeserMaClasseFille {
  public static void main(final String[] args) {

    MaClasseFille maClasseFille = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    try {
      maClasseFille = new MaClasseFille("nom1", 123);
      System.out.println("Serialisation");
      final FileOutputStream fichierOut = new FileOutputStream("c:/tmp/maclassefille.ser");
      oos = new ObjectOutputStream(fichierOut);
      oos.writeObject(maClasseFille);
      oos.flush();
      oos.close();
      System.out.println("Deserialisation");
      final FileInputStream fichierIn = new FileInputStream("c:/tmp/maclassefille.ser");
      ois = new ObjectInputStream(fichierIn);
      maClasseFille = (MaClasseFille) ois.readObject();
      System.out.println("MaClasseFille : ");
      System.out.println("nom : " + maClasseFille.getNom());
      System.out.println("taille : " + maClasseFille.getValeur());
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