package model;

// * thinkng
/* 
Entry[] is a array with type entry ie the class entrys type this means we can only pass in 
entry objects made using the entry classes constructer in the get entery you will see no matter what ver
we have to have a serial num and product ready then we pass these two parameters in a Entry using the new Entry and making 
a new entry obj using the constructer in model.entry it takes in obj 1 sn 1 product, then this entry is stored 
in entries array as the Entry obj is type entries it passes you can also see that ver1 helper only passes
type entry obj into the array ie the Entry obj must be presented as 'e' ie created breforehand then passed into the method to be added to array 
in ver 2 the entry obj is created using New Entry constructer where we pass in a sn and product(requried to be premade) then its passed into ver 1 
by calling ver 1 method and passing the entry obj we just made this then adds it to the entries array 
for ver 3 its the same concept but we also make the product so now we must first make the profuct using the product class in model this product has 
a name and ogprice to start with but we can add other attributes later just at the createion we must present these two attribuites then this newly made product
object and a sn are both passed into the Entry constructor and we have now made a new Entry obj this obj is passed into ver1 it passes as its of entry type
then obj is stored in entries array, just reemeber helper method only stores entry obj made with model.entrys constructor this obj must be made then passed
you can make it in the method too it also increments noe.

So now lets say entries[0] = e1 is made it will look like this: 003UFH4GF73 Ipad air 10.9, 1200.0 -> (sn, obj) -> so this is a Entry obj it holds a sn and product obj
Note that the product is not passed as a string its a also a object so i can call methods on ot like .getProduct or .getPrice etc
in practice i would assign a name to this entry like e1 like done in last last line then to get product i would e1.getProduct().getModel()... = ie "grey" etc
OR i could use the refurbrished store class obj then class its methods so let new refurbished store obj be = rs now lets get its sn witch belongs to Entry obj
then i would do rs.getPrivateEntriesArray()[0].getSerialNumber() here rs.getPrivateEntriesArray() returns entries and [0] gets entries[0]
*/

// template of all entrys ie collection of entrys like a shop of enrtys ie obj
public class RefurbishedStore {
    private Entry[] entries; // array of entry objs made using the model.Entry classe so Entry is the type and its name in entry

    // counter porpouse: record the number of non null entries and the index of those entries can be found with counter
    private int noe; // counter to count how many entrys that are not null, indicates the index of entries array that will store the new entry, if ref ie n=3 then 4rth entry will be at 3 as index starts at 0 
    private final int MAX_CAPACITY = 5; // max entrys constant and final

    public RefurbishedStore() {
        this.entries = new Entry[MAX_CAPACITY]; // for max this is not needed its final
        this.noe = 0; // initally its 0 by defualt also 0 so not needed
    }
    // get noe
    public int getNumberOfEntries() {
        return this.noe; // to track index elements etc
    }

    // getting array values using a methode note Entry is the return type and entries macthes that
    public Entry[] getPrivateEntriesArray() {
        return entries; // array might be null we must fix that for next method
    }

    /* get array of entries arrange in coronological order in that they are inserted so the earliest entry [0] in front last[-1] at end  we make our local array with copys of entries elements in case we get p entry and its null its a error this in needed*/
    public Entry[] getEntries() {
        //  array might be null from last method we must fix that
        // loop over all elements in entries using noe as condition then copy each element into es our local array rememebring that es's len was definded as noe so it will fit all elements from entries
        Entry[] es = new Entry[noe]; // create entry type array with len of noe
        for(int i =0; i < noe; i++) {
            es[i] = entries[i];
        }
        return es; // returning entry type
    }

    // this is a helper method to store entry in entries array and then incriment before this code was repeted in all 3 methods below
    // add entry ver1
    // user must give entry[] typr obj called e user must give us this obj, assume entry e dne ie no repeting serial nums
    public void addEntry(Entry e) {
        entries[noe] = e; /// at first noe = 0 so obj will go to start
        noe++; // increment counter nest obj will go to index 1 etc ...
    }

    // ver2 user given serial num and product obj
    public void addEntry(String sn, Product p){
        // Entry ne = new Entry(sn, p); // create new entry object note this is not a array rather a type of Entry as we need a typr of entry to store in entries array 
        // entries[noe] = ne; // store the ne in entry rmb that ne is like (x,y) this will go to one index
        // noe++; // increment counter
        // equvalent to the two lines above
        addEntry(new Entry(sn, p)); // call helper method it knows to call the helper method because that version of entry has 1 parameter new Entry, 
        // then in that one parameter Entry it has 2 parameters as the method addEntry dose so were making the obj inside the method that makes 
        // it so in Entry array will be passed a New entry methods created obj this obj will have sn and p passed in it so e in the v1 add entry is given by 
        // the addEntry helper as (sn, p) EX: in entries[0] it will be = [(sn, p)] it will be store in index of entries, also ne what we directrly replaced is entry type so it passes in method 
    }
    
    //ver 3 insted of adding product add the args of product so we make the obj
    public void addEntry(String sn, String model, double originalPrice) {
        //Product p = new Product(model, originalPrice);
        //Entry ne = new Entry(sn, p);
        // * anoymous obj at arg #2 NOTE this is why in test cases p3 is accsessed diffrently 
        addEntry(new Entry(sn, new Product(model, originalPrice))); // pass the whole product together using method parameters as inputs insted of passing p
    }

    // we input sn it rreturns corrispondig products index in entires
    public Product getProduct(String sn) {
        int index = -1; // expected to be reasigned to valid sn index in sn exits
        for(int i = 0; i < noe; i++) {
            Entry e = entries[i]; // entry type obj e is = some index of entries array
            // . equals as we compare value not adress
            if(e.getSerialNumber().equals(sn)) {
                index = i; // if we find the sn we assign the index to index of sn now we have index of product with x sn

            } 
            
            
        }
        if (index < 0) {
            return null; // if no product with sn is found return null
        }
        else{
            return entries[index].getProduct(); // return product with sn we are looking for
        }
    }

    // product look up ie get all products that are space grey or pro thast p1,p3
    public String[] getSpaceGreyOrPro() {
        int count = 0; //num of products satisfies condtionan and the index to store that product
        int[] indicates = new int[noe]; // make new int array called indices to store indicies of obj found only goes up to 5 max = noe
        for(int i = 0; i < noe; i++) {
            Product p = entries[i].getProduct(); // product p will go through all entries and assign itself to the entries corresponding products
            // 1. p.getmodel only as p is alredy p.getProduct so we are really doing p.getProduct.getmodel
            // 2. contains in a string method that checks if the substring in contained withing the string ie Pro is in ipad pro 10 so its true
            // ! note brackets arounf and not needed and is higher priority than or
            if(p.getModel().contains("Pro") || p.getFinish().equals("Space Grey") && p.getFinish() != null) {
                indicates[count] = i; // if we find a product that satisfies the condition we store it at the count index of indices so at start at index 0
                count++; //increment count so we can store the next product at the next index
            }
        }

        // now we make a array of strings for the serial number so we can return type string
        String[] sns = new String[count]; // make a string array with size of count

        for(int i = 0; i < count; i++){
            sns[i] = entries[indicates[i]].getSerialNumber(); // we get the serial number of the obj we stored in indiaces in last for loop and put it in sns array
        }

        return sns;

    }

    // only space grey and pro
    public String[] getSpaceGreyPro() {
        int count = 0; //num of products satisfies condtionan and the index to store that product
        int[] indicates = new int[noe]; // make new int array called indices to store indicies of obj found only goes up to 5 max = noe
        for(int i = 0; i < noe; i++) {
            Product p = entries[i].getProduct(); // product p will go through all entries and assign itself to the entries corresponding products
            // 1. p.getmodel only as p is alredy p.getProduct so we are really doing p.getProduct.getmodel
            // 2. contains in a string method that checks if the substring in contained withing the string ie Pro is in ipad pro 10 so its true since finsih is not set when making obj we use its not null
            if(p.getModel().contains("Pro") && p.getFinish() != null && p.getFinish().equals("Space Grey")) {
                indicates[count] = i; // if we find a product that satisfies the condition we store it at the count index of indices so at start at index 0
                count++; //increment count so we can store the next product at the next index
            }
        }

        // now we make a array of strings for the serial number so we can return type string
        String[] sns = new String[count]; // make a string array with size of count

        for(int i = 0; i < count; i++){
            sns[i] = entries[indicates[i]].getSerialNumber(); // we get the serial number of the obj we stored in indiaces in last for loop and put it in sns array
        }

        return sns;

    }

}
