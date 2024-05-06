package ucll.be.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import ucll.be.model.Magazine;

@Component
public class DbInitializer {

    private PublicationRepositoryJpa publicationRepositoryJpa;
    private BookRepositoryJpa bookRepositoryJpa;
    private UserRepositoryJpa userRepositoryJpa;
    private MagazineRepostitoryJpa magazineRepostitoryJpa;

    // TODO Initializing this gives an error the DB doesnt get set
    @Autowired
    public DbInitializer(MagazineRepostitoryJpa magazineRepostitoryJpa, BookRepositoryJpa bookRepositoryJpa,
            UserRepositoryJpa userRepositoryJpa, PublicationRepositoryJpa publicationRepositoryJpa) {
        this.publicationRepositoryJpa = publicationRepositoryJpa;
        this.bookRepositoryJpa = bookRepositoryJpa;
        this.magazineRepostitoryJpa = magazineRepostitoryJpa;
        this.userRepositoryJpa = userRepositoryJpa;
    }

    @PostConstruct
    public void initialize() {
        magazineRepostitoryJpa.save(new Magazine("jcomprendspas", "PNL", "tbzfrere", 2011, 12));
    }
}
