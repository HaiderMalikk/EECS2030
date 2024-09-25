package junit_tests;
import static org.junit.Assert.*;

import org.junit.Test;
import model.*;

public class TestRefurbishedStore {

    @Test
    public void test_Refurbished_Store_1() {
        // make empty store
        RefurbishedStore rs = new RefurbishedStore(); // max 5 entries

        assertTrue(rs.getNumberOfEntries() == 0); // 0 at first
        assertTrue(rs.getPrivateEntriesArray().length == 5); // array len is alrays five we alredy def that as max entries
        assertTrue(rs.getPrivateEntriesArray()[0] == null); // this method returns entries array index is accessed o the array with [x index]
        assertTrue(rs.getPrivateEntriesArray()[1] == null);
        assertTrue(rs.getPrivateEntriesArray()[2] == null);
        assertTrue(rs.getPrivateEntriesArray()[3] == null);
        assertTrue(rs.getPrivateEntriesArray()[4] == null);
        assertTrue(rs.getEntries().length == 0); // array len =0 see method for why 
        

        Product p1 = new Product("iPad Pro 12.9", 1709.00);
        p1.setFinish("Space Grey");
        p1.setStorage(1000);
        p1.setHasCellularConnectivity(true);
        p1.setDiscountValue(220.00);
        Entry e1 = new Entry("F9FDN4NKQ1GC", p1); // first entry made using Entry.java constructor
        // add entry 1
        rs.addEntry(e1); // from rs ie rs obj made on line 1 of class add too it the entry type Obj e1 using v1 of addentry where i must pass a created entry obj
        // output for index 0 of entries will be sn product info includng all attributes 

        assertTrue(rs.getNumberOfEntries() == 1); // one after adding first
        assertTrue(rs.getPrivateEntriesArray().length == 5); // array len is alrays five we alredy def that as max entries

        // check after first entry now index 0 != null
        assertTrue(rs.getPrivateEntriesArray()[0] == e1); 
        assertTrue(rs.getPrivateEntriesArray()[1] == null);
        assertTrue(rs.getPrivateEntriesArray()[2] == null);
        assertTrue(rs.getPrivateEntriesArray()[3] == null);
        assertTrue(rs.getPrivateEntriesArray()[4] == null);
        assertTrue(rs.getEntries().length == 1);
        assertTrue(rs.getEntries()[0]==e1); // copys only first index to get entryes local array  es
        

        Product p2 = new Product("iPad Air", 649.00);
        p2.setFinish("Gold");
        p2.setStorage(64);
        p2.setHasCellularConnectivity(false);
        p2.setDiscountValue(100.00);
        Entry e2 = new Entry("F9FDN4NKQ1GC", p1);
        // add entry 2
        rs.addEntry("C9FZN4J8QC82", p2); // adds entry but uses v1 to do so, all we have to do is pass the sn and p and it passes that info to entries array using addentry v1

        assertTrue(rs.getNumberOfEntries() == 2); // 2 now
        assertTrue(rs.getPrivateEntriesArray().length == 5); // array len is alrays five we alredy def that as max entries

        assertTrue(rs.getPrivateEntriesArray()[0] == e1); 
        assertTrue(rs.getPrivateEntriesArray()[1].getSerialNumber().equals("C9FZN4J8QC82"));
        assertTrue(rs.getPrivateEntriesArray()[1].getProduct() == p2); // ref to product exits
        assertTrue(rs.getPrivateEntriesArray()[2] == null);
        assertTrue(rs.getPrivateEntriesArray()[3] == null);
        assertTrue(rs.getPrivateEntriesArray()[4] == null);
        assertTrue(rs.getEntries().length == 2);
        assertTrue(rs.getEntries()[0] == e1); 
        assertTrue(rs.getEntries()[1].getSerialNumber().equals("C9FZN4J8QC82"));
        assertTrue(rs.getEntries()[1].getProduct() == p2); // ref to product exits

        // add entry 3
        rs.addEntry("7YN4PFZ779UB", "iPad Pro 10.5", 929.00); // this method is v3 add entry and we give it the args it passes it to constructor makes the obj then we pass it and our sn using entry v1 to add this entry to entries array 

        assertTrue(rs.getNumberOfEntries() == 3); // 3 entries so far
        assertTrue(rs.getPrivateEntriesArray().length == 5); // array len is alrays five we alredy def that as max entries

        assertTrue(rs.getPrivateEntriesArray()[0] == e1); 
        assertTrue(rs.getPrivateEntriesArray()[1].getSerialNumber().equals("C9FZN4J8QC82"));
        assertTrue(rs.getPrivateEntriesArray()[1].getProduct() == p2);
        assertTrue(rs.getPrivateEntriesArray()[2].getSerialNumber().equals("7YN4PFZ779UB"));
        assertTrue(rs.getPrivateEntriesArray()[2].getProduct().getModel().equals("iPad Pro 10.5")); // no p3 ref exits
        assertEquals(929.00, rs.getPrivateEntriesArray()[2].getProduct().getOriginalPrice(), 0.1);
        assertTrue(rs.getPrivateEntriesArray()[3] == null);
        assertTrue(rs.getPrivateEntriesArray()[4] == null);
        
        assertTrue(rs.getEntries().length == 3);
        assertTrue(rs.getEntries()[0] == e1); 
        assertTrue(rs.getEntries()[1].getSerialNumber().equals("C9FZN4J8QC82"));
        assertTrue(rs.getEntries()[1].getProduct() == p2); // ref to product exits
        assertTrue(rs.getEntries()[2].getSerialNumber().equals("7YN4PFZ779UB"));
        assertTrue(rs.getEntries()[2].getProduct().getModel().equals("iPad Pro 10.5")); // no p3 ref exits
        assertEquals(929.00, rs.getPrivateEntriesArray()[2].getProduct().getOriginalPrice(), 0.1);

        
        


    }
    @Test
    public void test_Refurbished_Store_2() {
        // make empty store
        RefurbishedStore rs = new RefurbishedStore(); // max 5 entries

        

        Product p1 = new Product("iPad Pro 12.9", 1709.00);
        p1.setFinish("Space Grey");
        p1.setStorage(1000);
        p1.setHasCellularConnectivity(true);
        p1.setDiscountValue(220.00);
        Entry e1 = new Entry("F9FDN4NKQ1GC", p1); // first entry made using Entry.java constructor
        // add entry 1
        rs.addEntry(e1); // from rs ie rs obj made on line 1 of class add too it the entry type Obj e1 using v1 of addentry where i must pass a created entry obj
        // output for index 0 of entries will be sn product info includng all attributes 

        assertTrue(rs.getNumberOfEntries() == 1); // one after adding first
        assertTrue(rs.getPrivateEntriesArray().length == 5); // array len is alrays five we alredy def that as max entries


        Product p2 = new Product("iPad Air", 649.00);
        p2.setFinish("Gold");
        p2.setStorage(64);
        p2.setHasCellularConnectivity(false);
        p2.setDiscountValue(100.00);
        Entry e2 = new Entry("F9FDN4NKQ1GC", p1);
        // add entry 2
        rs.addEntry("C9FZN4J8QC82", p2); // adds entry but uses v1 to do so, all we have to do is pass the sn and p and it passes that info to entries array using addentry v1


        // add entry 3
        rs.addEntry("7YN4PFZ779UB", "iPad Pro 10.5", 929.00); // this method is v3 add entry and we give it the args it passes it to constructor makes the obj then we pass it and our sn using entry v1 to add this entry to entries array 
        
        assertTrue(rs.getProduct("F9FDN4NKQ1GC") == p1);
        assertTrue(rs.getProduct("C9FZN4J8QC82") == p2);
        assertTrue(rs.getProduct("7YN4PFZ779UB").getModel().equals("iPad Pro 10.5"));
        assertTrue(rs.getProduct("7YN4PFZ779UB").getFinish() == null);
        assertTrue(rs.getProduct("7YN4PFZ779UB").getStorage() == 0);
        assertTrue(rs.getProduct("7YN4PFZ779UB").hasCellularConnectivity() == false);
        assertEquals(929.00, rs.getProduct("7YN4PFZ779UB").getOriginalPrice(), 0.1);
        assertEquals(0.00, rs.getProduct("7YN4PFZ779UB").getDiscountValue(), 0.1);

        rs.getProduct("7YN4PFZ779UB").setFinish("Silver");
        rs.getProduct("7YN4PFZ779UB").setStorage(256);
        Product p3 = rs.getEntries()[2].getProduct(); // saving ref of p3 into var calles p3 using entries 
        p3.setHasCellularConnectivity(false);
        p3.setDiscountValue(270.00);

        // after setting vals 
        assertTrue(rs.getProduct("7YN4PFZ779UB").getModel().equals("iPad Pro 10.5"));
        assertTrue(rs.getProduct("7YN4PFZ779UB").getFinish() == "Silver");
        assertTrue(rs.getProduct("7YN4PFZ779UB").getStorage() == 256);
        assertTrue(rs.getProduct("7YN4PFZ779UB").hasCellularConnectivity() == false);
        assertEquals(929.00, rs.getProduct("7YN4PFZ779UB").getOriginalPrice(), 0.1);
        assertEquals(270.00, rs.getProduct("7YN4PFZ779UB").getDiscountValue(), 0.1);
                
    }

    @Test
    public void test_Refurbished_Store_3() {
        // make empty store
        RefurbishedStore rs = new RefurbishedStore(); // max 5 entries

        

        Product p1 = new Product("iPad Pro 12.9", 1709.00);
        p1.setFinish("Space Grey");
        p1.setStorage(1000);
        p1.setHasCellularConnectivity(true);
        p1.setDiscountValue(220.00);
        Entry e1 = new Entry("F9FDN4NKQ1GC", p1); // first entry made using Entry.java constructor
        // add entry 1
        rs.addEntry(e1); // from rs ie rs obj made on line 1 of class add too it the entry type Obj e1 using v1 of addentry where i must pass a created entry obj
        // output for index 0 of entries will be sn product info includng all attributes 

        assertTrue(rs.getNumberOfEntries() == 1); // one after adding first
        assertTrue(rs.getPrivateEntriesArray().length == 5); // array len is alrays five we alredy def that as max entries


        Product p2 = new Product("iPad Air", 649.00);
        p2.setFinish("Gold");
        p2.setStorage(64);
        p2.setHasCellularConnectivity(false);
        p2.setDiscountValue(100.00);
        Entry e2 = new Entry("F9FDN4NKQ1GC", p1);
        // add entry 2
        rs.addEntry("C9FZN4J8QC82", p2); // adds entry but uses v1 to do so, all we have to do is pass the sn and p and it passes that info to entries array using addentry v1


        // add entry 3
        rs.addEntry("7YN4PFZ779UB", "iPad Pro 10.5", 929.00); // this method is v3 add entry and we give it the args it passes it to constructor makes the obj then we pass it and our sn using entry v1 to add this entry to entries array 
        rs.getProduct("7YN4PFZ779UB").setFinish("Silver");
        rs.getProduct("7YN4PFZ779UB").setStorage(256);
        Product p3 = rs.getEntries()[2].getProduct(); // saving ref of p3 into var calles p3 using entries 
        p3.setHasCellularConnectivity(false);
        p3.setDiscountValue(270.00);

        // serch for products 
        assertTrue(rs.getSpaceGreyOrPro().length == 2);

        /// true & ture = true
        assertTrue(rs.getSpaceGreyOrPro()[0].equals("F9FDN4NKQ1GC") && rs.getSpaceGreyOrPro()[1].equals("7YN4PFZ779UB"));

        assertTrue(rs.getSpaceGreyPro().length == 11);
        assertTrue(rs.getSpaceGreyPro()[0].equals("F9FDN4NKQ1GC"));
        

    }
} //
