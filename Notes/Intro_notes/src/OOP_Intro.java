import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

// !old notes -------------------------------------------------------------------------------------
public class OOP_Intro{} // to fix errors the rest of the file is not made of public classes so when you press run you can choose what class to run

// a object in a tangeble thing that like a pen, ball
// but even a bank account is a object even though you cant touch it 
// but bank has properties money, owner. it also has actions that it can preform 
// you can have methods to preform actions ect widraw and deposit money
// object has identity properties behaviour states but all are uniqe 
// OOP or object oriented programing is based on the concenpt of objects
// many programs are written to do things taht concern the real world
// software objects are like real life objects
// to code a bank acounts records() a object ) someone had to use OPP
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
// use static for basic things like 
// a instance is a type of methods a constructer 
// object is instance of class the only time you can use instance method is when you use a object

 

    // create variables of the class
    // none are static, so each Car object we create will have their own copy of these variables

    // empty var
    /* class vars can be used anywhere in var */
class Car{
    String carMake;
    String carModel;
    String carColor;
    int carYear;
    // these 2 vars are not empty and have a pre determined value so they will not be innitilized
    boolean fillUp = false; // all car objects will have a full tank of gas
    int kmTravelled = 0; // all car objects will have travelled 0 km to start


    // Car constructors
    /*
    a comstructor initilizes attributes so we can make onjects using it 
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



/* //!---------------------------------------------------------------------------------------------------------------- */
// !NEW NOTES


/* 
*  NOTE: "this" keyword is used when the name of new initilized variable is the same this see var shawdow for what 'this' dose
// a example is carMake = make the new globaly used var is make and it has a different name than carmake the initial variable 
// the "this" keyword is used for something like this.carmake = carmake
// the constructor just intilizes the values on class vars so we can pass them by calling the method and they update the class vars so everyone has the same values
* constructors always public 
 // note that constructors dont alwasys just initilize variables they can do other things like increment a counter create a array etc
*/

/* 
 * == vs .equals
 for ref type == checks the address in memory is same .equals checks the actual value ie the string or int inside
 for primitive
 == checks the value .equals is not used for primitive
*/

/* 
* Accsessor (getters) is a method that returns a value but dosent change any attributes ex int w = j.getbmi // here getbmi will return value, these methods cannot be used as values, has anything but void return
* Mutator (setters) is a method that changes a value but returns nothing ex jim.setweight(80) // here setweight will change weight not return it, these methods cannot not be used as values, has only void return

*/

/* 
* Null pointer exeption NPE
you are trying to call a method on a null object or a objects methods 
ie if you do jim.getheight and gethight dne this will give NPE
if you do obj1.x and obj one DNE or is not def then its a NPE
if you have obj1.m3.m2.m1 if obj1 is null as it DNE you get NPE for trying to get obj1.m3
if obj1 exits but m3 null you get NPE for trying to get m2.m1
if obj1.m3 exits but m2 null NPE for m1 
but if everything but m1 null then you will only get NPE if you try to accsess something from m1

*/

/*         
* refrence alising = copying refrence values
i could also do Product p3 = p2 all this dose is copy the address of p2 to p3 now both p2, p3 point to same address but now any change made to p2 will be reflected in p3 and vise versa as they share the same object in memeory 

// you can also store objects into array indexs to index 0 of a array can point to a object in memory so you can accsess that object as obj1.etc or arraywithobj[0].etc

/*
 * variable shawowing means that method or class etc has a shadow over the variable ie it can only be used in that class method etc
 to use it outside its shawdow we use the this keyword for methods allwing method variables to be accsessed in class
 */


// * in class example making objs in methods
class Point{
    int y;
    int x;
    public Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void moveUp(int y){
        this.y = y; // ! mutator only sets value
    }

    public Point moveUpBy(int i){
        Point newPoint = new Point(this.x, this.y); // creates a new obj of point with x and y from class vars hence this keyword was used Note that x and y were set in the main method and were passed throug the Point constructor witch then set the variables in the class using the this keyword
        newPoint.moveUp(i); // the newPoint had same values for its parameters as the lastest point objs values but there not the same obj new keyword makes a new obj so they dont have the same address
        return newPoint; // ! accesor must return 

    }

    public int getycor() {
        return this.y;
    }

    public static void main(String[] args) {
        Point p1 = new Point(1, 2);
        p1.moveUp(2);
        Point p2 = p1.moveUpBy(2);
        System.out.println(p1 == p2); // false
        System.out.println(p1.getycor() == p2.getycor()); // true

    }
}

/* 
* HELPER METHODS

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
// this helper method is a accesor
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


/*  
* anonomous objects */
/* In Java, anonymous objects are objects that are created and used without being explicitly assigned to a variable. 
They're typically used when you only need the object for a short period of time, such as passing
 it to a method or performing an action without needing to reference the object later. */
class MyPersonAnonymous {
    public String name;

    public MyPersonAnonymous(String name) {
        this.name = name;
    }

    public void greet() {
        System.out.println("Hello, my name is " + name);
    }

    public static void main(String[] args) {
        // Anonymous object: no reference to the object is created (can only call once here)
        new MyPersonAnonymous("John").greet(); // This creates the object, calls greet(), and discards the object - here we used the constructor as a method without specifiying class and var name ie no ref to obj

        // Non-anonymous object: the object is assigned to a variable ie i use the class 
        MyPersonAnonymous jane = new MyPersonAnonymous("Jane");
        jane.greet(); // Can call greet multiple times because we have a reference to the object
    }
}


// * refrence to this keyword 
// ! Note when using areguemnts passed through objs here its 'other', you can use the 'this' keywork to refer to the current obj
// ! meanign when you make the object the 'this' will refer to the object the methid in called on while the argument here 'other' will refer to the other obj which was passed as arg in this case 
// ! meaning java knows the context object here the context of other is jim so for elsa and amy they both refer to jim meanig 'this' for them is jim here
class MyPerson{
    public String name;
    private MyPerson spouse; // making a peson obj called spouse
    public MyPerson(String name){
        this.name = name;
    }

    public void marry(MyPerson other){
        // to check if marrage legal check if ethier maried logic. not p or not p = not(p and q)
        if (this.spouse != null || other.spouse != null ) {
            System.out.println("You are already married cannot marry: "+ other);
        }
        else{
            this.spouse = other; // ! this refers to current obj so at first this is jim.spouse, java knows the context obj here the context of other is jim
            other.spouse = this;
        }

    }

    public String toString() {
        return name.toString();
    }
    public static void main(String[] args) {
        MyPerson jim = new MyPerson("jim");
        MyPerson elsa = new MyPerson("elsa");
        MyPerson amy = new MyPerson("amy");
        jim.marry(elsa); // elsa is other
        jim.marry(amy);
        System.out.println(jim.spouse.name); // elsa is output, note that elsa the obj was assigned to the obj spouce using the marry method, now if we use the .spouce it will accsess jim objs wife obj, by using .name i accsess the obj spouces name that was set when we made the elsa obj, jim.spuce points to jims wife attribute that attribute goes to wife obj
    }
}

// * global vars
/* 
global variables are variables that are shared by all obj of the class. meaning when you create them they will be part of all the objects created with that class
this means all objs can do: obj.globalvar and it will return the same value for all objs of the class
we can change the global var but it will then be updated for all new objects made after the change
to create a global var use static variable
 */

// * Static Variables and methods
/* 
/ static method belongs to class not the object the class creates 
 every obj has diffrent variables thast passed in its paramater , but static variables are shared by all obj of the class as the same variable 
 but you can modify so that objs have diffrent versions of the static variable
 EX:in the constructor: x = staticvar, static counter ++, now each time a new obj is made 
 the static counter will be incremented and each obj will have its own version of the static counter, but if ++ was not done they would all have x = static var
 make sure x is not a static var too as that will make it shared by all obj and we want x to be different for all objs ie they all have obj.x = a different value
 Why not use a regular variable 1) you cant accsess and modify it as part of the obj, 2) you dont need to set it its set by defualt
 the static counter would be shared by all obj so it would be the same for all objs
 note that the static var is global meaning it must be initilized right away, and it is shared by all obj of the class
 for local varable you can declare and initilize in any order and anywhere in constructor 
 you can change the static variable anytime just like local varable but the change will be reflected in all obj of the class
 in local variable the change of the var will only be reflected in the obj that the var belongs to 
 with mutating method you can modify static var like a local varable
 but! you would not use 'this' you simply use the var name
 to call it outisde your class you would do classname.staticvarname = ....
 ! NOTE: you cannot use non-static var in a static method but you can use any type in a non static method, also static methods can be any type.
 ! Static means it belongs to the class and not the obj, static vars can be cahnged and updated in the class
 ! Ex of making a static var, 'public static int myStaticVar = 10;' with method, 'public static int getMyStaticVar()'

 !!!! YOU CANNOT USE NON STATIC METHODS IN A STATIC METHOD AND NOT VICE VERSA, YOU CANNOT USE NON STATIC VAR IN A STATIC METHOD BUT YOU CAN USE ANY TYPE IN A NON STATIC METHOD
 
 the this keyword calls the class if you use this.var in a static method it will throw an error
 to fix this use a non static method
 */

 /* 
   * caller vs calle
   caller is the obj that is calling the method
   calle is the obj that the method is being called on
   EX:  myobj.mymethod() the caller is myobj and the calle is myobj
  */

/*  
* call chain using stack 
EX: myobj.mymethod1().mymethod2().mymethod3()
1) myobj.mymethod1() is called
2) myobj.mymethod1() calls myobj.mymethod2()
3) myobj.mymethod2() calls myobj.mymethod3()
after the last method is called the code will return to the previous method and 
then the previous method and so on until it returns to the caller
putting a method on the stack is called push and removing something is called pop
so first in last out so frist method called = last method to return to
*/

/* 
 * java exeptions example 
 in java exeptions are used to handle errors at runtime 
 when they occur the flow of executuion is disrupted 
 the sytax for throwing an exeption is throw new Exceptionname();
 the sytax for catching an exeption is try{ code that might throw an exeption } 
 catch (Exceptionname e){ code to handle the exeption }
 you can have multiple catch blocks to handle different types of exeptions
 when we call the throw new exeption line first  the code in the try block is 
 executed and then the exeption is thrown 
 and the code in the catch block is executed if the exeption is not caught 
 it will be passed up the call chain until it is caught or the  program terminates
 
exeptions in call stack
lets say we call m1 and we go from m1 to m2 to m3 and m3 threw an exeption
1) m3 throws an exeption
2) m3 is popped off the stack and m2 is called
3) m2 can either handel the exeption or send it further down the stack if it cant handel the error (ie go to m1)
4) if m2 does not handle the exeption it is passed to m1
5) in m1 the exeptioan is caught using for ex : catch (Exception e)
6) if m1 handel the exeption the program continues to run and go to the next line of code in m1
- if m1 last method does not handle the exeption the it will go to the main method ie the caller of m1
- if the caller of m1 does handle the exeption the program will continue to run
- if the caller of m1 does not handle the exeption the program will terminate

NOTE: the call stack can be as long as you want meaning if the expection thrown by class can keep going lower
ie passed onto the next method then next method "where it would run the try catch" until its handeled and then it stops. 
if its never caught and delt with its given to the console ie the user gets it 
NOTE: the class can also handel the exeption itself by using a try catch block
NOTE: there is a deafult expection is java simple in catch put "Exeption" and all exeptions will be caught but this is not good
NOTE: you can have multiple catches for different types of exeptions so if we try x and x can throw multiple different errors we can have multiple catches for each exeption
NOTE: method opting for specify means it propigates the exeption to another method meanign it specifies where the exeption should be handled ie caught.
! NOTE: say we specify n times and say we are in a different class we still have accsess to all the variables of the original caller  
*/

class A{
    // any caller of this method should know that it may throw a exeption so we say throws NEG....
    // here we did not do public but we could have
    // This method 'specifies'  exeption
    void ma(int i) throws NegValueException {
        if (i<0){
            // if condition met code runs and exeption is thrown it goes to negvalueexeption class 
            // !NOTE: here we could have just used a console output but that is not good this as if it dose not terminate the code it will continoue to run and produce the wrong output
            throw new NegValueException("Neg value"); 
        }
        else {
            // if not neg do whatever here nothing so just return to caller
            // here a diffrent conditional can throw a different exeption
        }
    }
}

// this method is called with A obj so it runs class a
// this method 'catchs' exeption 
// catch vs specify; Catch means the exeption is caught by this method, specify means the exeption is passed to another method, the method that throws the exeption dose not count as specifier or catcher
class B {
    void mb(int i){
        A oa = new A();

        /*
        !!!! 
         insted of trying to handle the exeption here we are passing it up the call stack ie to A where it will be handled
         at A we do handle the exeption by calling throw new NegValueException("Neg value"); 
         if the negvalue exection happens after we try passing i through A then i was neg and the error given by A back to B after A's execution will be caught using catch(expectionName)
         and we can print wjat we want in B if the catch did not run that means the try worked no exeption was thrown and the program will continue to run. Note at B call stack is cut ie if B passed error to another class it would not go there the error stops at B
         */

        try {
            oa.ma(i);
            System.out.println("NVE did not happen i not neg");
            // can do whatever here if not neg one thing is setting a bool to true to escape a while loop 
        }
        catch (NegValueException e){
            System.out.println("NegValueException caught i was neg"); // i is neg
            // if negvalue exeption is caught here we can do whatever we want if try runs no exeption was thrown catch dose not run
        }
        // if the class A can throw multiple exeptions we can have a catch for each exeption
    }
}
// NEGVALUEEXEPTION DNE here we make the exeption
// extends is used to create a new class that is a sub class of the class that is being extended
// class NegValueException extends Exception which is a real java class
class NegValueException extends Exception {
    public NegValueException(String message) {
        super(message); // super is used to call the constructor of the parent class
        }
}

// test our exeptions
// exeptions should be in another class!
class Exep{
    public static void main(String[] args) throws NegValueException {
        // one pass one fail see B for details
        B ob =  new B();
        ob.mb(23);
        ob.mb(-1);
        // ! if we called the value directly with A then we get a error as A only throws it dose not catch it so we will see NVE neg value i but it will be as a error and execution terminates "A specifies " "B catches" dont call A!

    }
}

// call stakc of exeptons
/* 
// posiblities Cos "catch or specify"
1) origin
2) method subject to CoS req
3) method free from  CoS req
4) case 1 here exeption handeld earliest
5) case 2 here exeption never handeled earliest

note that when a input is given either the output is normal or an exeption is thrown
 */

// EXEPTIONS CONT
// here lets make a while loop tthat takes in input and handels errors using truy catch use the Integer class and parse int
// here the integer class throws an exeption if not a number so we need to catch it only.

class UserInputExceptions {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = 0;
        boolean valid = false;

        while (!valid) {
            System.out.print("Enter a number: ");
            try {
                num = Integer.parseInt(scanner.next());
                valid = true;
            } catch (NumberFormatException e) {
                System.out.println("Invalid number. Please try again.");
            }
        }
        System.out.println("You entered: " + num);
        scanner.close();
    }
}

// nested try catch
// here we have a try catch block inside another try catch block
// the inner try catch block will be executed first and if it throws an exeption then the outer try catch block will be executed
// if the inner try catch block does not throw an exeption then the outer try catch block will be executed
// if the inner try throws a error the inner catch will run but if the outer try throws an exeption then the outer catch will catch it
// the outer dose not throw a error if the inner try throws a error 
// * the finaly block is executed no matter what
// EX
class NestedTryCatchExample {
    public static void nestedtrycatchEX(String[] args) {
        try {
            // Outer try block
            System.out.println("Outer try block started.");

            try {
                // Inner try block
                System.out.println("Inner try block started.");
                
                // This will throw an ArithmeticException
                int result = 10 / 0;
                System.out.println("Result: " + result);
                
            } catch (ArithmeticException e) {
                // Handle the exception in the inner try block
                System.out.println("Caught ArithmeticException in inner catch: " + e.getMessage());
            }

            // Additional code in the outer try block
            int[] arr = new int[3];
            
            // This will throw an ArrayIndexOutOfBoundsException
            arr[5] = 10;

        } catch (ArrayIndexOutOfBoundsException e) {
            // Handle the exception in the outer try block
            System.out.println("Caught ArrayIndexOutOfBoundsException in outer catch: " + e.getMessage());
        } finally {
            System.out.println("Outer finally block executed.");
        }

        System.out.println("Program continues after nested try-catch.");
    }
}


// * Test Driven Dev or Regertion Testing
// inceremntal dev = rerun test after each change this can be after each new logical unit in incremented
// regestion testing = keep adding test cases after each change and builing on top of existing ones
// normal vs disruptive testing (meanign sometime a failed test is what we expect so in that case it should pass)

// Lets say we have a exeption thrown by a method and we want to test it using Junit text 
// lets say we have a method that throws an exeption called getValue() that returns value
// lets say value is bounded 0->3 and the setters are decrement and increment and they cant go past 0 or 3
// each method trows value to small and to big expetions respectively 
// and we want to test it using Junit text we. Note that we want some tests to pass and some to fail depending of if exeption is thrown or not
/// we can use assert equals to test that the exeption is thrown 
// ! we can have try cathe exeptions in junit

// code conter class nd from notes
/* 
in this test no exeption should be thrown as min value = 0 and that means try blovk runs and increments
@ Test 
public void testGetValue() {
    counter c = new counter(); new counter obj ASSUME INITIAL VALUE 0
    assertEquals (minValue, c.getValue()); // min val = 0 innitally 
    try{
        c.increment();
        assertEquals (1, c.getValue());
    }
    catch (ValueTooLargeEXeption e){
        // fail alwasy fails a test. 
        // here we want to throw fail as this should not run we can incerment and get value its ok here so the ctach should not run
        fail ("ValueTooLargeExeption should not have been thrown"); 
    }
}

here we expect an exeption as min value = 0 and new counter will be 0 so its get value is zero and so decrement will throw exeption
@Test
    public void testDecFromMinValue() {
        Counter c = new Counter();
        assertEquals(Counter.MIN_VALUE, c.getValue()); // passes as min value = 0 and new counter will be 0 so its get value is zero
        try {
            c.decrement();
            // we put a fail here and this should not run, we cannot deceremt from min value
            // NOTE: after the line in  a try block fails we go to the catch block so in this case the fail should not run and decerement should not run
            fail ("ValueTooSmallException is expected.");
        }
        catch(ValueTooSmallException e) {
         // Exception is expected to be thrown.
         // can do like e.print(" ..... ")
        }
    }

! note in the 2 examples after we fail a test we go to the catch block but what was wrong? did we increment after max value 
! did we decrement after min value? how will the catch block know the error type. 
! onr way to solve is using a loop that keeps on running as long as we dont get the exeption when we do we know what the exetion is and what the numbers were

*/

// * Obejct equality 
// object equality (overide or no overide)
/* 
 d = 7 e = 7
 then d == e true
 is obj p1 and obj p2 exist 
 p1 == p2 false as they are comparing the address not the values
 p1.equals(p2) true -> as we compare the values of the objects 
 ! the equals method is only avalible for reference types. the .equals used on primitive types is the same as using the '==' operator
 the equals method is built into the object class in java
 by deafult when we use .equals it overrides equals in the object class but we can change it using override
 p1.equals(p2) is turned into p1 == p2 wher we override (meaning change the equals method
 this is called inheriting the equals method from the object class. 
 in the class is would look like this: 
 class object{
    public boolean equals(Object obj){
        return this == obj; // note that 'this' refers to teh context object here that would be the object p1 so we would do p1 == obj where the object here is p2
    }
 }
 */
// ex:
class personbad {
    String name;
    int age;
    public personbad(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
class Personeq {
    String name;
    int age;
    public Personeq(String name, int age) {
        this.name = name;
        this.age = age;
    }
    // use source actions to generatre equals and hashcode on varables 
    @Override
    public boolean equals(Object obj) {
        // this is to avoid NPE as the next line would throw an exception if obj is null thats why this must come first 
        // NOTE 'this' refers to the object that is calling the equals method
        // if obj empty then return false or if the two objects are from different class then they are not the same object
        if (obj == null || this.getClass() != obj.getClass()) {
            return false;
        }
        // if the two objects we are comparing are equlas then they are the same object as the == compares address and if two objects have the same address they are the same object
        if (obj == this) {
            return true;
        }
        // ! WHY TYPE CAST: when we recive the obj as a argument in the equals method it is passed as a type Object meaning it might not have accsess to the methods of a obj of type personeq hence we must cast this 'obj' into type personeq so we can call the methods from person eq on it 
        Personeq p = (Personeq) obj; // ! here we add cast '(Personeq)' on obj as we know that 'obj' is of type Personeq as we are comparing with obj of type personeq. We can fix the type of obj to Personeq by changing parameter of equlas method to (Personeq obj) but the object might not be of type Personeq so here we can choose what type to cast our obj to
        return this.name == p.name && this.age == p.age; // returns true if name and age of obj p1 and obj passed into equals are equal. // 'this' is still the context obj and 'p' is the casted version of 'obj'
        //! NOTE in the line above we can use '==' as we are no longer dealing with reference types name and age are primitive (string and int). Also for name we could have used .equals() but here it dose not matter
    }
    // ! since our class has a equals method when we do .equal we have a method to use if we did not it would use the default equals method in the object class
    public static void main(String[] args) {
        // two objects with the same name and age
        Personeq p1 = new Personeq("John", 30);
        Personeq p2 = new Personeq("John", 30);
        Personeq p3 = new Personeq("John", 31);
        // ! if the equals method is not overriden then both will return false as both will be comparing the address
        System.out.println(p1.equals(p2)); // true
        System.out.println(p1 == p2); // false as this compares the address
        System.out.println(p1.equals(p3)); // false

        personbad p4 = new personbad("John", 30);
        System.out.println(p2.equals(p4)); // false as p4 is of type personbad and p2 is of type Personeq
    }
}

// * satic type, dynamic type, and type cast 
// static type: a ref variables decrated type
// dynamic type: type of address curruntly stored in a ref variable (changes at runtime)
// type casting: is a way to convert one type to another type in the personeqclass in the equals oeriden method we cast obj as Personeq so we convert the object type to Personeq type
// Ex
/* 
 class C1(){
    public m1{}
 }
 class C2(){
    public m2{}
 }

 main:
 C1 o1 = new c1();
 C2 o2 = new c2();
 o1.m1(); static type as o1 has m1
 o3 = o1
 o3.m1 // dynamic type as o3 must goto o1 and get m1
 // type casting 
 o3 = (C1) o1; // here we cast o1 whcih is of type C2 to C1 type now we can use C1's methods and do o3.m1
 */

// !Assert equals for dynamic vs static and Overriding equals
/* 
Lets say obj p1 is a object with a overriden equals method
 then let p2 be an object with a default equals method
 if we say p2 = p1
 then we do p2.equals(p2) 
 p2 points to p1 meaning p2's equals method is called on p1 so we are using p2's equal method
 also in the equals method we return true as p1 ==  p2, also p1 == p1 returns true as well as p2 == p2 returns true
 
 ! NOTE: if two objects are from different classes then there not not equal in terms of address and value so class1obj.equals(class2obj) is false always

 // SAY WE HAVE THIS CODE
public class PointV2 {
    private int x; private int y;
    public boolean equals (Object obj) {
        if(this == obj) { return true; }
        if(obj == null) { return false; }
        // must compare classes are objs from 2 different classes cannot be equals interms of ref or value
        if(this.getClass() != obj.getClass()) { return false; } PointV2 other = (PointV2) obj;
        return this.x == other.x && this.y == other.y;
    } 
}

// then
1 String s = "(2, 3)";
2 PointV2 p1 = new PointV2(2, 3);
3 PointV2 p2 = new PointV2(2, 3);
4 PointV2 p3 = new PointV2(4, 6);
5 System.out.println(p1 == p2);  false as its comparing the address
6 System.out.println(p2 == p3); false
7 System.out.println(p1.equals(p1));  true 
8 System.out.println(p1.equals(null));  false 
9 System.out.println(p1.equals(s)); /false 
10 System.out.println(p1.equals(p2)); true 
11 System.out.println(p2.equals(p3)); false 

if we say p2 = p3
then we do p2.equals(p3) 
p2 points to p3 meaning p2's equals method is called on p3 but since p2 points to p3 p3's equals method is called on p3 which returns true

 */

// !IMPLICATION
/* 
 if obj1 == obj2 then obj1.equals(obj2) == true as if the two objs have the same address they must have the same values 
 the opposite is NOT true as if two objects have the same values that dose not mean that they must have the same values 
 in notation this is "obj1 == obj2 => obj1.equals(obj2)"
 
  
 */

// !assertsame vs assertequals
/* 
 in junit we have assertsame and assertequals
 assert equal is for objects equality for its values is both exp1 and ep2 (assertEquals(exp1, exp2)) are primitive its just '==' if its references type then its exp1.equals(exp2) the order of the assert method arguments (exp1/2) matters
 assert same is for objects equality for its refernce and only passes if the two objects are the same object: assertsame(obj1, obj2) is true if both obj1 and obj2 are the same object meaning they have the same address
 assert same is the same as Asserttrue(obj1 == obj2) or Asserttrue(obj1.equals(obj2)) or assert false with the '!' t oflip value // NOTE this is for the case assertsame is true 
 ! NOTE: For assert equals there are 3 options for the equals method: 1,Obj class default (if no overriden) 2, the exp1's equals method (if overriden) 3, the exp1's equals method and exp2's equals method (if overriden) 
 */

// ! OBJ CLASS DIFFERENCES NOTE:
 /* 
    if we have p1, p2 and they are from different classes then p1 == p2 will not run its a error as we cannot compare objects from different classes if they were the same class this would compare the address
    if we now do p1.equals(p2) this will return false as in teh overriden equals method we have a conditional to check the classes of the two objects and if they are the same object then it will return true
    if we have not overridded the equals method "here for p1 ans we call p1's equal method on p2" than the default equals method in the object class will be called and we will return false as it dose p1 == p2 which just compares there address
    also the default equals method dose not check the dynamic type i.e it dose not see if the two obj's p1 and p2 are the same class or not all the defult equals method dose is p1 == p2
 */
// ! Comparing types in the equals method +  equality for array
/* 
 lets say we have a person class with name and age
 we have two objects p1 and p2 in our equals method we do this.name == other.name where other is p2 it will use the string equals method to evaluate 
 BUT lets say we were iteraing through a list of objects type person and we checked if this.person[i] == other.person[i] we now use the person class equals method specificly this.persons equals method
 this will go into the person equals method where we can define what attributes of person to compare ie name age etc. if no eq meth exits the address is compared and false is returned
 */

// ! short circuit effect
/* 
 MATH Logic vs LOGIC in java ie short circuit
 NOTE p and q and p or q are not the same as p&&q and p||q. 
 because p and q == q and p and same for or They are commutitive but && and || are not commutitive meaning p&&q and q&&p are not the same
 at runtime the evaluation of these logics are left to right the right sides evaluation depends of the left side passing or failing 
 EX: if p = false and q = true and we do p&&qthen after checking p if false it wont run q and returns false as q is not evaluated as we know the result is false
 how ever its not the same as q&&p as q is true it will run q then as its true we proceed to evaluate p then see that p is false so we return false
 EX: the same is true for p||q if p is true we skip over q and return true as its true no matter value of q 
 if p was false we would need to check q and return true as its true. from this we can say p||q is not q||p as in the first one p determines if we can short circuit and in the second one q determines if we can skip over p (short circuit)
 THIS is known as short circuiting

 Actual use case for short circuiting:
 if we want to divide a number by 0 then we can check the value of the devisor and if its 0 then we should not evaluate the division and return 0 right away note how the order we check matters and is not commutitive 
 */

 // !Call by value (primative vs reference)
/* 
 call by value is when we pass a value to a method as a parameter and the method makes a copy of the value and works on the copy then returns the copy
    lets say we have: int radius and void setradius(int r){this.radius = r} and we have a circle object C, when we do C.setraduis(4) we are passing 4 to the method setradius, the method makes a copy of 4 by doing r = 4 and works on the copy here its 'r' then returns the copy to int radius var
    EX2: Lets say we have a method void number (i) {i = i+1 return i} and we say number(2) it will return 3 but the value of 2 is not changed only i is changed and i is a copy of 2
 
 call by reference is when we pass a reference to a method and the method works on the reference here no copy is made and we return the reference
    lets say we have int radius method setradius(Circle c){this.radius = c.radius} and in a class we have a circle object C and another circle object C2 both with a radius defined, then we do C.setradius(c2) we are passing C2 to the method setradius, the method works on the reference of C2 in the method its 'c' then returns the reference to int radius var now the value of c's radius is changed 
    NOTE: we could make a copy of the object and pass that to our method to preserve the original object.
    EX2: NOTE we want to not use copies and most likely we want out object to chnage after we call some methods on it hence why we dont make a copy for references when we call by reference
    if we did make a copy then we would make a new local objec tfor setradius method and that would not be the same object as C2 so the change would be lost (meaning they would be reflected in the copy of obj).

 call by value and equals methods: in a equals method we pass a object as a parameter and later we cast it and say p1 = (Personeq) obj. p1 is now a copy of obj but still have the same address as obj 
 
 */

// ! container:
/* 
 a container is an object that holds other objects ie a list of objects (a container can have one or more objects)
 a containee in the objects that are in the container (these objects can have their own attributes and methods)
 NOTE: let BigOBJ = [obj1, obj2] obj1 and obj2 = {name, age}. Here container  is BigOBJ and containee is obj1 and obj2 we can accsess name and age from obj1 and obj2 or BIGOBJ by first using BIGOBJ to get to obj1/2 then using obj1/2 to get to name/age.
 NOTE: if there is a BIGOBJ2 with obj1 then there is sharing(alasing) between BIGOBJ and BIGOBJ2 over obj1 this means chanign obj1 will change obj1 in BIGOBJ and BIGOBJ2. 
 // ! Aggrigation = sharing, composition = not sharing
 in diagram: CLASS then a arrow (line); start of arrow if (aggrigation = dimond ) end of arrow has number of contanees (1 = single, * =  multiple) 
 Dot NOATTION: BIGOBJ.obj1.name will get name. NOTE if we cannot acsess name in another class if name was a private attribute. but we can have a getter method in that class that is also in BIGOBJ and we can call that method to get name. 
 NOTE: this is because if both BIGOBJS share the same method and they will both get the same result. so if we get private var name from BIGOBJ one using getname, then add getname to BIGOBJ (the method with private var) then BIGOBJ2 (the place we want to accsess var) they botg will get the same name.
 NOTE: to actually get the name we need to call the method getname on BIGOBJ2 (as we want this bigobj to get 'name') using BIGOBJ2.getname(). this will go to the getname method and get name from BIGOBJ
 //! note that the getname method since its in both classes has accsess to the variables in both BIGOBJ classes so when it dose get name it will get it from BIGOBJ.
 NOTE: if we made a method to use the getname method in a method: BIGOBJ2{ methodgetter{this.getname()} } the 'this' context obj specifies that when we call this method 'methodgetters' using say class BIGOBJ2.methodgetter() the 'this' will be the object of BIGOBJ2.
 */

 // ! AGGREGATION
 /* aggrigation is when we share objects within other objects (contaners) so we can have a big obj with many little objs within it but note that the little objs can exist independently of the big obj if they want  */
 // EX:
 class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters for title and author
    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }
}

class Library {
    // List of books in the library (aggregation relationship)
    private List<Book> books;

    public Library() {
        this.books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book); // from this book object the library class can access all its attributes
    }

    // Method to display all books in the library
    public void displayBooks() {
        for (Book book : books) {
            System.out.println("Book: " + book.getTitle() + " by " + book.getAuthor());
        }
    }
}

class aggregationEx {
    public static void main(String[] args) {
        // Create book objects independently
        Book book1 = new Book("The Great Gatsby", "F. Scott Fitzgerald");
        Book book2 = new Book("1984", "George Orwell");
        Book book3 = new Book("To Kill a Mockingbird", "Harper Lee");

        // Create a library and add books to it
        Library library = new Library();
        library.addBook(book1);
        library.addBook(book2);
        library.addBook(book3);

        // Display books in the library
        library.displayBooks();
    }
}



 // ! COMPOSITION
/* composition is when we do not share objects within other objects(containers) opposite of aggrigation 
 EX: say we have 2 contaers BIGOBJ and BIGOBJ2. BIGOBJ has a obj1 and BIGOBJ2 has a obj2. no methods are shared meaning we do not share the attribuites of obj2 not in BIGOBJ, it cannot accsess obj2 and vise versa for BIGOBJ2.

 NOTE: composition can be used to create a new object that is a combination of other objects. EX: making a car using engine ex where the car object takes in a engine objec to be built as a car
 */
// Component class engine for MyCar
// ! NOTE how two calsses do not share any attributes or methods they have there own version of the attributes and methods and some different ones
class Engine {
    private int mileage;

    // Constructor to set initial mileage
    public Engine() {
        this.mileage = 0;
    }

    public String start() {
        return "Engine started. Mileage: " + mileage;
    }

    public String stop() {
        return "Engine stopped. Mileage: " + mileage;
    }

    public void addMileage(int miles) {
        this.mileage += miles;
    }
}

// Composite class MyCar is the main class that uses Engine component
class MyCar {
    private Engine engine; // here we make an object of type Engine

    // Constructor to initialize MyCar with an Engine
    // by creating a car objec twe make a new Engine object by calling the Engine constructor inside the MyCar constructor
    public MyCar() {
        this.engine = new Engine();
    }

    public String start() {
        return "MyCar started. " + engine.start();
    }

    public String stop() {
        return "MyCar stopped. " + engine.stop();
    }

    // Method to drive the car and increase mileage no sharing we are using the engine class to increase the mileage
    public void drive(int miles) {
        engine.addMileage(miles);
        System.out.println("Driving " + miles + " miles. Total mileage: " + (engine.start()));
    }
}

// Main class to test the functionality
class CompositionEX {
    public static void main(String[] args) {
        MyCar myCar = new MyCar();

        // Using methods of the composite class
        System.out.println(myCar.start()); // Output: MyCar started. Engine started. Mileage: 0
        myCar.drive(50);                   // Driving 50 miles, adding to mileage
        System.out.println(myCar.stop());  // Output: MyCar stopped. Engine stopped. Mileage: 50
    }
}


 // ! COPY  CONSTRUCTOR
 /* 
  copy constructor is when we make a copy of an object using object address as a parameter we do not make any new objects
  Class  A{ A(A other){numberA = other.numberA }} // here we pass in a object into this contructor that has numberA  and we make a copy of that numberA and assign it to this numberA in the A class
  */

// ! INHERITANCE
/* 
 inheritance is when we have a class that is a child of another class (parent) and has access to its attributes and methods, NOTE: we can still override the methods in the child class this will change the default method from the parent.
 we would use this is we want a set of methods to be in the child class but we dont want to add every method we can define it once in parent and all childern can inherit it and accsess those methods (or override them)
 also insted of initilizing all the variables (self.this = this .... many times) we can pass all initilizing variables into parent class we can use the parent class to do it for us so this saves us from repating the commonly initlized variables
 we give a class its parent using the keyword extends (class name extends parent class name), we call the parent classes constructor using super(var to initilize)
 NOTE: unlike in some languages like python in JAVA we can only inherit from 1 parent class but we can have multiple child classes
 
 * basically a child class inherits all the attributes and methods from the parent class and each subclass can add its own attributes and methods ontop. but there wont be in the parent class. also any private methods or attributes will not be inherited
 * in the child class we use the default method from the parent class but we can override it to make our own version of the method we however cannot redeclare variables in the child class. for constructor method we use super() to call the parent class constructor
 * the parent class dose not have access to the child class but the child class has access to the parent class
 */

// Parent Class (Superclass)
class Animal {
    protected String name;  // Protected so subclasses can access it, by using the protected keyword this string name is accessible to all subclasses
    protected Boolean isAnimal = true; // all child classes can access this variable
    // * NOTE inheritence is one way while all children of animal class can asses is animal the parent class cannot accsess teh childs attributes like breed for ex
    // Constructor of the parent class
    public Animal(String name) {
        this.name = name;
    }

    // Method (this is the defualt method all subclasses can access)
    public void speak() {
        System.out.println("Animal speaks his name is "+ name);
    }

    public void washanimal() {
        System.out.println("Animal clean");
    }
}

// Child Class (Subclass)
class Doggy extends Animal {  // Subclass doggy extends Animal means animal is the  parent class of doggy, the extends keyword makes this a child class or whatever it extends
    private String breed;   // Private so only the class itself can access it
    // the name attribute is not here when we need it for this class we can use the name attribute from the parent class
    // since we passed it in the constructor we can use it in the child class and it will have the corrent name for this doggy class
    // because we will use doggy.name to access the name attribute in the child class where doggy is the object of the Doggy class
    // Constructor of the child class
    public Doggy(String name, String breed) { 
        // Call the parent class constructor and passing in the name this will pass the var name into the parent class's constructor which takes name as a parameter 
        // * we must call the parent constructor because the type doggy extends animal in creating a new doggy object we are creating a new animal object at the same time and the animal obj takes a name as a parameter so we must give it that
        super(name); // PARENT CONSTRUCTOR call must be the first line in the child class constructor
        this.breed = breed; // breed is a local var so we cannot access it in the parent class hence some vars are initilized in the constructor on child class (not evert animal has a breed but dose have name)
    }

    // Overriding the speak method if we did not do this it would print "Animal speaks" as doogy.speak() would call the parent class speak method
    @Override // this  is a annotation that tells the compiler that we are overriding a method its not required
    public void speak() {
        System.out.println("Woof! Woof!"); // making our own  speak method for doggy
    }

    // Getter for breed (Java often uses getters to access private fields)
    public String getBreed() {
        return breed;
    }
    public Boolean getIsAnimal() {
        return isAnimal;
    }
}

// another child class
class GuardDog extends Animal {
    private String state;  // State specific to GuardDog

    // Constructor to initialize the name and state
    public GuardDog(String name, String state) {
        super(name);  // Call the Animal constructor to initialize the name 
        this.state = state;  // Set the GuardDog's state
    }

    // Method for guarding behavior
    public void guard() {
        System.out.println("Guarding the house");
    }
    
    // no overriding speak method now the speak method from the parent class (animal) will be called

    // we can use super to not only call the constructor but any  method in the parent class
    public void clean() {
        super.washanimal(); // calling the parent class method (washanimal)
    }

    // Method to display the state
    public String getState() {
        return state;  // Return the GuardDog's state
    }
}
// Usage
class inheritanceEX {
    public static void main(String[] args) {
        Doggy doggy = new Doggy("Buddy", "Golden Retriever");  // Updated instance creation
        System.out.println(doggy.name);        // Output: Buddy
        System.out.println(doggy.getBreed());   // Output: Golden Retriever
        doggy.speak();                          // Output: Woof! Woof!
        System.out.println(doggy.getIsAnimal()); // Output: true

        // Create a GuardDog instance with a name and state
        GuardDog guardDog = new GuardDog("Rex", "alert");
        System.out.println(guardDog.name);    // Output: Rex (Print the guard dog's name)
        System.out.println(guardDog.getState());   // Output: alert (Print the guard dog's state)
        guardDog.speak();        // Output: Animal speaks (Invoke the default speak method from the Animal(parent) class)
        guardDog.guard();       // Output: Guarding the house (Invoke the guard method specific to GuardDog)
        guardDog.clean();  // Call the clean method from the GuardDog class (calls a method from the parent class)

        // assigning the child class to a object of type parent class
        Animal animal = new GuardDog("Rex", "alert"); // we can do this because GuardDog is a child class of Animal
        // * even though the animal object is a guard dog we can only use methods in the parent class because the object is of type animal
        animal.speak(); // this will call the speak method from the parent class deafult method still prints REX beacuse the gaurd dog obj calls the parent constructor which initializes the name var in animal class to use
        // if we did not use super in gaurd dog class the name would be null as name would be local to the gaurd dog class and type animal cannot access it
        // this is usefull if we want a obj of type gaurd dog but want methods only from the parent class
        // animal.name; // this causes a error as name is a protected var in the parent class so we can only access it in the child class or parent class not in the inheretanceEX class
    }

}

/*
 ! IMPORTANT NOTES for inheritance:

 - you cannot redeclare inherented attribute in a child class meaning you cannot have a variable with the same name in the child class, you can still make a copy of the attribute in the child class
 - we can override (make our own version of) methods in the child class from methods in the parent class, if we dont override we can only use the methods in the parent class's defualt method, when overriding use @Override before the method
 - a staric variable is shared by all instances of a class, meaning all the child classes can access it, but static variables cant be overridden so note 1 about redeleration dose not apply to static variables
 - while you can accsess parent class methods and variables from the child class, you cant access child class methods and variables from the parent class

# add the concept of multiple packages
 - this public, private, and protected keywords is known as the modifier of the attribute method or class and it determines there accessibility
 * NOTE for us subclasses are child classes, class inside a class is called a inner class or nested class
 Clases:
    - public class is avalible anywhere in the package
    - private class is only avalible in the parent class (the class its defined in)
    - if no modifier is used the class is default and is avalible in the package and any class
    - NOTE: for classes we can only have one public class in a file, but we can have multiple classes in a file. inner classes are classes that are defined inside another class and they can be public or private.

 Methods:
    - public method is avalible anywhere in the package, class or its subclasses
    - private method is only avalible in the parent class or its subclasses
    - is no modifier is used the method is default and is avalible in the package and any class
    - NOTE: for methods we can have multiple public and private methods in a class.

 Attributes:
    - public attribute is avalible anywhere in the package, class or its subclasses
    - private attribute is only avalible in the parent class
    - protected attribute is avalible in the parent class and its subclasses
    - if no modifier is used the attribute is default and is avalible in the package and any class

 - if you want to use something in a different package you must import it using the import keyword
*/

// * NOTE: we cannot assign a object made from the subclass to the object made using the parent class (this is called downcasting). this can be done the otehr way aroud(upcasting)

// dynamic binding
// static binding
// in static binding the method is called by the class that is calling it
// in dynamic binding the method is called by the object that is calling it

// !  Rules of substitution for objects :
// lets make 3 objects with classes: SmartPhone, IOS extends SmartPhone, and iphone extends IOS
// the obejcts = {SmartPhone_1, IOS_1, iphone_1}
// EX1: we can say IOS_1 = smartPhone_1 as IOS_1 is a subclass of SmartPhone_1 but we cannot say IOS_1 = SmartPhone_1 or iphone_1 = smartPhone_1
// Because: 1) IOS_1 is the child class and SmartPhone_1 is the parent class so while assigning the parent to the class is ok we cannot assign the child to the parent
// 2) because IOS_1 ectends SmartPhone 1 it cannot replace SmartPhone_1,
// EX2: we can say iphone_1 = IOS_1 as iphone_1 is a subclass of IOS_1 but we cannot say IOS_1 = iphone_1 as IOS is not a decendant of iphone_1 rather iphone is a decendant of IOS, (decenndent means the class is the child class of the parent class)
// * RS = parent class LS = child class (for it to work) here the LS must directly inherit from the RS by being a decendant of the RS meaning its parent class is the RS or its parents parent ... is the RS
// let: some other type of phone like andriod that extends SmartPhone and a class Samsung extends Andriod we could say Andriod_1 = SmartPhone_1 and Samsung_1 = Andriod_1
// but i cannot say iphone_1 = Andriod_1 or Andriod_1 = iphone_1 as because iphones parent is not Andriod and Andriod parent is not iphone they are both unrelated
// so we can say Smartphoe IOS_phone = new IOS_1() but we cannot do this the other way around (LS has parent and RS has child)
// so we can also then say smartphone_1 new_smartphone_1 = new iphone_1() but we cannot do this the other way around as iphone is a decendant of smartphone but not the other way around
// * siblings classes will also not work with substitution rule or with the ex before 
// LAST dynamic type just means the type of the object at runtime so if we make a smartphone object and assign it to an iphone object then the reassign the smartphone object to the andriod object 
// Then the last dynamic type is type andriod and first dynamic type is type iphone. 

// substitution with type casting
/* 
 
EX: 
smartphone_1 my_phone = new IOS_1();
IOS_1 my_ios_phone = my_phone;
* this is invalid as we are assigning a type ios to a type smartphone but myphone is type smartphone and smartphone is not a decendant of IOS (we can do this the other way around)

* to type cast the my_ios_phone to type IOS before we can assign it to my_phone which is now a type IOS
IOS_1 my_ios_phone = (IOS_1) my_phone;

EX: 
smartphone_1 aphone = new iphone_1();
IOS for_iphone = (iphone_1) aphone; 
here i first cast the object aphone to type iphone_1 and then assign it to type IOS this is ok now as LS is a decendant of RS 
before aphone was not a decendant of IOS it was parent (smartphone) but after we cast it to type IOS it is now a decendant of IOS = iphone

ex of anonymous assigning
((iphone_1) aphone).faceTime(); // if facetime is a method in class iphone_1 we must put the cast in parentesis as we must cast before we can call the method

* upward vs downward casting
upward casting is when we cast from a child class to a parent class (reduces the expected methods and attributes avalible)
downward casting is when we cast from a parent class to a child class (increses the expected methods and attributes avalible)
if you try to cast to the same class it is not a cast and will not throw an exception

* problem if we cast we nned to makde sure the object we are casting too can fulfill the methods and attributes of the class we are assigning to
for IOS for_iphone = (iphone_1) aphone; iphone one has all the methods so its fine
so if we have a new class that extends ios called iphone_mini as we cast a type iphone to type iphone mini we cannot use the iphones methods with IOS type anymore
 */

// ! Polymorphism
/* 
Polymorphism is a feature in object-oriented programming that allows objects of different classes to be treated as objects of a common superclass. 
This means that the same method can be called on objects of different classes, and the behavior of the method will vary depending on the actual class of the object being called on.
the method that can be called by different objects is called a polymorphic method
*/  
// EX:

// Abstract class Animal_EX defines the blueprint for all animals with an abstract method speak(), any class that inherits from Animal_EX must implement the abstract methods
// the abstract keyword denotes that the class in incomplete and must be overridden by subclasses
abstract class Animal_EX {
    // Abstract method speak(), which must be implemented by subclasses (the abstrct keyword makes sure all subclasses must implement this method)
    abstract String speak();  // blueprint for speak method 
    // * if any child class is missing this method it will throw an error
}

// Dog_EX class inherits from Animal_EX and provides an implementation for speak(), it must implement the abstract method speak()
class Dog_EX extends Animal_EX {
    @Override // Annotation indicating this method overrides the superclass method
    String speak() {
        return "Dog barks";
    }
}

// Cat_EX class also inherits from Animal_EX and provides its own implementation for speak()
class Cat_EX extends Animal_EX {
    @Override // Annotation indicating this method overrides the superclass method
    String speak() {
        return "Cat meows";
    }
}

// Main class demonstrating polymorphism
class PolymorphisimEX {
    // makeSpeak() is a polymorphic method that accepts an Animal_EX object and calls its speak() method
    public static String makeSpeak(Animal_EX animal) {
        return animal.speak(); // Calls the specific speak() method of the passed-in animal
    }

    // main() method is the entry point of the program
    public static void main(String[] args) {
        // Create instances of Dog_EX and Cat_EX
        Dog_EX dog = new Dog_EX();
        Cat_EX cat = new Cat_EX();

        // Polymorphic function call: makeSpeak() calls speak() on the correct subclass instance
        System.out.println(makeSpeak(dog));  // Output: Dog barks
        System.out.println(makeSpeak(cat));  // Output: Cat meows
    }
}

// rule for polymorphism,  you cannot pass in a object to the polymorphic method that is not type animal as the object needs to be a dencended of animal class

