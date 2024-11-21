package cmSerializable;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;



import org.junit.Test;

import cmSerializable.ObjetSimple;
import junit.framework.Assert;

public class ExempleSimpleSer {
	
	@Test
	public void testSerialization(){
		try{
			ObjetSimple o = new ObjetSimple(1, "Alice", 42.42, "Bob");
			FileOutputStream f = new FileOutputStream("c:/tmp/objet2.ser");
			ObjectOutputStream oos = new ObjectOutputStream(f); // Le fichier sera créé
			oos.writeObject(o);
			oos.flush();
			oos.close();
		}catch (Exception e){
			Assert.fail();
		}
	}

}
