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
        System.out.println("Available slot: " + libraryService.getAvailableSlots());

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
                        break;
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
                    if (libraryService.getTotalBooks() == 0) {
                        System.out.println("There are no books in the library");
                        break;
                    }

                    System.out.print("Enter the book title to search: ");
                    String searchTitle = userInput.nextLine().trim();

                    if (searchTitle.isEmpty()) {
                        System.out.println("Search title cannot be blank.");
                        break;
                    
                    }

                    Book foundBook = libraryService.searchBook(searchTitle);
                    if (foundBook != null) {
                        System.out.println("Book found: " + foundBook.getTitle() + " : " + foundBook.getAuthor());
                    
                    } else {
                        System.out.println("Book not found.");
                    
                    }
                    break;

                case 4:
                    if (libraryService.getTotalBooks() == 0) {
                        System.out.println("There are no books to remove.");
                        break;
                    
                    }

                    System.out.print("Enter the title of the book to remove: ");
                    String removeTitle = userInput.nextLine().trim();

                    if (removeTitle.isEmpty()) {
                        System.out.println("Book title cannot be blank.");
                        break;

                    }

                    boolean isRemoved = libraryService.removeBook(removeTitle);

                    if (isRemoved) {
                        System.out.println("Book removed successfully!");
                        System.out.println("Available slots: " + libraryService.getAvailableSlots());

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

    private static void displayMenu() {
        System.out.println("\n==== Library Menu ====");
        System.out.println("1. View All Books");
        System.out.println("2. Add a Book");
        System.out.println("3. Search for a Book");
        System.out.println("4. Remove a Book");
        System.out.println("5. Exit");
    }
}
