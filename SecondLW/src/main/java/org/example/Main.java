package org.example;

import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        int task = 1;
        Scanner scanner = new Scanner(System.in);
        do{
            System.out.println("Enter task number");
            task = scanner.nextInt();
            switch (task){
                case 1:{
                    Person person = new Person();
                    person.setFullName("Dorokhov Ihor Valentivich");
                    person.setBirthDate("09-11-2002");
                    person.setCountry("Ukraine");
                    person.setPhoneNumber("0964117910");
                    person.setHomeAddress("0");
                    System.out.println(person.toString());
                    System.out.println("\n\n");
                }                     break;
                case 2:{
                    City city = new City();
                    city.setCityName("Kriviy Rih");
                    System.out.println(city.toString());
                } break;
                case 3:{
                    Fraction fraction = new Fraction(15, 20);
                    Fraction otherFraction = new Fraction(30,15);
                    Fraction otherFraction2 = new Fraction(50,5);
                    Fraction sum = fraction.add(otherFraction);
                    System.out.println(sum);
                    System.out.println("\n\n");
                    sum = fraction.add(otherFraction, otherFraction2);
                    System.out.println(sum);
                } break;
                default: System.out.println("Wrong task!");
            }
        }
        while (task > 0);
    }
}