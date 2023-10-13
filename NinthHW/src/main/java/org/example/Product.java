package org.example;

public class Product {

    private String productName;
    private String category;

    public Product(String productName, String category){
        this.productName = productName;
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public String getProductName() {
        return productName;
    }

    @Override
    public String toString(){
        return "Product with name : " + productName + " Product category : " + category;
    }
}
