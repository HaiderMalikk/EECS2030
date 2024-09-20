package model;

// unit of storage aka database every usit of storage is entry
// template of a unit of storage ie a product
// shop if collection of entrys

public class Entry {
    // private only avalible in this class
    // serial number for complete product details
    private String serialNumber; // unique id 
    private Product product; // stores some product obj address

    // constructor should be poblic
    public Entry(String serialNumber, Product product){
        this.serialNumber = serialNumber;
        this.product = product;

        
    }

    public String getSerialNumber() {
        return serialNumber; // can put this.serialnumber as no parameter in this method called serialnumber
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber; // must do this as name exits in argument of method so avoid var shawdowing
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    // ! overloading not same as overriding diffrerent setProduct method is used based on what arguments are passed
    // overloaded set product that dose not expect use to make a prodect obj insted has it made as in last method i have to pass a adress of product obj 
    // with this we pass model and price but i make the product accordingly by making  aproduct obj inside method
    public void setProduct(String model, double originalPrice) {
        /* 
        same as 
        Product product = new Product(model, originalPrice);
        this.product = product;
         */
        this.product = new Product(model, originalPrice); // make new obj using ref alising note here we are not initilizing model and og price we use then as arguments in this method no need to initilize them
        
    }

    // overriding to string of this class
    public String toString() {
        return serialNumber +" "+ product.toString(); // here i use to string again in my method again 

    }

}

