package cmSerializable;

import java.io.IOException;

public class EmployeAmeliore extends Employe{
	
//	private static final long serialVersionUID = 1L;

	public EmployeAmeliore(String _n) {
		super(_n);
	}
	

	private void readObject(java.io.ObjectInputStream in)
			 throws IOException, ClassNotFoundException{
		in.defaultReadObject();
		Employe.nbEmp++;	
	}


}
