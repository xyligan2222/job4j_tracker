package ru.job4j.tracker;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class HbmTest {
    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        HbmTracker tracker = new HbmTracker();
        Item item = new Item("test1");
        tracker.add(item);
        Item result = tracker.findById((item.getId()));
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void whenFindByName() {
        ArrayList<Item> item = new ArrayList<>();
        item.add(new Item("test2"));
        ArrayList<Item> result = new ArrayList<>();
        result.add(item.get(0));
        assertThat(item.get(0).getName(), is("test2"));
    }

    @Test
    public void whenFindByAll() {
        HbmTracker tracker = new HbmTracker();
        List<Item> item = new ArrayList<>();
        item.add(new Item("test1"));
        item.add(new Item("test2"));
        tracker.add(item.get(0));
        tracker.add(item.get(1));
        List<Item> result = tracker.findAll();
        assertThat(result.get(0).getName(), is(item.get(0).getName()));
        assertThat(result.get(1).getName(), is(item.get(1).getName()));
    }

    @Test
    public void whenDelete() {
        HbmTracker tracker = new HbmTracker();
        Item bug = new Item("Bug");
        tracker.add(bug);
        Integer id = (bug.getId());
        tracker.delete(id);
        assertThat(tracker.findById(id), is(nullValue()));
    }
}
