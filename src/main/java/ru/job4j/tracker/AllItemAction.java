package ru.job4j.tracker;

import java.util.List;

public class AllItemAction implements UserAction {
    @Override
    public String name() {
        return "=== All Items ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        List<Item> items = tracker.findAll();
        for (int index = 0; index < items.size(); index++) {
            System.out.println("Order № " + (index + 1)
                    + " name: " + items.get(index).getName()
                    + " id: " +     items.get(index).getId());
        }
        return true;
    }
}
