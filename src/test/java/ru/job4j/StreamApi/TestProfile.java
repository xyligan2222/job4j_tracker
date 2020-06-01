package ru.job4j.StreamApi;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class TestProfile {
    @Test
    public void whenProfileToList() {
        List<Profile> input = List.of(
                new Profile(new Address("Madrid2", "Lenina", 8, 10)),
                new Profile(new Address("Madrid3", "Lenina", 9, 11)),
                new Profile(new Address("Madrid4", "Lenina", 18, 12)),
                new Profile(new Address("Madrid1", "Lenina", 22, 12)),
                new Profile(new Address("Madrid1", "Lenina", 22, 12))
        );

        List<Address> result = Profiles.collect(input);
        List<Address> expected = Arrays.asList(
                new Address("Madrid1", "Lenina", 22, 12),
                new Address("Madrid2", "Lenina", 8, 10),
                new Address("Madrid3", "Lenina", 9, 11),
                new Address("Madrid4", "Lenina", 18, 12)
        );
        assertThat(result, is(expected));
    }
}
