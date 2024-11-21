package cmSerializable;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class SerDeserMaClasseValidation {
  public static void main(final String[] args) {

    MaClasseValidation maClasseFille = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    try {
      maClasseFille = new MaClasseValidation();
//       maClasseFille.setNom("Alice");
      System.out.println("Serialisation");
      final FileOutputStream fichierOut = new FileOutputStream("c:/tmp/maclasseval.ser");
      oos = new ObjectOutputStream(fichierOut);
      oos.writeObject(maClasseFille);
      oos.flush();

      System.out.println("Deserialisation");
      final FileInputStream fichierIn = new FileInputStream("c:/tmp/maclasseval.ser");
      ois = new ObjectInputStream(fichierIn);
      maClasseFille = (MaClasseValidation) ois.readObject();
      System.out.println("MaClasseFille : ");
      System.out.println("nom : " + maClasseFille.getNom());
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