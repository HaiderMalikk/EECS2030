package model;

// template of all entrys ie collection of entrys like a shop of enrtys ie obj
public class RefurbishedStore {
    private Entry[] entries; // array of entry objs
    private int noe; // counter to count how many entrys that are not null, indicates the index of entries array that will store the new entry, if ref ie n=3 then 4rth entry will be at 3 as index starts at 0 
    private final int MAX_CAPACITY = 5; // max entrys constant and final

    public RefurbishedStore() {
        this.entries = new Entry[MAX_CAPACITY]; // for max this is not needed its final
        this.noe = 0; // initally its 0 by defualt also 0 so not needed
    }
    

}
