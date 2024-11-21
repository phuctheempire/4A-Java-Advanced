package cm;

import junit.framework.TestFailure;
import junit.framework.TestResult;

import java.util.Iterator;

public class MainJunitTest1 {
    public static void main(String a[]){
        JUnitTest1 test = new JUnitTest1();
        test.setName("testPrint");
//        System.out.println(test.printer.print());
//        TestResult result = test.run();
//        System.out.println(result.errorCount());
//        System.out.println(result.failureCount());
//        for(Iterator<TestFailure> iterator = result.failures().asIterator(); iterator.hasNext();){
//            System.out.println(iterator.next());
//        }
//        JUnitAnnotationExemple annoTest = new JUnitAnnotationExemple();
//        TestResult annoResult = annoTest.run();
        JUnitTestSuiteExemple ts = new JUnitTestSuiteExemple();
//        TestResult = ts.run




    }
}
