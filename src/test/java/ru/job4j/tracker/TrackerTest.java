package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class TrackerTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById(String.valueOf(item.getId()));
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindByName() {
        MemTracker tracker = new MemTracker();
        ArrayList<Item> item = new ArrayList<>();
        item.add(new Item("test2"));
        ArrayList<Item> result = new ArrayList<>();
        result.add(item.get(0));
        assertThat(item.get(0), is("test2"));
    }

    @Test
    public void whenFindByAll() {
        MemTracker tracker = new MemTracker();
        ArrayList<Item> item = new ArrayList<>();
        item.add(new Item("test1"));
        item.add(new Item("test2"));
        tracker.add(item.get(0));
        tracker.add(item.get(1));
        List<Item> result = tracker.findAll();
        assertThat(result, is(item));

    }

    @Test
    public void whenDelete() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        String id = String.valueOf(bug.getId());
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}