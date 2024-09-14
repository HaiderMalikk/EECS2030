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
    // variable shawowing means that model has a shadow over the Pruduct method and so the parameter model can be used only in this shadow ie inside the medthod to use assign this method var to a class var i use this keyword
    // the this keyword refers to a class var allowing us to break the variabls shadow (the variable being model parameter at method lvl)
    public Product(String model, double originalPrice) {
        this.model = model; // this referses to model attrebutes not input 
        this.originalPrice = originalPrice; // must use this as name using is same as parameter name = var name

    }



    /* SETTER can set a attribute after obj is created too even if not in new obj when making it */

    /* accessor will get and return a value here i can use getmodel of a obj like p1 to get its model the model is a parameter in constructor but when obj is made its passed as a arg*/
    // the accessor can also create a var then return it so it can set vars to values too but it must return it
    public String getModel() {
        return this.model; // this. is optional 
    }

    /* mutators will set a value NOTE: here model will be passed when we make our object but this is used to update the value of model is needed or to add a model after OBJ created */

    /* note that because model is privite this is needed to change it */
    // mutator or setter will set a var it can calculate something then set it to a var BUT must not return anything
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
