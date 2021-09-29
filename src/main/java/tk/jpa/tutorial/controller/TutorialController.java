package tk.jpa.tutorial.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import tk.jpa.tutorial.model.Tutorial;
import tk.jpa.tutorial.repository.TutorialRepository;
import tk.jpa.tutorial.service.TutorialService;

@RestController
//@RequestMapping("/tutorial")
public class TutorialController {

	@Autowired
	TutorialService service;
	
	@Autowired
	TutorialRepository repo;
	
	@RequestMapping(value = {"/hello", "/"})
	public String message() {
		return "Hello JPO";
	}
	
    @GetMapping("/list")
    public List<Tutorial> getList() {
        return service.getAllTutorial();
    }
    
    @GetMapping("/lists")
    public List<Tutorial> getAllRecords() {
        return service.getAllRecords();
    }
    
    @GetMapping("/lists/{name}")
    public List<Tutorial> getAllRecords(@PathVariable String name) {
		return service.getAllRecords(name);
	}
    
//  @GetMapping("/laptops/{name}")
//	public List<Laptop> readData (@PathVariable String name) {
//		return lRepo.getAllRecords(name); 
//		
//	}
    
    @GetMapping("/list/addget")
    public Tutorial createTutorial(@RequestParam(value="name", required=true) String name,
            @RequestParam(value="author", required=false) String author) {
    	Tutorial tutorial = new Tutorial(name, author);
    	System.out.println(tutorial.getName() + tutorial.getAuthor());
        return service.addTutorial(tutorial);
    }
    
    @PostMapping("list/add")
    public Tutorial createTutorial(@Valid @RequestBody Tutorial tutorial) {
    	System.out.println(tutorial.getName() + tutorial.getAuthor());
        return service.addTutorial(tutorial);
    }
	
//    @PutMapping("/update/{id}")
//    public String updateUser(@PathVariable Long id) {
//    	System.out.println("Update called with id:" + id);
////        service.update(id, tutorial);
//		return "{ status: 1, message = Update successfully " + id + "  }";
//    }
    
    // Below working
    @PutMapping("/update/{id}")
    public Tutorial updateUser(@PathVariable Long id, @Valid @RequestBody Tutorial tutorial) {
    	System.out.println("Update" + tutorial.getName() + tutorial.getAuthor());

        service.update(id, tutorial);
        System.out.println("Updated  successfully " + id);
        return tutorial;
    }
    
    @RequestMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
    	String resonse = service.deleteUser(id);
    	System.out.println("Delete successfully " + resonse);
        return resonse;
    }

    @RequestMapping("/list/{id}")
    public Optional<Tutorial> findOne(@PathVariable Long id) {
        return service.findOne(id);
    }
    
    @GetMapping("/list/name")
    public List<Tutorial> getFiltered(@RequestParam String name) {
//    	return null;
        return service.getFilteredByName(name);
    }
    
    @GetMapping("/list/author")
    public ResponseEntity<List<Tutorial>> getFilteredByAuthor(@RequestParam String name) {
//    	return null;
        return new ResponseEntity<List<Tutorial>> (service.getFilteredByAuthor(name), HttpStatus.OK);
    }
    
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MethodArgumentTypeMismatchException.class)
    public String handleInvalidRequest(final MethodArgumentTypeMismatchException e) {
      //log headers; ??
    	System.out.println(e.getLocalizedMessage());
      return e.getMessage();
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = MissingServletRequestParameterException.class)
    public String handleMissingParam(final MissingServletRequestParameterException e) {
      //log headers; ??
    	System.out.println(e.getLocalizedMessage());
      return e.getMessage();
    }
}
