package ru.job4j.tracker;

import java.util.*;

public class Tracker {
    private final Item[] items = new Item[100];
    private int position = 0;

    private String generateId() {
        Random rm = new Random();
        return String.valueOf(rm.nextLong() + System.currentTimeMillis());
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }
    public Item[] findAll(){
        Item[] namesWithoutNull = new Item[items.length];
        int size = 0;
        for (int index = 0; index < items.length; index++) {
            Item name = items[index];
            if (name != null) {
                namesWithoutNull[size] = name;
                size++;
            }
        }
        return Arrays.copyOf(namesWithoutNull, size);
    }

    public Item findById(String id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public Item[] findByName(String key) {
        Item[] result = new Item[position];
        int count = 0;
        for(int i = 0; i < position; i++) {
            if (items[i].getName().equals(key)) {
                result[count++] = items[i];

            }
        }

        return result;
    }
    public boolean replace(String id, Item item) {
        int index = indexOf(id);
        boolean result = false;
        if (index >= 0) {
            item.setId(id);
            items[index] = item;
            result = true;
        }
        return result;
    }

    private int indexOf(String id) {
        int result = -1;
        for (int index = 0; index < position; index++) {
            if (items[index].getId().equals(id)) {
                result = index;
                break;
            }
        }
        return result;
    }





}