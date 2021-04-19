package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class AttachmentCmp {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 4", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> comparator = (left, right) -> {
            System.out.println("compare - " + left.getName() + " : " + right.getName());
            return left.getName().compareTo(right.getName());
        };
        attachments.sort(comparator);
        System.out.println(attachments);

        String[] names = {
                "Ivan",
        };
        Comparator<String> lengthCmp = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names, lengthCmp);

        String[] names1 = {
                "Ivan",
                "Petr"
        };
        Comparator<String> lengthCmp1 = (left, right) -> {
            System.out.println("execute comparator");
            return left.length() - right.length();
        };
        Arrays.sort(names1, lengthCmp1);
    }
}
