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
                new Profile(new Address("Madrid", "Lenina", 8, 10)),
                new Profile(new Address("Madrid", "Lenina", 9, 11)),
                new Profile(new Address("Madrid", "Lenina", 18, 12)),
                new Profile(new Address("Madrid", "Lenina", 22, 12))
        );

        List<Address> result = Profile.collect(input);
        List<Address> expected = Arrays.asList(
                new Address("Madrid", "Lenina", 8, 10),
                new Address("Madrid", "Lenina", 9, 11),
                new Address("Madrid", "Lenina", 18, 12),
                new Address("Madrid", "Lenina", 22, 12)
        );
        assertThat(result, is(expected));
    }
}
