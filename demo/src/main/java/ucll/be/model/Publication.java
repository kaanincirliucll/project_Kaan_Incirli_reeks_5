package ucll.be.model;

public abstract class Publication {
    private String title;
    private int publicationYear;

    public Publication(String title, int publicationYear) {
        setTitle(title);
        setPublicationYear(publicationYear);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Title is required.");
        }
        this.title = title;
    }

    public int getPublicationYear() {
        return publicationYear;
    }

    public void setPublicationYear(int publicationYear) {
        if (publicationYear <= 0) {
            throw new IllegalArgumentException("Publication year must be a positive integer.");
        }
        if (publicationYear > getCurrentYear()) {
            throw new IllegalArgumentException("Publication year cannot be in the future.");
        }
        this.publicationYear = publicationYear;
    }

    private int getCurrentYear() {
        // You can use a more sophisticated method to get the current year
        // This is just a simple example
        return java.time.Year.now().getValue();
    }
}
