package ru.job4j.tracker;


import org.junit.Test;
import ru.job4j.pojo.License;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class LicenseTest {

    @Test
    public void eqName() {
        License first = new License();
        first.setCode("audio");
        License second = new License();
        second.setCode("audio");
        assertThat(first, is(second));
    }

}