package ru.job4j.tracker;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item items = tracker.findById(id);
        if (tracker.delete(id)) {
            System.out.println("Order with id: " + id + " deleted");
            return true;
        } else {
            System.out.println("Not found id");
            return false;
        }
    }
}
