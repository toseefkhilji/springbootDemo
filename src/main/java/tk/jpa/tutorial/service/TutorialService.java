package tk.jpa.tutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import tk.jpa.tutorial.repository.TutorialRepository;
import tk.jpa.tutorial.model.Tutorial;

@Component
@Service
public class TutorialService {

	@Autowired
	TutorialRepository tutorialRepository;
	
	@Autowired
	TutorialDAO dao;
	
	public List<Tutorial> getAllTutorial() {
        return tutorialRepository.findAll();
    }
//	
//	public List<Tutorial> findByTitleContaining(String title) {
//        return tutorialRepository.findByTitleContaining(title);
//    }

	public void saveOrUpdate(Tutorial tut) {  
		tutorialRepository.save(tut);  
	} 

	public void update(Long id, Tutorial tut) {  
		System.out.println("Started update");

		Tutorial newTut = tutorialRepository.findById(id).get();
		newTut.setName(tut.getName());
		newTut.setAuthor(tut.getAuthor());
		newTut.setPrice(tut.getPrice());

		System.out.println("update called");
		System.out.println(newTut.toString());
		tutorialRepository.save(newTut);
	} 
	
    public Optional<Tutorial> findOne(Long id) {
        return tutorialRepository.findById(id);
    }

    public Tutorial addTutorial(Tutorial tut) {
        return tutorialRepository.save(tut);
    }

    public String deleteUser(Long id) {
    	tutorialRepository.deleteById(id);
        return "{ status: 1, message = User deleted successfully }";
    }
    
    public List<Tutorial> getFilteredByName(String tname) {
    	return  tutorialRepository.findByNameContaining(tname);
    }
    
    public List<Tutorial> getFilteredByAuthor(String author) {
    	return  tutorialRepository.findByAuthor(author);
    }
    
    public List<Tutorial> getAllRecords() {
    	return  dao.getAllRecords();
    }
    
    public List<Tutorial> getAllRecords(String name) {
    	return tutorialRepository.getAllRecords(name);
    } 
}
