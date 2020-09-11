package tanzeel.apiwithspringboot.model;


import javax.persistence.*;

@Entity
public class Parent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(unique=true)
    private String email;
    private String firstname;
    private String lastname;
    
    
	public Parent() {
//		super();
		// TODO Auto-generated constructor stub
	}

	public Parent(String email, String firstname, String lastname) {
//		super();
//		this.setId(id);
		this.setEmail(email);
		this.setFirstname(firstname);
		this.setLastname(lastname);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	@Override
	public String toString() {
		return "Parent [id=" + id + ", email=" + email + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

    
//    public Parent() {  }
//
//    public Parent(String title, String content) {
//        this.setTitle(title);
//        this.setContent(content);
//    }
//
//    public Blog(int id, String title, String content) {
//        this.setId(id);
//        this.setTitle(title);
//        this.setContent(content);
//    }
//
//    public int getId() {
//        return id;
//    }
//
//    public void setId(int id) {
//        this.id = id;
//    }
//
//    public String getTitle() {
//        return title;
//    }
//
//    public void setTitle(String title) {
//        this.title = title;
//    }
//
//    public String getContent() {
//        return content;
//    }
//
//    public void setContent(String content) {
//        this.content = content;
//    }
//
//    @Override
//    public String toString() {
//        return "Blog{" +
//                "id=" + id +
//                ", title='" + title + '\'' +
//                ", content='" + content + '\'' +
//                '}';
//    }
//
}
