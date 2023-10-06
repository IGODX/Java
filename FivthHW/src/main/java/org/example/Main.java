package org.example;

import javax.print.Doc;
import java.util.Date;
import java.util.Random;
import java.util.function.Function;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        runFirstTask();
//    runSecondTask();
//    runThirdTask();
    }

    public static void runFirstTask(){
        DockStation station = new DockStation(10, 20);
        Random random = new Random();
            for(int i = 0; i<10; i++) {
                int numberOfPassengers = random.nextInt(20);
                station.passengersEnterTheBoat(i, numberOfPassengers);
                station.passengersLeaveTheBoat(i);
            }
            for(int i = 0; i<10; i++) {
                station.endStop();
            }
    }
    public static void runSecondTask(){
        Dictionary dictionary = new Dictionary();
        dictionary.addWordWithTranslation("Lamp", "Лампа");
        System.out.println(dictionary.translateWord("Lamp"));
        System.out.println(dictionary.translateWord("Lamp"));
        System.out.println(dictionary.translateWord("Lamp"));
        System.out.println(dictionary.translateWord("Hello"));
        System.out.println(dictionary.translateWord("Hello"));
        System.out.println("Top ten most searched words :\n" + dictionary.getTopTenMostSearchedWords());
        System.out.println("Top ten least searched words :\n" + dictionary.getTopTenLeastSearchedWords());
        System.out.println(dictionary.changeTranslation("Lamp", "Не лампа"));
        System.out.println(dictionary.translateWord("Lamp"));
        System.out.println("Changing translation on word Roof, new value is \"Не крыша\" : "+dictionary.changeTranslation("Roof", "Не крыша"));
        System.out.println("Changing word Lamp to Bulb : "+dictionary.changeWord("Lamp", "Bulb"));
        System.out.println("Translating word Lamp : "+dictionary.translateWord("Lamp"));
        System.out.println("Translating word Bulb : "+dictionary.translateWord("Bulb"));
    }
    public static void runThirdTask(){
        Database database = new Database();
        database.addPerson(new Person("1", "Firstname1", "Surname1"));
        database.addPerson(new Person("2", "Firstname2", "Surname2"));
        database.addPerson(new Person("3", "Firstname3", "Surname3"));
        database.addPerson(new Person("4", "Firstname4", "Surname4"));
        database.addFine("1", new Fine("1", "1", "Parking", 50, "Kriviy Rih", new Date()));
        database.addFine("1", new Fine("2", "1","Running a red light ", 50, "Kriviy Rih", new Date()));
        database.addFine("2", new Fine("3", "2","Parking", 50, "Kiev", new Date()));
        database.addFine("2", new Fine("4", "2","Car accident ", 50, "Kiev", new Date()));

       System.out.println("Fines from Kriviy Rih :\n");
        database.printFinesByCity("Kriviy Rih");
       System.out.println("Fines from Kiev :\n");
       database.printFinesByCity("Kiev");
       System.out.println("Printing fines by type Parking :\n");
      database.printFinesByType("Parking");

        Person person = database.getPerson("1");
        person.setFirstName("NEW PERSON");
        System.out.println("***********************************");
        database.printDatabase();

    }
}