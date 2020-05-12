package ru.job4j.collection;

import java.util.HashMap;
import java.util.Map;

public class UsageMap {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>();
        map.put("Petr@yandex.ru", "Петр Арсентьев");
        map.put("Andrew@mail.ru", "Андрей Широков");
        for (Map.Entry<String, String> entry : map.entrySet()) {
        String key = entry.getKey();
        String value = entry.getValue();
            System.out.println("email: " + key + ", name and surname: " + value);
        }
    }
}
