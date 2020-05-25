package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.UnaryOperator;

public class SearchAtt {

    public static List<Attachment> filterSize(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filterName(List<Attachment> list) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : list) {
            if (att.getName().contains("bug")) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter2(Predicate<Attachment> filter1) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : rsl) {
            if (filter1.test(att)) {
                rsl.add(att);
            }
        }
        return rsl;
    }

    public static List<Attachment> filter(Predicate<Attachment> filter1) {
        List<Attachment> rsl = new ArrayList<>();
        for (Attachment att : rsl) {
            if (att.getName().contains("bug") || att.getSize() > 100) {
                rsl.add(att);
            }
        }
        return rsl;
    }

}
