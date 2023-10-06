package org.example;

import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    enum Priority {
        admin,
        user,

        vip
    }
    public static void main(String[] args) {
        // Вопрос, можно ли как-то выводить все значения ArrayList в одну строчку? Как toString(), только для коллекции.
        Scanner scanner = new Scanner(System.in);
        int tasks = 1;
        do {
            System.out.println("Enter task number : (Enter 0 to stop)");
            tasks = scanner.nextInt();
            switch (tasks) {
                case 1: {
                    int innerTask = 1;
                    ArrayList<Number> list = new ArrayList<>();
                    for (int i = 0; i<3; i++) {
                        System.out.println("Enter number to fill array :");
                        list.add(scanner.nextInt());
                    }
                    do {
                        System.out.println("Enter inner task number : (Enter 0 to stop)");
                        innerTask = scanner.nextInt();
                        switch (innerTask) {
                            case 1: {
                                System.out.println("Enter number that you want to add:");
                                list.add(scanner.nextInt());
                            }
                            break;
                            case 2: {
                                System.out.println("Enter index of element that you want to delete :");
                                int index = scanner.nextInt();
                                try {
                                     list.remove(index);
                                }
                                catch (IndexOutOfBoundsException ex){
                                    System.out.println("Index is out of bounds!");
                                }
                            }
                            break;
                            case 3: {
                                for(int i = 0; i<list.size(); i++)
                                    System.out.print(list.get(i) + " ");
                                System.out.println();
                            }
                            break;
                            case 4: {
                                int element = scanner.nextInt();
                                list.contains(element);
                            }
                            break;
                            case 5: {
                                System.out.println("Enter index of element that you want to change :");
                                int index = scanner.nextInt();
                                System.out.println("Enter new element :");
                                int element = scanner.nextInt();
                                try {
                                    list.set(index, element);
                                }
                                catch (IndexOutOfBoundsException ex){
                                    System.out.println("Index is out of bounds!");
                                }
                            }
                            break;
                        }
                    }while (innerTask>0);
                }
                break;
                case 2: {
                    ArrayList<User> users = new ArrayList<>();
                    int innerTask = 1;
                    do {
                        System.out.println("Enter inner task number : (Enter 0 to stop)");
                        innerTask = scanner.nextInt();
                        switch (innerTask) {
                            case 1: {
                                System.out.println("Adding new user...");
                                users.add(new User("userName", "password"));
                            }
                            break;
                            case 2: {
                                System.out.println("Enter index of element that you want to delete :");
                                int index = scanner.nextInt();
                                try {
                                    users.remove(index);
                                }
                                catch (IndexOutOfBoundsException ex){
                                    System.out.println("Index is out of bounds!");
                                }
                            }
                            break;
                            case 3: {
                                for(int i = 0; i<users.size(); i++)
                                    System.out.println(users.get(i));
                            }
                            break;
                            case 4: {
                                System.out.println(users.contains(new User("userName", "password")));
                            }
                            break;
                            case 5: {
                                users.set(0, new User("newUsername", "newPassword"));
                            }
                            break;
                        }
                    }while (innerTask>0);
                }
                break;
                case 3: {
                    Queue<Client> queue = new PriorityQueue<>((c1,c2)-> c1.getPriority() - c2.getPriority());
                    Queue<History> log = new LinkedList<>();
                    queue.add(new Client("user1", 3));
                    queue.add(new Client("user3", 0));
                    queue.add(new Client("user2", 1));
                    queue.add(new Client("user4", 2));
                        while (!queue.isEmpty()) {
                            Client client = queue.poll();
                            System.out.println("Client :  " + client.getUserName() + " (priority " + client.getPriority() + ")");
                            log.add(new History(client.getUserName(), client.getDate(), client.getPriority()));
                        }
                    for (History entry : log) {
                        System.out.println(entry);
                    }
                }
                break;
                default: System.out.println("Ending program...");
            }
        }while (tasks > 0);
    }
}