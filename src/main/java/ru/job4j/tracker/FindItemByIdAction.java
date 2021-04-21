package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item by id ====";
    }

    @Override
    public boolean execute(Input input, Store memtracker) {
        String id = input.askStr("Enter id: ");
        Item item = memtracker.findById(Integer.valueOf(id));
        if (item != null) {
            System.out.println(String.format(" Name: %s, id: %s", item.getName(), item.getId()));
        } else {
            System.out.println("No order with this id ");
        }
        return true;
    }
}
