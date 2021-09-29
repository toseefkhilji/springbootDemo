package tk.jpa.tutorial.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import tk.jpa.tutorial.model.Tutorial;

@Repository
public class TutorialDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Tutorial> getAllRecords() {
		Query query = manager.createNamedQuery("getAllRecords", Tutorial.class);
        return query.getResultList();
	}
	
	public Tutorial update(Long id, Tutorial tutorial) {
		
		
		return tutorial;
	}
}
