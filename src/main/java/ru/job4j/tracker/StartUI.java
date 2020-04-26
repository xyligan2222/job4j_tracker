package ru.job4j.tracker;



public class StartUI {
    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ====");
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        System.out.println("Order with the name : " + name + " created");
    }

    public static void showAllItem(Tracker tracker) {
        System.out.println("=== All Items ====");
        Item[] items = tracker.findAll();
        for (int index = 0; index < items.length; index++) {
            System.out.println("Order № " + (index + 1)
                    + " name: " + items[index].getName()
                    + " id: " + items[index].getId());
        }
    }

    public static boolean replaceItem(Input input, Tracker tracker) {
        boolean result = false;
        System.out.println("=== Edit Item ====");
        String id = input.askStr("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (item.getId().equals(id)) {
            tracker.replace(id, item);
            System.out.println("The order with id: " + id + " has been replaced");
            return result == true;
        } else {
            System.out.println("Not found id");
            return result;
        }

    }

    public static boolean deleteItem(Input input, Tracker tracker) {
        boolean result = false;
        System.out.println("=== Delete Item ====");
        String id = input.askStr("Enter id: ");
        Item items = tracker.findById(id);
        if (items.getId().equals(id)) {
            tracker.delete(id);
            System.out.println("Order with id: " + id + " deleted");
            return result == true;
        } else {
            System.out.println("Not found id");
            return result;
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find Item by id ====");
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(" Name: " + item.getName() + " id: " + item.getId());
        } else {
            System.out.println("No order with this id ");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find Item by name ====");
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        for (int index = 0; index < items.length; index++) {
            System.out.println("Order № " + (index + 1)
                    + " name: " + items[index].getName()
                    + " id: " + items[index].getId());
        }
    }
}

