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

        assertTrue(p.getStorage() == 0);
        // assert equal(Expected, Actual)
        assertEquals(0, p.getStorage()); // Person default has nothing passed through it so storage hs default val so this is correct 

        // same
        assertFalse(p.hasCellularConnectivity()); 
        assertFalse(p.hasCellularConnectivity() == true);

        // same
        assertTrue(p.hasCellularConnectivity() == false);
        assertTrue(p.hasCellularConnectivity() != true);   
        
        // same
        assertTrue(!(p.hasCellularConnectivity() == true)); 
        assertTrue(!(p.hasCellularConnectivity())); 

        assertEquals(0.0, p.getOriginalPrice(), 0.1); // dec numbers will have some error they will not be equal exactly last arg is a error margin ie 0.0 +- 0.1 = p.getogprice, ie +-0.1 is ok and not in error margin 
        assertEquals(0.0, p.getDiscountValue(), 0.1);
        assertEquals(0.0, p.getPrice(), 0.1);   

        //assertEquals("", p.toString());


    }

    // new test case with new constructor
    @Test
    public void test_Product_2(){
        Product p = new Product("iPadPro 12.9", 1709.00);
        assertNotNull(p.getModel()); // get model is a string recall from product
        assertEquals("iPadPro 12.9", p.getModel()); // Person default has nothing passed through
        // same 2 only if model in new obj compared with getter method
        assertTrue(p.getModel().equals("iPadPro 12.9"));
        // assertTrue(p.getModel() == ("iPadPro 12.9")); not nessisary


        // if condition true ok or else false (must pass boleen)
        assertTrue(p.getFinish() == null); // get finish of phone !
        assertFalse(p.getFinish() != null);

        assertTrue(p.getStorage() == 0);
        // assert equal(Expected, Actual)
        assertEquals(0, p.getStorage()); // Person default has nothing passed through it so storage hs default val so this is correct 

        // same
        assertFalse(p.hasCellularConnectivity()); 
        assertFalse(p.hasCellularConnectivity() == true);

        // same
        assertTrue(p.hasCellularConnectivity() == false);
        assertTrue(p.hasCellularConnectivity() != true);   
        
        // same
        assertTrue(!(p.hasCellularConnectivity() == true)); 
        assertTrue(!(p.hasCellularConnectivity())); 

        assertEquals(1709.00, p.getOriginalPrice(), 0.1); // dec numbers will have some error they will not be equal exactly last arg is a error margin ie 0.0 +- 0.1 = p.getogprice, ie +-0.1 is ok and not in error margin 
        assertEquals(0.0, p.getDiscountValue(), 0.1);
        assertEquals(1709.00, p.getPrice(), 0.1); 

        assertEquals("iPadPro 12.9 null 0GB (cellular conectivity: false): $(1709.00 - 0.00)", p.toString());
    }

    @Test
    public void test_Product_3(){
        Product p = new Product("iPadPro 12.9", 1709.00);
        assertNotNull(p.getModel()); // get model is a string recall from product
        assertEquals("iPadPro 12.9", p.getModel()); // Person default has nothing passed through
        // same 2 only if model in new obj compared with getter method
        assertTrue(p.getModel().equals("iPadPro 12.9"));
        // assertTrue(p.getModel() == ("iPadPro 12.9")); not nessisary

        p.setFinish("Space Grey"); // set finish

        // if condition true ok or else false (must pass boleen)
        assertFalse(p.getFinish() == null); // get finish of phone !
        assertTrue(p.getFinish() != null);
        assertEquals("Space Grey", p.getFinish()); 
        assertTrue(p.getFinish().equals("Space Grey"));

        p.setStorage(1000);
        assertTrue(p.getStorage() == 1000);
        // assert equal(Expected, Actual)
        assertEquals(1000, p.getStorage()); // Person default has nothing passed through it so storage hs default val so this is correct 

        p.setHasCellularConnectivity(true);
        // same
        assertFalse(p.hasCellularConnectivity() == false); 
        assertFalse(p.hasCellularConnectivity() != true);

        // same
        assertTrue(p.hasCellularConnectivity() != false);
        assertTrue(p.hasCellularConnectivity() == true);   
        
        // same
        assertTrue((p.hasCellularConnectivity() == true)); 
        // assertTrue(!(!(p.hasCellularConnectivity()))); two falses flip

        p.setDiscountValue(220.00);
        assertEquals(1709.00, p.getOriginalPrice(), 0.1); // dec numbers will have some error they will not be equal exactly last arg is a error margin ie 0.0 +- 0.1 = p.getogprice, ie +-0.1 is ok and not in error margin 
        assertEquals(220.00, p.getDiscountValue(), 0.1);
        assertEquals((1709 - 220), p.getPrice(), 0.1);

        assertEquals("iPadPro 12.9 Space Grey 1000GB (cellular conectivity: true): $(1709.00 - 220.00)", p.toString());
    }
    
}

