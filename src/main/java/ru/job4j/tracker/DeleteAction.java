package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Store memtracker) {
        String id = input.askStr("Enter id: ");
        List<Item> items = new ArrayList<>();
        if (memtracker.delete(id)) {
            System.out.println("Order with id: " + id + " deleted");
            return true;
        } else {
            System.out.println("Not found id");
            return false;
        }
    }


}
