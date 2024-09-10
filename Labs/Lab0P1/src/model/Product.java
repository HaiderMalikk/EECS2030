package model;

public class Product {
    
    // attributes (should be privite ie visible only in this class) -> (public class ie visible in all classes)
    // create a public accsessor for privite class if you want to make a class privite
    private String model; // ie ipad pro 12.9
    private String finish; // grey, silver ...
    private int storage; // in gb
    private boolean hasCellularConnectivity; // false only wifi, true = wifi + cellular
    private double originalPrice; // old price
    private double discountPrice; // new discounted price

    // constructors (default constructor exits but after we make our own then it will go away ie if we make a new constructor old one goes away)
    // default constructor no args // constructor #2 
    public Product() {

    }

    // method overloading = same methods name new parameters
    // here overload constructor #2 
    // parameters should be the things you want to change throughout 
    // NOTE: either varname = parametername or varname = this.parametername(same as varname)
    // here name of parameter same as var names so use self
    // constrcutor #3
    public Product(String model, double originalPrice) {
        this.model = model; // this referses to model attrebutes not input 
        this.originalPrice = originalPrice;

    }


    /* accessor */

    /* mutators */


}
