package ru.job4j.tracker.di;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.job4j.tracker.ConsoleInput;

public class SpringDI {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(Store.class);
        context.register(ConsoleInput.class);
        context.register(StartUI.class);
        context.refresh();
        StartUI ui = context.getBean(StartUI.class);
        ui.add("Petr");
        ui.add("Andrew");
        ui.add("Oleg");
        ui.add("Nikolay");
        ui.print();
    }
}
