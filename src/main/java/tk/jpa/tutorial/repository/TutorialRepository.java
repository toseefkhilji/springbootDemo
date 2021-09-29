package tk.jpa.tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tk.jpa.tutorial.model.Tutorial;

@Repository
public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
	List<Tutorial> findByName(String name);
	List<Tutorial> findByAuthor(String author);
	List<Tutorial> findByNameContaining(String name);
	List<Tutorial> getAllRecords (String name); 

}
