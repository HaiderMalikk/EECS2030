import java.util.Scanner;
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