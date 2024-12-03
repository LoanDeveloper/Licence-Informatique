import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author loant
 */
public class NewEmptyJUnitTest{
    
    public NewEmptyJUnitTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    
    CalculImpot calculImpot = new CalculImpot();
    @Test
    public void DT1() throws Exception{
        assertEquals(0, calculImpot.calcul(0,1));
    }
    
    @Test
    public void DT2() throws Exception{
        assertEquals(1837, calculImpot.calcul(27478,2.5));
    }
}
