package com.example.demo.model;

public class Magazine {
    private String title;
    private String editor;
    private String issn;
    private int publicationYear;

    public Magazine(String title, String editor, String issn, int publicationYear) {
        setTitle(title);
        setEditor(editor);
        setIssn(issn);
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

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        if (editor == null || editor.trim().isEmpty()) {
            throw new IllegalArgumentException("Editor is required.");
        }
        this.editor = editor;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        if (issn == null || issn.trim().isEmpty()) {
            throw new IllegalArgumentException("ISSN is required.");
        }
        this.issn = issn;
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
