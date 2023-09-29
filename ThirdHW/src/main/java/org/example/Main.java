package org.example;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Array array = new Array(10);
        array.Print();
        array.Print("Message");

        Builder builder = new Builder("Some Builder", 30, "builder");
        builder.introduce();
        builder.build();

        Tiger tiger = new Tiger("Tiger", 8, "roar");
        tiger.sleep();
        tiger.eat();
        tiger.makeSound();

        IMath mathOperations = array;
        System.out.println("Max: " + mathOperations.Max());
        System.out.println("Min: " + mathOperations.Min());
        System.out.println("Avg: " + mathOperations.Avg());
        System.out.println("\n**********************************\n");

        ISort sortingOperations = array;
        sortingOperations.SortAsc();
        array.Print();
        System.out.println("\n**********************************\n");
        sortingOperations.SortDesc();
        array.Print();
    }
}