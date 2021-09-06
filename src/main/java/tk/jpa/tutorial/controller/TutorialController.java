package tk.jpa.tutorial.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tk.jpa.tutorial.model.Tutorial;
import tk.jpa.tutorial.service.TutorialService;

@RestController
//@RequestMapping("/tutorial")
public class TutorialController {

	@Autowired
	TutorialService service;
	
	@RequestMapping(value = {"/hello", "/"})
	public String message() {
		return "Hello JPO";
	}
	
    @GetMapping("/list")
    public List<Tutorial> getList() {
        return service.getAllTutorial();
    }
    
    @PostMapping("list/add")
    public Tutorial createTutorial(@Valid @RequestBody Tutorial tutorial) {
        return service.addTutorial(tutorial);
    }
	
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        return service.deleteUser(id);
    }

    @RequestMapping("/list/{id}")
    public Optional<Tutorial> findOne(@PathVariable Long id) {
        return service.findOne(id);
    }
}
