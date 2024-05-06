package ucll.be.repository;

import ucll.be.model.Publication;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PublicationRepositoryJpa extends JpaRepository<Publication, Long> {

    List<Publication> findByTitleIgnoreCaseContains(String title);

    List<Publication> findByAvailableCopies(int availableCopies);

}
