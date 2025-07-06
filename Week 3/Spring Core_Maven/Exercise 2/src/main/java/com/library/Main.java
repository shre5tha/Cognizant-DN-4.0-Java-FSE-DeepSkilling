package com.library;
import com.library.service.BookService;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BookService bookService = (BookService) context.getBean("bookService");

        Scanner sc = new Scanner(System.in);
        System.out.println("Which book to add in repository? ");
        String name = sc.nextLine();
        bookService.addBook(name);

        context.close();
    }
}
