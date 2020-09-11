package tanzeel.apiwithspringboot.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

//	@Column(fname = "fname")
//	private String fname;
//
//	@Column(lname = "lname")
//	private String lname;

	@Column(name = "name")
	private String name;

	@Column(name = "standard")
	private String standard;

	@Column(name = "age")
	private Integer age;
	
	@Column(name = "published")
	private boolean published = true;

	public Student() {
		
	}
	public Student(String name, String standard, Integer age, boolean published) {
		
		this.name = name;
		this.standard = standard;
		this.age = age;
		this.published = published;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void setStandard(String standard) {
		this.standard = standard;
	}
	
	public String getStandard() {
		return standard;
	}
	
	public void setAge(Integer age) {
		this.age = age;
	}
	
	public Integer getAge() {
		return age;
	}
	
	public boolean isPublished() {
		return published;
	}

	public void setPublished(boolean isPublished) {
		this.published = isPublished;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", standard=" + standard + ", age=" + age + ", published="
				+ published + "]";
	}	
	
}
