package cm;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class HelloJUnit extends TestCase {
   @Test
   public void testAdd() {
      System.out.println("In Hello Junit");
      String str = "Junit is working fine";
      assertEquals("Junit is working fine",str);
   }
}