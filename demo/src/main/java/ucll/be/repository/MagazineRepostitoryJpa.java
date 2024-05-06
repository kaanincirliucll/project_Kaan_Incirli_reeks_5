package ucll.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucll.be.model.*;

public interface MagazineRepostitoryJpa extends JpaRepository<Magazine, Long> {

    List<Publication> findByTitleIgnoreCaseContaining(String title);

    List<Publication> findByAvailableCopies(int availableCopies);

}
