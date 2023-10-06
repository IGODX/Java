package org.example;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class Database  {
    private TreeMap<String, Person> personsRecords = new TreeMap<>();
    private TreeMap<String, Fine> finesRecords = new TreeMap<>();
    public Person addPerson(Person person) {
        return personsRecords.put(person.getId(), person);
    }
    public boolean addFine(String personId, Fine fine) {
        if (personsRecords.containsKey(personId)) {
            Person person = personsRecords.get(personId);
            finesRecords.put(fine.getId(),fine);
           return person.addFine(fine);
        }
        return false;
    }

    public Person getPerson(String id){
        return personsRecords.get(id);
    }
    public Fine getFine(String id){
        return finesRecords.get(id);
    }
    public Person deletePerson(String id) {
        Iterator<Map.Entry<String, Fine>> iterator = finesRecords.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Fine> entry = iterator.next();
            Fine fine = entry.getValue();
            if (fine.getPersonId().equals(id)) {
                iterator.remove();
            }
        }
        return personsRecords.remove(id);
    }
    public void printFinesByCity(String city){
        for (Fine fine : finesRecords.values())
            if (fine.getCity().equalsIgnoreCase(city))
                System.out.println(fine);
    }
    public void printFinesByType(String type){
        for (Fine fine : finesRecords.values())
            if (fine.getType().equalsIgnoreCase(type))
                System.out.println(fine);
    }
    public void printDatabase(){
        for(Person person : personsRecords.values()){
            System.out.println(person);
            var fines =  person.getFines();
            if(fines.size() > 0) {
                System.out.println("Fines : \n");
                for (Fine fine : fines)
                    System.out.println(fine);
            }
            System.out.println("************************************");
        }
    }
    public Fine deleteFine(String id){
        Iterator<Map.Entry<String, Person>> iterator = personsRecords.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Person> entry = iterator.next();
            Person person = entry.getValue();
            Iterator<Fine> finesIterator = person.getFines().iterator();
            while (finesIterator.hasNext()) {
                Fine fine = finesIterator.next();
                if (fine.getId().equals(id))
                    finesIterator.remove();
            }
        }
       return finesRecords.remove(id);
    }

    public TreeMap<String, Fine> getFinesRecords(){
        return finesRecords;
    }

    public TreeMap<String, Person> getPersonsRecords(){
        return personsRecords;
    }
}
