package junit_tests; // no more testing in terminal with print statements

import static org.junit.Assert.*; // the .* imports the whole library
import org.junit.Test;
import model.*; // to use all classes in model use *


public class TestEntry {
    // developing own text case
    @Test // start if test case
    // method is a mutator and must be public followed by viod then name and no parameters
    // NO PRINT LINES !
    public void testEntry() {
        Product p = new Product("iPad Pro 12.9", 1709);
        p.setFinish("Space Grey");
        p.setStorage(1000);
        p.setHasCellularConnectivity(true);
        p.setDiscountValue(220.00);

        // make new entry obj
        Entry e = new Entry("F9ND372ND", p);
        assertEquals("F9ND372ND", e.getSerialNumber());
        assertTrue(e.getProduct() == p);
        assertSame(e.getProduct(), p); // are the two same yet same address

        assertEquals("iPad Pro 12.9", e.getProduct().getModel()); // same as product.getmodel as getproduct returns product
        assertTrue(e.getProduct().getModel().equals("iPad Pro 12.9")); // same as assert equal " this returns true"
        // use assert equals and true for getting each attribute
        assertEquals(1489.0, e.getProduct().getPrice(), 0.1);
        assertEquals(220.00, e.getProduct().getDiscountValue(), 0.01); //
        assertEquals("Space Grey", e.getProduct().getFinish());
        assertEquals(1000, e.getProduct().getStorage());
        // do again with asset true
        assertTrue(e.getProduct().getPrice() == 1489.0);
        assertTrue(e.getProduct().getDiscountValue() == 220.00);
        assertTrue(e.getProduct().getFinish().equals("Space Grey"));
        assertTrue(e.getProduct().getStorage() == 1000);
        assertTrue(e.getProduct().hasCellularConnectivity() == true);
        assertEquals("iPad Pro 12.9 Space Grey 1000GB (cellular conectivity: true): $(1709.00 - 220.00)", e.getProduct().toString()); //to string from product class
        assertEquals("F9ND372ND iPad Pro 12.9 Space Grey 1000GB (cellular conectivity: true): $(1709.00 - 220.00)", e.toString()); // gets the entry to string version

    }

    @Test
    public void test_entry_2(){
        Product p = new Product("iPad Pro 12.9", 1709);
        p.setFinish("Space Grey");
        p.setStorage(1000);
        p.setHasCellularConnectivity(true);
        p.setDiscountValue(220.00);

        // make new entry obj
        Entry e = new Entry("F9ND372ND", p);
        assertEquals("F9ND372ND", e.getSerialNumber());
        assertTrue(e.getProduct() == p);
        assertSame(e.getProduct(), p);
        assertEquals("F9ND372ND iPad Pro 12.9 Space Grey 1000GB (cellular conectivity: true): $(1709.00 - 220.00)", e.toString()); // gets the entry to string version

        Product p2 = new Product("iPad Air", 649.00);
        p2.setFinish("Gold");
        p2.setStorage(64);
        p2.setHasCellularConnectivity(false); // default is false as this celular was not def
        p2.setDiscountValue(100.00);

        e.setProduct(p2); // set new product
        //e.setProduct("iPad Air", 667.00); // can do this as we made sure to convert method args to a new objs args, but with this all other attributes will be null as there not set for this obj
        //e.getProduct().setFinish("grey"); // this is how you would set last objs attributes
        
        assertEquals("F9ND372ND", e.getSerialNumber()); // true still new p2 gets this number
        assertFalse(e.getProduct() == p);
        assertNotSame(e.getProduct(), p);
        assertTrue(e.getProduct() == p2);
        assertSame(e.getProduct(), p2);
        assertEquals("F9ND372ND iPad Air Gold 64GB (cellular conectivity: false): $(649.00 - 100.00)", e.toString()); // gets the entry to string version must change to gold colour and etc for alll changed attributes



    }

}