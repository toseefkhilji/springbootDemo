package tk.jpa.tutorial.repository;

import java.util.List;

import tk.jpa.tutorial.model.Tutorial;

public interface TutorialSearchRepository {
	List<Tutorial> getAllRecords();
//	List<Tutorial> filterWithName(String tname);
//	List<Tutorial> getListAuthorLike(String auther);
}

