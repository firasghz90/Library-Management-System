public class LibraryService {
    private Book[] books;
    private int totalBooks;

    public LibraryService(int capacity) {
        this.books = new Book[capacity];
        this.totalBooks = 0;
    }

    public boolean addBook (String title, String author) {
        if (totalBooks >= books.length) {
            return false;
        }

        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return false;
            }
        }

        books[totalBooks] = new Book(title, author);
        totalBooks++;

        return true;
    }

    public boolean removeBook (String title) {
        if (totalBooks == 0) {
            return false;
        }

        int removeIndex = -1;
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
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
            return true;
        }
        return false;
    }

    public void displayBooks() {
        if (totalBooks == 0) {
            System.out.println("No books are available.");

        } else {
            System.out.println("Books in library: ");
            for (int i =0; i < totalBooks; i++) {
                System.out.println((i + 1) + ". " 
                    + books[i].getTitle() + " : " + books[i].getAuthor());
            }
        }
    }

    public Book searchBook(String title) {
        for (int i = 0; i < totalBooks; i++) {
            if (books[i].getTitle().equalsIgnoreCase(title)) {
                return books[i];
            }
        }
        return null;
    }

    public int getTotalBooks() {
        return totalBooks;
    }

    public int getAvailableSlots() {
        return books.length - totalBooks;
    }
}
