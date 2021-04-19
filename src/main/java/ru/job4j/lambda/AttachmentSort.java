package ru.job4j.lambda;


import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class AttachmentSort {
    public static void main(String[] args) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        Comparator<Attachment> sizeCmp = Comparator.comparingInt(Attachment::getSize);
        attachments.sort(sizeCmp);
        System.out.println(attachments);

        Comparator<Attachment> nameCmp = Comparator.comparing(Attachment::getName);
        attachments.sort(nameCmp);
        System.out.println(attachments);

    }
}