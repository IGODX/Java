package org.example;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
//        firstTask();
//        secondTask();
//        thirdTask();
        fourthTask();
    }

    private static void firstTask(){
        ArrayList<Integer> lst = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 10, -10, 500, -100));
        long countEven = lst.stream()
                .filter(e -> e % 2 == 0)
                .count();

        long countOdd = lst.stream()
                .filter(e -> e % 2 != 0)
                .count();

        System.out.println("Evens : " + countEven);
        System.out.println("Odd : " + countOdd);
    }
    private static void secondTask(){
        List<String> lst = Arrays.asList("Lviv", "Kiev", "Poltava", "Dnipro", "Kriviy Rih", "Lviv");
        lst.stream().distinct().forEach(x-> System.out.println(x));
        long count = lst.stream().filter(e-> e.length() >= 6).count();
        System.out.println("Number of cities with length >= 6 : " + count);
        long countCustom = lst.stream().filter(e-> e.equals("Lviv")).count();
        System.out.println("Number of cities called by Lviv : " + countCustom);
        long countCitiesByLetter = lst.stream().filter(e-> e.startsWith("K")).count();
        System.out.println("Count of cities by letter K : " + countCitiesByLetter);
    }

    private static void thirdTask(){
            List<Car> cars = Arrays.asList(new Car("Mercedes", 2012, 6000, "red", 120),
                    new Car("Toyota", 2015, 8000, "blue", 150),
                    new Car("Ford", 2010, 5000, "black", 130),
                    new Car("Honda", 2018, 9000, "silver", 120));
            System.out.println("All cars : ");
            cars.stream().forEach(car-> System.out.println(car));
        System.out.println("All cars with red color : ");
            cars.stream().filter(car-> car.getColor().equals("red")).forEach(car-> System.out.println(car));
        System.out.println("All cars with engine volume == 120 : ");
            cars.stream().filter(car-> car.getEngineVolume() == 120).forEach(car-> System.out.println(car));
        System.out.println("All cars with price 6000: ");
            cars.stream().filter(car-> car.getPrice() == 6000).forEach(car-> System.out.println(car));
        System.out.println("All cars that > 2012 and <= 2015: ");
            cars.stream().filter(car-> car.getYear() > 2012 && car.getYear() <= 2015).forEach(car-> System.out.println(car));

    }

    private static void fourthTask(){
        List<TV> tvs = Arrays.asList(
                new TV("Sony Bravia X900H", 2021, 1299.99, 65.0, "Sony"),
                new TV("Samsung QLED Q80T", 2020, 999.99, 55.0, "Samsung"),
                new TV("LG OLED CX", 2020, 1499.99, 48.0, "LG"),
                new TV("TCL 6-Series", 2020, 649.99, 55.0, "TCL"),
                new TV("Vizio M-Series", 2020, 799.99, 65.0, "Vizio")
                );
        System.out.println("Show all tvs");
        tvs.stream().forEach(tv-> System.out.println(tv));

        System.out.println("Show all TVs with the specified diagonal");
        tvs.stream().filter(tv-> tv.getScreenSize() == 48.0).forEach(tv-> System.out.println(tv));

        System.out.println("Show all Sony's TV");
        tvs.stream().filter(tv-> tv.getManufacturer().equals("Sony")).forEach(tv-> System.out.println(tv));

        System.out.println("Show all TVs, sorted by increasing price");
        tvs.stream().sorted(Comparator.comparingDouble(TV::getPrice)).forEach(tv-> System.out.println(tv));

        System.out.println("Show all TVs, sorted by decreasing price");
        tvs.stream().sorted(Comparator.comparingDouble(TV::getPrice).reversed()).forEach(tv-> System.out.println(tv));

        System.out.println("Show all TVs, sorted diagonally by height");
        tvs.stream().sorted(Comparator.comparingDouble(TV::getScreenSize).reversed()).forEach(tv-> System.out.println(tv));
    }

}