package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    public ArrayList<Person> find(String key) {
        Predicate<Person> name = nam -> nam.getName().contains(key);
        Predicate<Person> surName = surNam -> surNam.getSurname().contains(key);
        Predicate<Person> phone = phon -> phon.getPhone().contains(key);
        Predicate<Person> address = addres -> addres.getAddress().contains(key);
        Predicate<Person> combine = n -> name.or(surName).or(phone).or(address).test(n);
        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (combine.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
