// Application Header

import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("Library Management System");
        System.out.println("================================");

        System.out.println("Version: 1.0");

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

            System.out.println("Enter your choice: ");
            int userChoice = userInput.nextInt();

            switch (userChoice) {
                case 1:
                    System.out.println("Viewing all books...");
                    break;
                case 2:
                    System.out.println("Adding a book...");
                    break;
                case 3:
                    System.out.println("Searching for a book...");
                    break;
                case 4:
                    System.out.println("Goodbye!");
                    isRunning = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
                    break;
            }
        }


        userInput.close();
    }
}
