package model;

public class Product {
    
    // attributes (should be privite ie visible only in this class) -> (public class ie visible in all classes)
    // create a public accsessor for privite class if you want to make a class privite
    private String model; // ie ipad pro 12.9
    private String finish; // grey, silver ...
    private int storage; // in gb
    private boolean hasCellularConnectivity; // false only wifi, true = wifi + cellular
    private double originalPrice; // old price
    private double discountValue; // new discounted price

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
        this.originalPrice = originalPrice; // must use this as name using is same as parameter name = var name

    }


    /* accessor will get and return a value here i can use getmodel of a obj like p1 to get its model the model is a parameter in constructor but when obj is made its passed as a arg*/
    public String getModel() {
        return this.model; // this. is optional 
    }

    /* mutators will set a value NOTE: here model will be passed when we make our object but this is used to update the value of model is needed */
    /* note that because model is privite this is needed to change it */
    public void setModel(String model) {
        this.model = model; // now since i used model in the method parameter i cant use same varname i must use this if i want to use same var name so this. is needed
    }

    public String getFinish() {
        return finish;
    }

    public void setFinish(String finish) {
        this.finish = finish;
    }

    public int getStorage() {
        return storage;
    }

    public void setStorage(int storage) {
        this.storage = storage;
    }

    public boolean hasCellularConnectivity() {
        return hasCellularConnectivity;
    }

    public void setHasCellularConnectivity(boolean hasCellularConnectivity) {
        this.hasCellularConnectivity = hasCellularConnectivity;
    }

    public double getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(double originalPrice) {
        this.originalPrice = originalPrice;
    }

    public double getDiscountValue() {
        return discountValue;
    }

    public void setDiscountValue(double discountPrice) {
        this.discountValue = discountPrice;
    }
    
    // accessor
    public double getPrice(){
        // i could just return originalPrice - discountvalue
        double price = 0;

        price = this.originalPrice - this.discountValue; // this. is not needed as var dose not clash with parameter name in method, this. is optional

        return price;

    }

    // to string by default wont work unless i modify it but with this i dont need to do p.toString it will be automatic
    public String toString() {
        String s = ""; 
        // i could do s+= all the vars but this is better
        // i could also do String.format(%s %d %f etc ...., this.model .... corespondint to each var ...) // this. is optional
        StringBuilder sb = new StringBuilder();
        sb.append(model + " " + finish + " " + storage + "GB " + "(cellular conectivity: " + hasCellularConnectivity + "): $(" + 
        String.format("%.2f", originalPrice) + " - " + String.format("%.2f", discountValue) + ")");
        s = sb.toString(); // note cant convert sb to a string use to string
        return s;
    }






}
