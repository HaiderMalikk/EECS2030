package console_apps;
// console app: we can text our code here by printing to console to verify alt is junit test

import java.util.Scanner;
import model.Product;

public class ProductApp {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // syntax for obj: classname varname = new classname(args)
        // we made this pruduct obj using a default constructor later i added a new constuctor, constructor #2 then that one was used and default was lost
        // deafault constructor no args! , if i delete new default constructor, constructor #2 then this wont run as now i need parameters from constructor #3
        Product p = new Product(); // i have accsess to product class from import 
        System.out.println(p); // p = product and has 6 attributes ie price, finish etc, this only prints address

        Product p2 = new Product("iPad Pro 12.9", 1289.00); // obj made using constructor #3 
        System.out.println(p2); // address diffrent than p, insted of printing the adress i do a to string i dont have to use toString manually its optional anything not def in obj creating is null

        // //to show how to use getters and setters
        // // set the finish 
        // p2.setFinish("Black");
        // System.out.println(p2.getFinish()); // getting the model and printing it

        // // get model and og price using scanner 
        // System.out.println("Enter model:");
        // String model = input.nextLine();
        // System.out.println("Enter original price:");
        // double op = input.nextDouble();
        // Product p3 = new Product(model, op);
        // System.out.println(p3); // 

      // refrence alising 
        // i could also do Product p3 = p2 all this dose is copy the address of p2 to p3 now both p2, p3 point to same address but now any change made to p2 will be reflected in p3 and vise versa as they share the same object in memeory
        


        input.close(); // close scanner                
    
    }


}
