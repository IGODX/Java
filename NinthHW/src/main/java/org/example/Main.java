package org.example;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

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
        List<Integer> lst = new ArrayList<>(Arrays.asList(1, 2, 3, 4, -10, -5, 121, 122, 555));

        System.out.println("Greater then zero");
        lst.stream().filter(n-> n>0).forEach(n-> System.out.println(n));

        System.out.println("Less then zero");
        lst.stream().filter(n-> n<0).forEach(n-> System.out.println(n));

        System.out.println("Is palindrome");
        lst.stream().filter(n-> {
            String numberStr = String.valueOf(Math.abs(n));
            return numberStr.equals(new StringBuilder(numberStr).reverse().toString());
        }).forEach(n-> System.out.println(n));
    }

    private static void secondTask(){
        List<Product> products = Arrays.asList(
                new Product("Prostokvashino", "Milk"),
                new Product("Mlekovita", "Milk"),
                new Product("Dobre", "Milk"),
                new Product("Dobre", "Yogurt")
                );
        products.stream().forEach(product -> System.out.println(product));

        products.stream().filter(product -> product.getCategory().equals("Milk")).forEach(product -> System.out.println(product));
    }

    private static  void thirdTask(){
        List<Device> devices = new ArrayList<>();
        devices.add(new Device("Device1", 2022, 1000.0, "Red", "Type1"));
        devices.add(new Device("Device2", 2021, 800.0, "Blue", "Type2"));
        devices.add(new Device("Device3", 2022, 1200.0, "Green", "Type1"));
        devices.add(new Device("Device4", 2020, 1500.0, "Red", "Type2"));
        devices.add(new Device("Device5", 2021, 700.0, "Blue", "Type1"));

        devices.stream().filter(device -> "Red".equals(device.getColor())).forEach(System.out::println);

        devices.stream().filter(device -> device.getYearOfManufacture() == 2022).forEach(System.out::println);

        devices.stream().filter(device -> "Type1".equals(device.getDeviceType())).forEach(System.out::println);

    }

    private static void fourthTask(){
        List<Projector> projectors = Arrays.asList(
                new Projector("Projector1", 2022, 1500.0, "Manufacturer1"),
                new Projector("Projector2", 2021, 1200.0, "Manufacturer2"),
                new Projector("Projector3", 2022, 1800.0, "Manufacturer3"),
                new Projector("Projector4", 2020, 1300.0, "Manufacturer2")
        );

        projectors.stream().forEach(System.out::println);

        List<String> projectorNames = projectors.stream().map(Projector::getName).collect(Collectors.toList());
        projectorNames.stream().forEach(System.out::println);

        projectors.stream().filter(projector -> "Manufacturer2".equals(projector.getManufacturer())).forEach(System.out::println);

        projectors.stream().filter(projector -> projector.getYearOfManufacture() == 2022).forEach(System.out::println);

        projectors.stream().sorted(Comparator.comparingDouble(Projector::getPrice)).forEach(System.out::println);

        projectors.stream().sorted(Comparator.comparingDouble(Projector::getPrice).reversed()).forEach(System.out::println);
    }
}