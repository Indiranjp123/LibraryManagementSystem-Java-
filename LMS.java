import java.util.ArrayList;
import java.util.Scanner;
class Book {
    String title;
    String author;

    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }
}

public class LibraryManagementSystem {
    private ArrayList<Book> books;
    private Scanner scanner;

    public LibraryManagementSystem() {
        books = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void run() {
        while (true) {
            System.out.println("Library Management System");
            System.out.println("1. Add book");
            System.out.println("2. Remove book");
            System.out.println("3. List books");
            System.out.println("4. Search book");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    addBook();
                    break;
                case 2:
                    removeBook();
                    break;
                case 3:
                    listBooks();
                    break;
                case 4:
                    searchBook();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void addBook() {
        System.out.print("Enter book title: ");
        String title = scanner.next();
        System.out.print("Enter book author: ");
        String author = scanner.next();

        Book book = new Book(title, author);
        books.add(book);
        System.out.println("Book added successfully!");
    }

    private void removeBook() {
        System.out.print("Enter book title to remove: ");
        String title = scanner.next();

        for (Book book : books) {
            if (book.title.equals(title)) {
                books.remove(book);
                System.out.println("Book removed successfully!");
                return;
            }
        }
        System.out.println("Book not found.");
    }

    private void listBooks() {
        System.out.println("List of books:");
        for (Book book : books) {
            System.out.println(book.title + " by " + book.author);
        }
    }

    private void searchBook() {
        System.out.print("Enter book title or author to search: ");
        String query = scanner.next();

        for (Book book : books) {
            if (book.title.contains(query) || book.author.contains(query)) {
                System.out.println(book.title + " by " + book.author);
            }
        }
    }

    public static void main(String[] args) {
        LibraryManagementSystem system = new LibraryManagementSystem();
        system.run();
    }
