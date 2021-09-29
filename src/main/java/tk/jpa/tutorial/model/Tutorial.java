package tk.jpa.tutorial.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.NamedNativeQuery;

@Entity
@DynamicUpdate
@Table(name = "Tutorial")
@NamedNativeQuery(name = "getAllRecords", query = "Select * from Tutorial", resultClass = Tutorial.class)
@NamedQuery(name = "Tutorial.getAllRecords", query = "FROM Tutorial WHERE TutorialName = ?1")
//@NamedQuery(name = "Tutorial.update", query = "Update Tutorial set WHERE TutorialName = ?1, Author = ?2 Where TutorialId = ?3")

public class Tutorial {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "TutorialId")
	private Long id;
	
    @Column(name = "TutorialName", nullable = false)
	@NotBlank(message = "Name is mandatory")
	@Size(min=4, message= "Name should have at least 4 characters")  
	private String name;
	
    @Column(name = "Author", nullable = true)
	private String author;
   
    @Column(name="Price", nullable = true)
    private double price = 0.0;
    
	public Tutorial() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Tutorial(Long id, String name, String author) {
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
	
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Tutorial [id=" + id + ", name=" + name + ", author=" + author + ", price=" + price + "]";
	}
	
}
