// Application Header

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Library Management System");
        System.out.println("================================");
        System.out.println("Version: 1.0");

        LibraryService libraryService = new LibraryService(5);
        String libraryName = "City Library";

        System.out.println("Library name: " + libraryName);
        System.out.println("Total books: " + libraryService.getTotalBooks());

        int availableSlots = libraryService.getAvailableSlots();
        System.out.println("Available slot: " + availableSlots );

        System.out.println("Status: Initializing...");
        System.out.println("Welcome to Library!");


        System.out.print("Enter your name: ");
        String username = userInput.nextLine();
        System.out.println("Welcome, " + username + "!");

        boolean isRunning = true;
        while (isRunning) {
            displayMenu();
            System.out.print("Enter your choice: ");
            String input = userInput.nextLine();

            try {
                int userChoice = Integer.parseInt(input);
                switch (userChoice) {
                case 1:
                    libraryService.displayBooks();
                    break;

                case 2:
                    System.out.print("Enter the book title: ");
                    String bookTitle = userInput.nextLine().trim();

                    if (bookTitle.isEmpty()) {
                        System.out.println("Book title cannot be blank.");
                        break;
                        
                    }

                    System.out.print("Enter the book author: ");
                    String bookAuthor = userInput.nextLine().trim();

                    if (bookAuthor.isEmpty()) {
                        System.out.println("Author cannot be blank.");

                    }
                    
                    try {
                        boolean isAdded = libraryService.addBook(bookTitle, bookAuthor);
                        if (isAdded) {
                            System.out.println("Book added successfully.");
                            System.out.println("Available slots: " + libraryService.getAvailableSlots());

                        } else {
                            System.out.println("Book could not be added. The library is maybe full or the title may already exist.");

                        }
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());

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
                    if (totalBooks == 0) {
                        System.out.println("There are no books to remove");
                        break;
                    }

                    System.out.print("Enter the title of the book to remove: ");
                    String removeTitle = userInput.nextLine().trim();

                    int removeIndex = -1;
                    for (int i = 0; i < totalBooks; i++) {
                        if (books[i].getTitle().equalsIgnoreCase(removeTitle)) {
                            removeIndex = i;
                            break;
                        }
                    }

                    if (removeIndex != -1) {
                        for (int i = removeIndex; i < totalBooks - 1; i++) {
                            books[i] = books[i + 1];
                        }

                        books[totalBooks - 1] = null;
                        totalBooks--;
                        System.out.println("Book removed successfully!");

                    } else {
                        System.out.println("Book not found.");

                    }
                    break;

                case 5:
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
        System.out.println("4. Remove a Book");
        System.out.println("5. Exit");
    }
}
