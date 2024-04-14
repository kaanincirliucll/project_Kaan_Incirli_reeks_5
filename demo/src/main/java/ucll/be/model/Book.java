package ucll.be.model;

public class Book extends Publication {
    private String author;
    private String isbn;

    public Book(String title, String author, String isbn, int publicationYear, int availableCopies) {
        super(title, publicationYear, availableCopies);
        setAuthor(author);
        setIsbn(isbn);
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Author is required.");
        }
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        if (isbn == null || isbn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISBN is required.");
        }
        this.isbn = isbn;
    }
}