package ru.job4j.pojo;



public class Library {
    public static void main(String[] args) {
        Book book = new Book("Clean code", 100);
        Book book1 = new Book("Avraam", 1000);
        Book book2 = new Book("Migel", 900);
        Book book3 = new Book("Java first", 800);

        Book[] library = new Book[4];
        library[0] = book;
        library[1] = book1;
        library[2] = book2;
        library[3] = book3;
        for (int i = 0; i <library.length ; i++) {
            Book out = library[i];
            System.out.println(out.getName() + " - " + out.getCount());
        }

        System.out.println("Shown only book Clean code");

        for (int i = 0; i <library.length ; i++) {
            Book out = library[i];
          if (out.getName().equals("Clean code")){
              System.out.println(out.getName() + " - " + out.getCount());
          }
        }
    }
}
