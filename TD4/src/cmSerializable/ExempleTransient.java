package cmSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExempleTransient {
	public static void main(String[] args) throws Exception{
		Employe e1 = new Employe("E1");
		e1.setMotDePasse("secret");
		System.out.println("Nombre d'employes : "+Employe.getNbEmployes());
		System.out.println(e1);
		System.out.println(e1.checkMotDePasse("secret"));
		FileOutputStream f = new FileOutputStream("c:/tmp/e1.obj");
		ObjectOutputStream oos = new ObjectOutputStream(f);
		oos.writeObject(e1);
		oos.flush();
		FileInputStream f2 = new FileInputStream("c:/tmp/e1.obj");
		ObjectInputStream ois = new ObjectInputStream(f2);
		Employe e2 = (Employe)ois.readObject();
		ois.close();
		System.out.println(e2);
//		e2.setMotDePasse("");
		System.out.println(e2.checkMotDePasse(""));
	}

}
