

public class OOP_Intro{} // to fix errors the rest of the file is not made of public classes so when you press run you can choose what class to run

// a object in a tangeble thing that like a pen, ball
// but even a bank account is a object even though you cant touch it 
// but bank has properties money, owner. it also has actions that it can preform 
// you can have methods to preform actions ect widraw and deposit money
// object has identity properties behaviour states but all are uniqe 
// OOP or object oriented programing is based on the concenpt of objects
// many programs are written to do things taht concern the real world
// software objects are like real life objects
// to code a bank acounts records( a object ) someone had to use OPP
// OPP makes programing easier it prevents long codes and allows to split up code in diffrent files
// objects identite(name) state(vars) and behaviour(methods) is stored in memory  
// you need a main method !!!
// it was fine at first to only use the main method 
//For an application, the first method to run is the method named main(). 
//There should be only one method named main() in an application. 
//In a small application, main() might do by itself all the computation that needs to be done. 
//In a larger application, main() will create objects and use their methods.
// you need framework imagine a car fetures come later firt comes body
// you need framework to define the identity behavour state
// frameworks are known as class in java
// classes create a object then we give the object values
// classes are used to make objects mostly 
// static is a type of method
// if a class has methods not shared by the object it creates its a static method
// static method belongs to class not the object the class creates 
// use static for basic things like 
// a instance is a type of methods a constructer 
// object is instance of class the only time you can use instance method is when you use a object

/* 
// NOTE: "this" keyword is used when the name of new initilized variable is the same 
// a example is carMake = make the new globaly used var is make and it has a different name than carmake the initial variable 
// the "this" keyword is used for something like this.carmake = carmake
*/

/* 
Accsessor (getters) is a method that returns a value but dosent change any attributes ex int w = j.getbmi // here getbmi will return valur
Mutator (setters) is a method that changes a value but returns nothing ex jim.setweight(80) // here setweight will change weight not return it

*/

/* 
Null pointer exeption NPE
you are trying to call a method on a null object or a objects methods 
ie if you do jim.getheight and gethight dne this will give NPE
if you do obj1.x and obj one DNE or is not def then its a NPE
if you have obj1.m3.m2.m1 if obj1 is null as it DNE you get NPE for trying to get obj1.m3
if obj1 exits but m3 null you get NPE for trying to get m2.m1
if obj1.m3 exits but m2 null NPE for m1 
but if everything but m1 null then you will only get NPE if you try to accsess something from m1

*/

/* 
HELPER METHODS

In Java, helper methods are small utility methods that help perform common tasks or calculations within a class. 
These methods are typically private, though they can be public if meant to be accessed from outside the class\
basicaly helper methods help other methods preform a task, calculation, validation etc

in the following example add and multiply methods are helper methods
they help the addandMultiply method preform its task
the main methods can use a helper method to preform a task or just return its value 
*/

class Calculator {

    // Public method that uses helper methods
    public int addAndMultiply(int a, int b, int multiplier) {
        int sum = add(a, b); // calling helper method
        return multiply(sum, multiplier); // calling helper method
    }

    // Private helper method for addition
    private int add(int x, int y) {
        return x + y;
    }

    // Private helper method for multiplication
    private int multiply(int x, int y) {
        return x * y;
    }

    public static void main(String[] args) {
        Calculator calc = new Calculator();
        System.out.println(calc.addAndMultiply(2, 3, 4)); // Output: 20
    }
}


class Car {

    // create variables of the class
    // none are static, so each Car object we create will have their own copy of these variables

    // empty var
    /* class vars can be used anywhere in var */
    String carMake;
    String carModel;
    String carColor;
    int carYear;
    // these 2 vars are not empty and have a pre determined value so they will not be innitilized
    boolean fillUp = false; // all car objects will have a full tank of gas
    int kmTravelled = 0; // all car objects will have travelled 0 km to start


    // Car constructors
    /* 
    This special method is used when we create (also known as instantiate) a car object
    Take the variables we just defined, and get their
    values based on the parameters given to the constructor when the object
    is created.
    */
    // constructer gives empty var a value
    /* the args are all method vars and can be used in this method only */
    public Car(String make, String model, String color, int year){
        /* this is a local var can be used in method only */
        carMake = make;
        carModel = model;
        carColor = color;   
        carYear = year; 
    }
    
    // a simple method that will indicate the gas tank needs filling
    public void fillGasTank() {
       if (fillUp == true) {
        fillUp = false;
        System.out.println("Gas tank is now full!");
       }

    }

    public void travel() {
        kmTravelled += 2;
        System.out.println(carMake+" "+carModel+" has travelled 2km!");
        System.out.println("Your total distance travelled is now "+kmTravelled+"km");

        if(kmTravelled % 5 == 0) {
            fillUp = true;
            System.out.println("You have run out of gas! Time to fill up.");
        }
    }

    public String toString() {
        return "Car Make: "+carMake+"\nCar Model: "+carModel;
    }

    public static void main(String[] args) {
        // create an object // beetle points to memory //new creates new object //
        // NOTE: beetle is ref type var is points to memory you can change ut to another ref type like beetle = beetle 2 if beetle 2 also a ref type made using a constructor
        Car beetle = new Car("Volkswagen", "Beetle","orange",2004);
        Car rondo = new Car("Kia","Rondo","grey",2011);

        System.out.println(beetle);

        rondo.travel();

        for(int i=0; i < 5; i++) { // travel 10 km
            beetle.travel();
        }

       beetle.fillGasTank(); // reset the gas tank

       beetle.travel(); // continue travelling

       rondo.travel(); // rondo travels
    }
}

// EX 2 PERSON
// CONSTRUCTER looks like this classname(vars) it creates the object
// then we can use the "this" function to assign stuff it help java know what object 
//ex int age; in constructer this.age = age then defien age as a paramiter when calling constructer 
// to change this.age = this.age + 1 but in constructer you can do this.age = age+1

class Person {

    String name;
    int age;
    String occupation;

    //constructer name must = class name
    Person(String name, int age, String occupation) {
        this.name = name;
        this.age = age;
        this.occupation = occupation;
    }

    // to string prints value of string insted of memory location
    public String toString() {
        return "This person's name is "+this.name;
    }
    
    public void sleep() {
        System.out.println(this.name+" falls asleep for 8 hours!");
    }

    public void eat() {
        System.out.println(this.name+" has paused for a snack.");
    }

    
    public static void main(String[] args) {
        Person p1 = new Person("Haider",28,"student");
        Person p2 = new Person("Talal",25,"data scientist");

        System.out.println(p1);
        System.out.println(p2);

        p1.sleep();
        p2.sleep();

        p2.eat();
    }
}

class Dog {
    
    // creating our vars for dog
    String name;
    String breed;
    int age;
    String gender;
    String bark = "Woof"; // this var has a default value ie the value is alredy given to it its not chnaged so its not initilized in constructor
    String size;

    // constructer 
    // in this constructer we create a new vars that match with the vars for dogs 
    // we dont use bark as that is a phrase its alredy defined 
    // we use the "this" method to give the empty strings a value. this.parameter = var for dog
    public Dog(String name, String breed, int age, String gender, String size) {
        this.name = name;
        this.breed = breed;
        this.age = age;
        this.gender = gender;
        this.size = size;
    }

    // method you can look at this as a function it dose something 
    // this method takes name + bark 
    // to print this you would have to call method
    public String greeting() {
        return name+" says "+bark;
    }

    // this method takes name + bread but calling the method toString converts it to string
    public String toString() {
        return "The dog's name is "+name+". The dog's breed is "+breed+".";
    }
    // main method
    public static void main(String[] args){
        // this is the actual object the format is classname varname = new Objectnamefromconstructer (parameters)
        // the new keyword creates a new object
        // parameters correspond to the constructer
        Dog chris = new Dog("Chris","Chihuahua",50,"female","small");

        // dose not acctually print the object the object it self just has arguments 
        // you need methods to do stuff with those arguments now that the vars are defined to arguments 
        // chris prints the toString that is default 
        // to print other thngs you have to name your method Ex chris.greeting the program auto converts to string
        System.out.println(chris);
        System.out.println(chris.greeting());
    }
}

class Bank{

    String fristname;
    String lastname; 
    int age;
    double limit = 1000;
    double balance;
    boolean activation;

    public Bank(String firstname, String lastname, int age, double balance){
        this.fristname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.balance = balance;
    }

    public String greeting(){
        return "Hello " + fristname +" "+ lastname + " welcome to the bank";
    }

    public String currentbalance(String balancetype) {
        return "Your " +balancetype+ " is: "+ balance; 
    }

    public double addfunds(double ammountadd){
        double deposit = ammountadd;
        System.out.println("you deposited: "+deposit+"$");
        return balance += deposit;
    }

    public String accountactivation() {
        String message = "Acount Active: ";
        String messagebad = ", Reason: OVER LIMIT WITHDRAW MONEY";
        if (balance > limit) {
            return message + "false" + messagebad; 
        } else {
            return message + "true";
        }
    }

    public Double Withdraw(Double ammoutwithdraw){
        double withdraw = ammoutwithdraw;
        System.out.println("you withdrawed: "+withdraw+"$");
        return balance -= withdraw;
    }

    public static void main(String[] args){

    Bank banker = new Bank("Haider", "Malik", 18, 950.0);

    System.out.println(banker.greeting());
    System.out.println(banker.currentbalance("current balance"));
    System.out.println(banker.accountactivation());
    System.out.println(""); // space new line

    // add funds this adds funds to balance but the new balance has to printed to show the added funds
    banker.addfunds(50.0);
    // new updated balance 
    System.out.println(banker.currentbalance("new balance"));
    System.out.println(banker.accountactivation());
    System.out.println(""); // space new line

    banker.addfunds(50.0);
    // new updated balance 
    System.out.println(banker.currentbalance("new balance"));
    System.out.println(banker.accountactivation());
    System.out.println(""); // space new line

    banker.Withdraw(500.00);
    System.out.println(banker.currentbalance("new balance"));
    System.out.println(banker.accountactivation());

    }

    }