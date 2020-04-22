package ru.job4j.tracker;

import java.util.Scanner;

public class StartUI {
    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.add(item);
                System.out.println("Order with the name : " + name + " created");
            } else if (select == 1) {
                System.out.println("=== All Items ====");
                Item[] items = tracker.findAll();
                for (int index = 0; index < items.length; index++) {
                    System.out.println("Order № " + (index + 1)
                            + " name: " + items[index].getName()
                            + " id: " + items[index].getId());
                }
            } else if (select == 2) {
                System.out.println("=== Edit Item ====");
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                System.out.print("Enter new name: ");
                String name = scanner.nextLine();
                Item item = new Item(name);
                tracker.replace(id, item);
                System.out.println("The order with id: " + id + " has been replaced");
            } else if (select == 3) {
                System.out.println("=== Delete Item ====");
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                tracker.delete(id);
                System.out.println("Order with id: " + id + " deleted");
            } else if (select == 4) {
                System.out.println("=== Find Item by id ====");
                System.out.print("Enter id: ");
                String id = scanner.nextLine();
                Item item = tracker.findById(id);
                if (item != null) {
                    System.out.println(" Name: " + item.getName() + " id: " + item.getId());
                } else {
                    System.out.println("No order with this id ");
                }
            } else if (select == 5) {
                System.out.println("=== Find Item by name ====");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item[] items = tracker.findByName(name);
                for (int index = 0; index < items.length; index++) {
                    System.out.println("Order № " + (index + 1)
                            + " name: " + items[index].getName()
                            + " id: " + items[index].getId());
                }
            } else if (select == 6) {
                run = false;
            }
        }
    }

    private void showMenu() {
        System.out.println("Menu.");
        System.out.println("0. Add new Item");
        System.out.println("1. Show all items");
        System.out.println("2. Edit item");
        System.out.println("3. Delete item");
        System.out.println("4. Find item by Id");
        System.out.println("5. Find items by name");
        System.out.println("6. Exit Program");
        System.out.print("Select: ");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
