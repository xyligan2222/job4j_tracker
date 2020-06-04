package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;


import static org.hamcrest.Matchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class DiapasonTest {
    @Test
    public void whenLinearFunctionThenLinearResults() {
        Diapason func = new Diapason();
        List<Double> result = func.diapason(5, 7, x -> 2 * x + 1);
        List<Double> expected = List.of(11D, 13D, 15D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenQuadroFunctionThenQuadroResults() {
        Diapason func = new Diapason();
        List<Double> result = func.diapason(2, 4, x -> x * x + 1);
        List<Double> expected = List.of(5D, 10D, 17D);
        assertThat(result, is(expected));
    }
    @Test
    public void whenExpFunctionThenExpResults() {
        Diapason func = new Diapason();
        List<Double> result = func.diapason(2, 4, x -> Math.pow(x, 3));
        List<Double> expected = List.of(8D, 27D, 64D);
        assertThat(result, is(expected));
    }
}
