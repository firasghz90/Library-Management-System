public class Book {
    private String title;
    private String author;

    public Book(String title, String author) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }

        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be blank.");
        }

        this.title = title.trim();
        this.author = author.trim();
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title cannot be blank.");
        }
        this.title = title.trim();
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author cannot be blank.");
        }
        this.author = author.trim();
    }
}
