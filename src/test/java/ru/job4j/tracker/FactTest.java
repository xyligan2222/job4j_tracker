package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.ex.Fact;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class FactTest {

    @Test (expected = IllegalArgumentException.class)
    public void whenFactLessNull() {
        int rsl = Fact.calc(-6);
    }
    @Test
    public void whenFactPositive() {
        int rsl = Fact.calc(5);
        assertThat(rsl, is(120));
    }
}
