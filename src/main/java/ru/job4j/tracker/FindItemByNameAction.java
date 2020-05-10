package ru.job4j.tracker;

import java.util.List;

public class FindItemByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by name ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        for (int index = 0; index < items.size(); index++) {
            System.out.println("Order № " + (index + 1)
                    + " name: " + items.get(index).getName()
                    + " id: " + items.get(index).getId());
        }
        return true;
    }
}
