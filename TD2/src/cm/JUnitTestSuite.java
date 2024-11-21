package cm;

import junit.framework.*;

public class JUnitTestSuite {
   public static void main(String[] a) {
      // add the test's in the suite
      TestSuite suite = new TestSuite(JUnitTest1.class, JUnitTest2.class, HelloJUnit.class);
      System.out.println("Nombre de test = "+suite.countTestCases());
      System.out.println("Nombre de cas de test de l'index 1 = "+suite.testAt(0).countTestCases());
      TestResult result = new TestResult();
      suite.run(result);
      System.out.println("Nombre de tests exécutés = " + result.runCount());
      System.out.println("Nombre de fail = "+result.failureCount());
   }
}