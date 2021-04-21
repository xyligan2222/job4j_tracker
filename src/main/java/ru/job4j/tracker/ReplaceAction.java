package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit Item ====";
    }

    @Override
    public boolean execute(Input input, Store memtracker) {
        System.out.println("=== Edit Item ====");
        Integer id = input.askInt("Enter id: ");
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        if (memtracker.replace(id, item)) {
            System.out.println("The order with id: " + id + " has been replaced");
            return false;
        } else {
            System.out.println("Not found id");
            return true;
        }
    }

}
