package ru.job4j.tracker;


import java.util.ArrayList;
import java.util.List;

public class StartUI {
    public void init(Input input, Store memtracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ", actions.size());
            UserAction action = actions.get(select);
            run = action.execute(input,  memtracker);
        }
    }

    private void showMenu(List<UserAction> actions) {
        System.out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            System.out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        Input input = new ConsoleInput();
        Input validate = new ValidateInput(input);
        try (Store memtracker = new HbmTracker()) {
            //memtracker.init();
            List<UserAction> actions = new ArrayList<>();
            actions.add(new AllItemAction());
            actions.add(new CreateAction());
            actions.add(new DeleteAction());
            actions.add(new FindItemByIdAction());
            actions.add(new FindItemByNameAction());
            actions.add(new ReplaceAction());
            actions.add(new ExitAction());

            new StartUI().init(validate, memtracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}


