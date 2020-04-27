package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by id ====";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String id = input.askStr("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(" Name: " + item.getName() + " id: " + item.getId());
        } else {
            System.out.println("No order with this id ");
        }
        return true;
    }
}
