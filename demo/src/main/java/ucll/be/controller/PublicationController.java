package ucll.be.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ucll.be.model.Publication;
import ucll.be.services.PublicationService;

import java.util.List;

@RestController
public class PublicationController {

    private PublicationService publicationService;

    public PublicationController(PublicationService publicationService) {
        this.publicationService = publicationService;
    }

    @GetMapping("/publications")
    public List<Publication> getPublications(
            @RequestParam(required = false) String title,
            @RequestParam(required = false) String type) {
        return publicationService.findPublicationsByTitleAndType(title, type);
    }
}
