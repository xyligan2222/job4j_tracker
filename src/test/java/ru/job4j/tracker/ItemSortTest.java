package ru.job4j.tracker;

import org.junit.Test;

import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemSortTest {
    @SuppressWarnings("checkstyle:MethodName")
    @Test
    public void whenSortItem() {
        List<Item> items = List.of(
                new Item("Andrey"),
                new Item("Andrew"),
                new Item("Vadim"),
                new Item("Petr"),
                new Item("Alexey")
        );

        List<Item> check = List.of(
                items.get(4),
                items.get(1),
                items.get(0),
                items.get(3),
                items.get(2)
        );
        Collections.sort(items, new SortByName());
        assertThat(items, is(check));
    }

    @Test
    public void sortItemReverse() {
        List<Item> items = List.of(
                new Item("Andrey"),
                new Item("Andrew"),
                new Item("Vadim"),
                new Item("Petr"),
                new Item("Alexey")
        );

        List<Item> check = List.of(
                items.get(2),
                items.get(3),
                items.get(0),
                items.get(1),
                items.get(4)
        );
        Collections.sort(items, new SortByName().reversed());
        assertThat(items, is(check));
    }
}
