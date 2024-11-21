package cmSerializable;


import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class TestSerialiserSingleton2 {

  public static void main(final String[] args) {
    try {
      final MonSingleton2 singleton1 = MonSingleton2.getlnstance();
      System.out.println(singleton1);
      final FileOutputStream fos = new FileOutputStream("singleton.ser");
      final ObjectOutputStream oos = new ObjectOutputStream(fos);
      try {
        oos.writeObject(singleton1);
        oos.flush();
      } finally {
        try {
          oos.close();
        } finally {
          fos.close();
        }
      }

      final FileInputStream fis = new FileInputStream("singleton.ser");
      final ObjectInputStream ois = new ObjectInputStream(fis);
      try {
        final MonSingleton2 singleton2 = (MonSingleton2) ois.readObject();
        System.out.println(singleton2);
      } finally {
        try {
          ois.close();
        } finally {
          fis.close();
        }
      }
    } catch (final ClassNotFoundException cnfe) {
      cnfe.printStackTrace();
    } catch (final IOException ioe) {
      ioe.printStackTrace();
    }
  }
}