package cmSerializable;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExempleSerDeserPerso {
  public static void main(final String[] args) {

    ExemplePerso3 obj = null;
    ObjectOutputStream oos = null;
    ObjectInputStream ois = null;

    try {
      obj = new ExemplePerso3();
      obj.setChamp1("Alice");
      obj.setChamp2("Bob");
      System.out.println(obj);
      System.out.println("Serialisation");
      final FileOutputStream fichierOut = new FileOutputStream("c:/tmp/obj.ser");
      oos = new ObjectOutputStream(fichierOut);
      oos.writeObject(obj);
      oos.flush();

      System.out.println("Deserialisation");
      final FileInputStream fichierIn = new FileInputStream("c:/tmp/obj.ser");
      ois = new ObjectInputStream(fichierIn);
      obj = (ExemplePerso3) ois.readObject();
      System.out.println(obj);
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