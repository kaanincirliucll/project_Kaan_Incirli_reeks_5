package ucll.be.model;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("magazine")
public class Magazine extends Publication {

    private String issn;
    private String editor;

    public Magazine(String title, String editor, String issn, int publicationYear, int availableCopies) {
        super(title, publicationYear, availableCopies);
        setEditor(editor);
        setIssn(issn);
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
}