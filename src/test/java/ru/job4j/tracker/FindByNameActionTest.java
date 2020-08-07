package ru.job4j.tracker;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.StringJoiner;

import org.junit.Test;
import static org.junit.Assert.assertThat;
import static org.hamcrest.core.Is.is;

public class FindByNameActionTest {

    @Test
    public void whenCheckOutputName() {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        PrintStream stdOut = System.out;
        System.setOut(new PrintStream(out));
        MemTracker tracker = new MemTracker();
        Item item = new Item("fix bug");
        tracker.add(item);
        FindItemByNameAction action = new FindItemByNameAction();
        action.execute(new StubInput(new String[] {"fix bug"}), (Store) tracker);
        String expect = new StringJoiner(System.lineSeparator(), "", System.lineSeparator())
                .add("Order № 1"
                        + " name: " + item.getName()
                        + " id: " + item.getId()
                )
                .toString();
        assertThat(new String(out.toByteArray()), is(expect));
        System.setOut(stdOut);
    }
}