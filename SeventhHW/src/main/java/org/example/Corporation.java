package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Corporation {
    private static ArrayList<Employee> employees = new ArrayList<>();
    private Scanner scanner = new Scanner(System.in);

    private String path = "D:\\Java Projects\\SeventhHW\\src\\main\\java\\org\\example\\fivthTask.txt";

    public void choseOption(){
        while (true) {
            System.out.println("Enter option:");
            System.out.println("1. Add employee");
            System.out.println("2. Edit employee");
            System.out.println("3. Delete employee");
            System.out.println("4. Search by surname");
            System.out.println("5. Show all employees");
            System.out.println("6. Save to file");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    editEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    searchEmployeeByLastName();
                    break;
                case 5:
                    printAllEmployees();
                    break;
                case 6:
                    saveEmployeesToFile();
                    return;
                default:
                    System.out.println("Некоректний вибір. Спробуйте ще раз.");
            }
        }
    }
    private void loadEmployeesFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length == 2) {
                    String lastName = parts[0].trim();
                    int age = Integer.parseInt(parts[1].trim());
                    employees.add(new Employee(lastName, age));
                }
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void saveEmployeesToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Employee employee : employees) {
                writer.write(employee.getSurname() + ", " + employee.getAge());
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
}
    private void addEmployee() {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path, true))) {
            System.out.println("Enter surname: ");
            String lastName = scanner.nextLine();
            System.out.println("Enter age: ");
            int age = scanner.nextInt();
            employees.add(new Employee(lastName, age));
            writer.write(lastName + ", " + age);
            writer.newLine();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private void editEmployee() {
        System.out.print("Enter employee surname for search: ");
        String lastName = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getSurname().equals(lastName)) {
                System.out.print("Enter new age: ");
                int newAge = scanner.nextInt();
                employee = new Employee(lastName, newAge);
                System.out.println("Employee is edited!.");
                return;
            }
        }
        System.out.println("Employee has not been found.");
    }

    private void deleteEmployee() {
        System.out.print("Enter employee surname: ");
        String lastName = scanner.nextLine();
        for (Employee employee : employees) {
            if (employee.getSurname().equals(lastName)) {
                employees.remove(employee);
                System.out.println("Employee deleted.");
                return;
            }
        }
        System.out.println("Employee has not been found.");
    }

    private void searchEmployeeByLastName() {
        System.out.print("Enter surname for search: ");
        String searchLastName = scanner.nextLine();
        boolean found = false;
        for (Employee employee : employees) {
            if (employee.getSurname().startsWith(searchLastName)) {
                System.out.println(employee);
                found = true;
            }
        }
        if (!found) {
            System.out.println("Employee has not been found.");
        }
    }

    private void printAllEmployees() {
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }
}
