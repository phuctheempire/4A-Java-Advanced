package TD;
import junit.framework.TestCase;
import org.junit.Test;
public class TestGetNumeroEmp1 extends TestCase {
    private Employee emp1 = new Employee("PHAM", "Xuan Phuc", 2000.00, 2000.00);

    @Test
    public void testGetEmployee(){
        System.out.println("Test Get Numero Employee");
        assertEquals(0,emp1.getNumeroEmp());
    }

}
