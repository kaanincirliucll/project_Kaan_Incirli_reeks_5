package ucll.be.services;

import org.springframework.stereotype.Service;
import ucll.be.model.Publication;
import ucll.be.repository.PublicationRepository;

import java.util.List;

@Service
public class PublicationService {

    private final PublicationRepository publicationRepository;

    public PublicationService(PublicationRepository publicationRepository) {
        this.publicationRepository = publicationRepository;
    }

    public List<Publication> findPublicationsByTitleAndType(String title, String type) {
        return publicationRepository.findPublicationsByTitleAndType(title, type);
    }
}
