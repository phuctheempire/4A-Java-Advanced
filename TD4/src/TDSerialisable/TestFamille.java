package TDSerialisable;

import javax.imageio.IIOException;
import java.io.*;

public class TestFamille {
    public static void main( String a[]) throws Exception{
        Personne per1 = new Personne("1234", "PHAM", "Xuan Phuc", Genre.Homme);
        Personne per2 = new Personne("5678", "PHAN", "Xuan Phan", Genre.Homme);
        Famille fam = new Famille(per1, per2);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("c:/tmp/famille.ser"));
        oos.writeObject(fam);
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("c:/tmp/famille.ser"));
        Famille fam1 = (Famille) ois.readObject();
        System.out.println(fam1.toString());

}
}
