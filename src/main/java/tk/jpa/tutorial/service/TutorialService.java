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

    public Optional<Tutorial> findOne(Long id) {
        return tutorialRepository.findById(id);
    }

    public Tutorial addTutorial(Tutorial tut) {
        return tutorialRepository.save(tut);
    }

    public String deleteUser(Long id) {
    	tutorialRepository.deleteById(id);
        return "User deleted successfully";
    }
}
