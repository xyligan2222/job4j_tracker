package ru.job4j.StreamApi;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Profile {
    private Address address;

    public static List<Address> collect(List<Profile> profiles) {
    return profiles.stream().map((n) -> n.getAddress()).collect(Collectors.toList());
    }

    public Profile(Address address) {
        this.address = address;
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) return false;
        Profile profile = (Profile) o;
        return Objects.equals(address, profile.address);
    }

    @Override
    public String toString() {
        return "Profile{"
                + "address=" + address + '}';
    }
}

