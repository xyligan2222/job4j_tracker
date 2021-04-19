package ru.job4j.tracker;

import java.util.*;

public class MemTracker {
    private final List<Item> items = new ArrayList<>();
    private int position = 0;

    private Integer generateId() {
        Random rm = new Random();
        return Math.toIntExact(rm.nextLong() + System.currentTimeMillis());
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items.add(item);
        return item;
    }
    public List<Item> findAll() {
        return items;
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items.get(index) : null;
    }

    public List<Item> findByName(String key) {
        List<Item> result = new ArrayList<>();
        for (Item index : items) {
            if (index.getName().equals(key)) {
                result.add(index);
            }
        }
        return result;
    }

    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean result = false;
                if (index >= 0) {
                    item.setId(items.get(index).getId());
                    items.set(index, item);
                    result = true;
                }
        return result;
    }

    private int indexOf(String id) {
        int result = -1;
        for (int index = 0; index < position; index++) {
            if (items.get(index).getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }
    public boolean delete(String id) {
        int index = indexOf(id);
        boolean result = false;
        items.remove(index);
    return result;
    }





}