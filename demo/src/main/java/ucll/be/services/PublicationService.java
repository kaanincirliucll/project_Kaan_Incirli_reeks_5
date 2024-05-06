package ucll.be.services;

import org.springframework.stereotype.Service;

import ucll.be.model.*;
import ucll.be.repository.BookRepositoryJpa;
import ucll.be.repository.MagazineRepostitoryJpa;
import ucll.be.repository.PublicationRepositoryJpa;

import java.util.List;

@Service
public class PublicationService {

    private final PublicationRepositoryJpa publicationRepository;
    private MagazineRepostitoryJpa magazineRepository;
    private BookRepositoryJpa bookRepository;

    public PublicationService(PublicationRepositoryJpa publicationRepository, MagazineRepostitoryJpa magazineRepository,
            BookRepositoryJpa bookRepository) {
        this.publicationRepository = publicationRepository;
        this.magazineRepository = magazineRepository;
        this.bookRepository = bookRepository;
    }

    public List<Publication> findPublicationsByTitleAndType(String title, String type) {
        if (type == "magazinne") {
            return magazineRepository.findByTitleIgnoreCaseContaining(title);
        } else if (type == "book") {
            return bookRepository.findByTitleIgnoreCaseContains(title);
        } else {
            return publicationRepository.findByTitleIgnoreCaseContains(title);
        }

    }

    public List<Publication> findPublicationsByAvailableCopies(int availableCopies) {
        return publicationRepository.findByAvailableCopies(availableCopies);
    }
}
