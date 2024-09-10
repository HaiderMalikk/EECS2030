package console_apps;

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
        System.out.println(p2); // address diffrent than p

        // get model and og price using scanner 
        System.out.println("Enter model:");
        String model = input.nextLine();
        System.out.println("Enter original price:");
        double op = input.nextDouble();
        Product p3 = new Product(model, op);
        System.out.println(p3);

        input.close(); // close scanner
                
    
    }


}
