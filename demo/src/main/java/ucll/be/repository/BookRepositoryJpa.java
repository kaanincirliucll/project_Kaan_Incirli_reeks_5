package ucll.be.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ucll.be.model.Publication;

public interface BookRepositoryJpa extends JpaRepository<Publication, Long> {

    List<Publication> findByTitleIgnoreCaseContains(String title);

}
