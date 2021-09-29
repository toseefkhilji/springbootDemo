package tk.jpa.tutorial.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import tk.jpa.tutorial.model.Tutorial;
import tk.jpa.tutorial.repository.TutorialSearchRepository;

@Repository
@Transactional
public class TutorialSearchRepositoryImpl implements TutorialSearchRepository {

	@PersistenceContext
	@Autowired
	EntityManager entityManager;
	
	public List<Tutorial> getAllRecords() {
		Query query = entityManager.createNamedQuery("getAllRecords", Tutorial.class);
        return query.getResultList();
	}
}
