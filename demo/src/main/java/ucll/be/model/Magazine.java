package ucll.be.model;

public class Magazine extends Publication {
    private String editor;
    private String issn;

    public Magazine(String title, String editor, String issn, int publicationYear) {
        super(title, publicationYear);
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