package ru.job4j.lambda;


import org.junit.Test;


import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static junit.framework.TestCase.assertEquals;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;


public class SearchAttTest {
    @Test
    public void isTrue() {
        Predicate<Attachment> predicate = new Predicate<Attachment>() {
            @Override
            public boolean test(Attachment attachment) {
                return attachment.getName().contains("Bug") || attachment.getSize() > 100;
            }
        };
        List<Attachment> input = List.of(
                new Attachment("image 1", 101),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13));
        List<Attachment> expected = List.of(
                new Attachment("image 1", 101));
        List<Attachment> result = SearchAtt.filter2(predicate, input);
        assertTrue(expected.equals(result));
    }
}
