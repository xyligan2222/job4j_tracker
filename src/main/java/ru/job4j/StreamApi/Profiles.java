package ru.job4j.StreamApi;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public static List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream().map((n) -> n.getAddress()).collect(Collectors.toList());
        return result.stream().sorted(Comparator.comparing(Address::getCity)).distinct().collect(Collectors.toList());
    }

}
