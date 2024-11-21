package cm;

import junit.framework.TestCase;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestJUnit {
   String message = "Hello World";	
   String messageTest = "Hello World";
   PrintExemple printer = new PrintExemple(message);

   @Test
   public void testPrintMessage() {	  
      assertEquals(messageTest,printer.print());
   }
}