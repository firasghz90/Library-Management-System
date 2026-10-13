// Application Header

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Library Management System");
        System.out.println("================================");

        System.out.println("Version: 1.0");

        String[] books = new String[5];
        int totalBooks = 0;
        String libraryName = "City Library";

        System.out.println("Library name: " + libraryName);
        System.out.println("Total books: " + totalBooks);

        System.out.println("Status: Initializing...");
        System.out.println("Welcome to Library!");


        System.out.print("Enter your name: ");
        String username = userInput.nextLine();
        System.out.println("Welcome, " + username + "!");

        boolean isRunning = true;
        while (isRunning) {
            System.out.println("\n==== Library Menu ====");
            System.out.println("1. View All Books");
            System.out.println("2. Add a Book");
            System.out.println("3. Search for a Book");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            String input = userInput.nextLine();

            try {
                int userChoice = Integer.parseInt(input);
                switch (userChoice) {
                case 1:
                    if (totalBooks == 0) {
                        System.out.println("No Books is available");

                    } else {
                        System.out.println("Books in library: ");
                        for (int i = 0; i < totalBooks; i++) {
                            System.out.println((i + 1) + ". " + books[i]);

                        }
                    }
                    break;

                case 2:
                    if (totalBooks < books.length) {
                        System.out.print("Enter the book title: ");
                        String bookTitle = userInput.nextLine().trim();
                        if (bookTitle.isEmpty()) {
                            System.out.println("Book cannot be empty or blank. Try again.");
                            continue;
                        }

                        books[totalBooks] = bookTitle;
                        totalBooks++;
                        System.out.println("Book added successfully!");

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
                        if (books[i].equalsIgnoreCase(searchTitle)) {
                            isBookFound = true;
                            System.out.println("Book found: " + books[i]);
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
}
