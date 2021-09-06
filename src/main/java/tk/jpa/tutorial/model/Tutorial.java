package tk.jpa.tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Tutorial")
public class Tutorial {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tutorial_id")
	private Long id;
	
    @Column(name = "name", nullable = false)
	@NotBlank(message = "Name is mandatory")
	@Size(min=4, message= "Name should have at least 4 characters")  
	private String name;
	
    @Column(name = "author", nullable = true)
	private String author;
   
	public Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tutorial(Long id,
			@NotBlank(message = "Name is mandatory") @Size(min = 4, message = "Name should have at least 4 characters") String name,
			String author) {
		super();
		this.id = id;
		this.name = name;
		this.author = author;
	}

	public Tutorial(String name, String author) {
		this.name = name;
		this.author = author;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + ", author=" + author + "]";
	}
	
}
