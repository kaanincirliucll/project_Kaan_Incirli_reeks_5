package ucll.be.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import ucll.be.model.*;

@Repository
public class PublicationRepository {
    private List<Book> books;
    private List<Magazine> magazines;

    public PublicationRepository() {
        books = new ArrayList<>();
        books.add(new Book("Java Programming", "John Doe", "123456789", 2022));
        books.add(new Book("Spring Boot in Action", "Jane Smith", "987654321", 2021));

        magazines = new ArrayList<>();
        magazines.add(new Magazine("National Geographic", "Editor A", "NG123", 2022));
        magazines.add(new Magazine("Time Magazine", "Editor B", "TM456", 2022));
    }

    public List<Publication> findPublicationsByTitleAndType(String title, String type) {
        if (title == null && type == null) {
            // Return all publications if no filters applied
            List<Publication> allPublications = new ArrayList<>();
            allPublications.addAll(books);
            allPublications.addAll(magazines);
            return allPublications;
        } else {
            List<Publication> filteredPublications = new ArrayList<>();
            if (title != null) {
                filteredPublications.addAll(findByTitle(title));
            }
            if (type != null) {
                filteredPublications.addAll(findByType(type));
            }
            return filteredPublications;
        }
    }

    private List<Publication> findByTitle(String title) {
        List<Publication> allPublications = new ArrayList<>();
        allPublications.addAll(books);
        allPublications.addAll(magazines);

        return allPublications.stream()
                .filter(publication -> publication.getTitle().toLowerCase().contains(title.toLowerCase()))
                .collect(Collectors.toList());
    }

    private List<Publication> findByType(String type) {
        if (type.equalsIgnoreCase("Book")) {
            return new ArrayList<>(books);
        } else if (type.equalsIgnoreCase("Magazine")) {
            return new ArrayList<>(magazines);
        } else {
            return new ArrayList<>();
        }
    }
}