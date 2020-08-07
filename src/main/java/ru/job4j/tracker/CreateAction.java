package ru.job4j.tracker;

public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    @Override
    public boolean execute(Input input, Store memtracker) {
        String name = input.askStr("Enter new name: ");
        Item item = new Item(name);
        memtracker.add(item);
        return true;
    }


}
