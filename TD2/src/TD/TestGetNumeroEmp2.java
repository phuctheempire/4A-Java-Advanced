package TD;
import junit.framework.TestCase;
import org.junit.Test;
public class TestGetNumeroEmp2 extends TestCase {
    private Employee emp1 = new Employee("PHAM", "Xuan Phuc", 2000.00, 2000.00);
    private Employee emp2 = new Employee("CONSTANS", "Yoann", 2000.00, 2000.00);
    @Test
    public void testGetEmployee(){
        System.out.println("Test Get Numero Employee");
        assertEquals(1,emp1.getNumeroEmp());
        assertEquals(2, emp2.getNumeroEmp());
    }

}
