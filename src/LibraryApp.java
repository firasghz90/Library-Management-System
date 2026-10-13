// Application Header

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Library Management System");
        System.out.println("================================");
        System.out.println("Version: 1.0");

        Book[] books = new Book[5];
        int totalBooks = 0;
        String libraryName = "City Library";

        System.out.println("Library name: " + libraryName);
        System.out.println("Total books: " + totalBooks);

        int availableSlots = getAvailableSlots(books, totalBooks);
        System.out.println("Available slot: " + availableSlots );

        System.out.println("Status: Initializing...");
        System.out.println("Welcome to Library!");


        System.out.print("Enter your name: ");
        String username = userInput.nextLine();
        System.out.println("Welcome, " + username + "!");


        Book book = new Book("Clean Code", "Robert C. Martin");
        try {
            book.setTitle("");
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.println(book.getTitle());

        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String input = userInput.nextLine();

            try {
                int userChoice = Integer.parseInt(input);
                switch (userChoice) {
                case 1:
                    displayBooks(books, totalBooks);
                    break;

                case 2:
                    if (totalBooks < books.length) {
                        System.out.print("Enter the book title: ");
                        String bookTitle = userInput.nextLine().trim();
                        if (bookTitle.isEmpty()) {
                            System.out.println("Book cannot be empty or blank. Try again.");
                            continue;
                        }

                        System.out.print("Enter the book author: ");
                        String bookAuthor = userInput.nextLine().trim();
                        if (bookAuthor.isEmpty()) {
                            System.out.println("Author cannot be empty of blank.Try again.");
                            continue;
                        }

                        boolean duplicateFound = false;
                        for (int i = 0; i < totalBooks; i++) {
                            String selectedBook = books[i].getTitle();
                            if (selectedBook.equalsIgnoreCase(bookTitle)) {
                                duplicateFound = true;
                                break;
                            } 
                        }

                        if (duplicateFound) {
                            System.out.println("Duplicated found. This books already exist in library.");
                            continue;
                        }

                        try {
                            books[totalBooks] = new Book(bookTitle, bookAuthor);
                            totalBooks++;

                            System.out.println("Book added successfully!");
                            System.out.println("Available slots: " + getAvailableSlots(books, totalBooks));
                        
                        } catch (IllegalArgumentException e) {
                            System.out.println(e.getMessage());

                        }

                        

                    } else {
                        System.out.println("The library is full!");

                    }
                    break;

                case 3:
                    if (totalBooks == 0) {
                        System.out.println("Sorry there is no books in the library.");
                        continue;

                    }

                    System.out.print("Enter the book title: ");
                    String searchTitle = userInput.nextLine().trim();
                    if (searchTitle.isEmpty()) {
                        System.out.println("Search Title cannot be empty or blank. Try again.");
                        continue;

                    }

                    boolean isBookFound = false;
                    for (int i = 0; i < totalBooks; i++) {
                        if (books[i].getTitle().equalsIgnoreCase(searchTitle)) {
                            isBookFound = true;
                            System.out.println("Book found: " + books[i].getTitle() + " : " + books[i].getAuthor());
                            break;

                        }
                    }

                    if (!isBookFound) System.out.println("Book not found.");
                    break;

                case 4:
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
                    break;

                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");

            }
        }
        
        userInput.close();
    }

    private static int getAvailableSlots(Book[] books, int totalBooks) {
        return books.length - totalBooks;
    }

    private static void displayBooks(Book[] books, int totalBooks) {
        if (totalBooks == 0) {
            System.out.println("No books is available");

        } else {
            System.out.println("Books in library: ");
            for (int i = 0; i < totalBooks; i++) {
                System.out.println((i + 1) + ". " 
                    + books[i].getTitle() + " : " + books[i].getAuthor());

            }
        }
    }

    private static void displayMenu() {
        System.out.println("\n==== Library Menu ====");
        System.out.println("1. View All Books");
        System.out.println("2. Add a Book");
        System.out.println("3. Search for a Book");
        System.out.println("4. Exit");
    }
}
