package cmSerializable;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import org.junit.Test;

import junit.framework.Assert;

public class ExempleSimpleDeSer {

	@Test
	public void testDeSerialization(){
		try{
			FileInputStream f = new FileInputStream("c:/tmp/objet2.ser");
			ObjectInputStream ois = new ObjectInputStream(f); // Le fichier sera créé
			ObjetSimple o = (ObjetSimple)ois.readObject();
			ois.close();
			System.out.println(o.afficher());
			Assert.assertEquals(o.unEntier, 1);
			Assert.assertTrue(o.uneString.equals("Alice"));
			Assert.assertEquals(o.unReel, 42.42, 0.01);
		}catch (Exception e){
			e.printStackTrace();
			Assert.fail();
		}
	}
	
}
