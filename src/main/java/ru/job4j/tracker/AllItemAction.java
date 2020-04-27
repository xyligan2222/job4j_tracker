package ru.job4j.tracker;

public class AllItemAction implements UserAction {
    @Override
    public String name() {
        return "=== All Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] items = tracker.findAll();
        for (int index = 0; index < items.length; index++) {
            System.out.println("Order № " + (index + 1)
                    + " name: " + items[index].getName()
                    + " id: " + items[index].getId());
        }
        return true;
    }
}
