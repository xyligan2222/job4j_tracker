package ru.job4j.ex;

import java.lang.Exception;

public class ElementNotFoundException extends Exception {
    public  ElementNotFoundException (String message) {
        super(message);
    }
    public static class FindEl {
        public static int indexOf(String[] value, String key) throws ElementNotFoundException {
            int rsl = 0;

            for (String check : value) {
                if (key.equals(check)) {
                    break;
                }
                rsl++;
            }
            if (rsl == 0) {
                throw new ElementNotFoundException("array doesn't contains \"key\"");

            }
            return rsl;
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println("index number: " + FindEl.indexOf(new String[] {"Vasya", null, null, null, "Petya", "Petya"}, "Petya"));
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }

    }

}

