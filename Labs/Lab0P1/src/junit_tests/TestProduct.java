package junit_tests; // no more testing in terminal with print statements

import static org.junit.Assert.*; // the .* imports the whole library
import org.junit.Test;
import model.Product; // to use Product obj


public class TestProduct {
    // developing own text case
    @Test // start if test case
    // method is a mutator and must be public followed by viod then name and no parameters
    // NO PRINT LINES !
    public void test_Product_1() {
        Product p = new Product(); // call default constructor (no parameters)
        // think of a assertion as to verify the actual value of method call agaist its expected value there can be more than on
        
        // assert null checks if obj is null or if not throws error but default constructor #1 has no parameters so its null
        assertNull(p.getModel()); // get model is a string recall from product

        // if condition true ok or else false (must pass boleen)
        assertTrue(p.getFinish() == null); // get finish of phone !
        assertFalse(p.getFinish() != null);

        // assert equal(Expected, Actual)
        assertEquals(0, p.getStorage()); // Person default has nothing passed through it so storage hs default val so this is correct 


    }
    
}