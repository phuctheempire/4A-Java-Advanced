package cmSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class ExempleSerialize {
	
	public static void main(String[] args) throws Exception{
		System.out.println("*************************************************");
		Employe e1 = new Employe("E1");
		System.out.println("Nombre d'employes : "+Employe.getNbEmployes());
		System.out.println(e1);
		System.out.println("*************************************************");
		FileOutputStream f = new FileOutputStream("c:/tmp/e1.obj");
		ObjectOutputStream oos = new ObjectOutputStream(f);
		oos.writeObject(e1);
		oos.flush();
		oos.close();
		System.out.println("*************************************************");
		System.out.println("Deserialisation");
		FileInputStream f_in = new FileInputStream("c:/tmp/e1.obj");
		ObjectInputStream ois = new ObjectInputStream(f_in);
		Employe er = (Employe)ois.readObject();
		System.out.println(er);
		System.out.println("*************************************************");


	}

}
