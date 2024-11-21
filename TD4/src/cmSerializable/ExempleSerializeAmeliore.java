package cmSerializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class ExempleSerializeAmeliore {
	
	public static void main(String[] args) throws Exception{
		EmployeAmeliore e1 = new EmployeAmeliore("E2");
		System.out.println("Nombre d'employes : "+Employe.getNbEmployes());
		System.out.println(e1);
		FileOutputStream f = new FileOutputStream("c:/tmp/e2.obj");
		ObjectOutputStream oos = new ObjectOutputStream(f);
		oos.writeObject(e1);
		oos.flush();
		oos.close();


	}

}
