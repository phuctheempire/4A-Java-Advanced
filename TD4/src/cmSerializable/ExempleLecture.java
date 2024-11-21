package cmSerializable;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class ExempleLecture {


	public static void main(String[] args) throws Exception{
		FileInputStream f = new FileInputStream("c:/tmp/e2.obj");
		ObjectInputStream ois = new ObjectInputStream(f);

		Employe e1 = (Employe)ois.readObject();
		ois.close();
		System.out.println("Nombre d'employes : "+Employe.getNbEmployes());
		System.out.println(e1);
		}
	
	
}
