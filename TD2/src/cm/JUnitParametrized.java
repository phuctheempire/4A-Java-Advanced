package cm;

import java.util.Arrays;
import java.util.Collection;
 
import org.junit.Test;
import org.junit.Before;

import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class JUnitParametrized {
   private Integer n;

   private Integer rien;
   private Boolean expectedResult;
   private TestNombrePremier nbPremier;

   @Before
   public void initialize() {
      nbPremier = new TestNombrePremier();
   }

	
   public JUnitParametrized(Integer _n, Integer _rien, Boolean expectedResult) {
      this.n = _n;
      this.rien = _rien;
      this.expectedResult = expectedResult;
   }

   @Parameterized.Parameters
   public static Collection primeNumbers() {
      return Arrays.asList(new Object[][] {
         { 2, 0,true },
         { 6, 0,false },
         { 19, 0,true },
         { 22, 0,false },
         { 23, 0, true }
      });
   }

   @Test
   public void testparametrized() {
      System.out.println("Parameterized Number is : " + n);
      assertEquals(expectedResult, 
      nbPremier.premier(n));
   }
}