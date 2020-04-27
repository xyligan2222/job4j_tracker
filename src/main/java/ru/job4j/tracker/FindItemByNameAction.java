package ru.job4j.tracker;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        for (int index = 0; index < items.length; index++) {
            System.out.println("Order № " + (index + 1)
                    + " name: " + items[index].getName()
                    + " id: " + items[index].getId());
        }
        return true;
    }
}
