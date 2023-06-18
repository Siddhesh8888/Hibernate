package pojos;
//studentId : Integer (PK) ,first name , last name,email,password,course(enum with admission fees), dob : LocalDate 

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="students")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "student_id")
	private Integer studentId;
	@Column(name = "first_name" , length = 20)
	private String firstName;
	@Column(name = "last_name" , length = 20)
	private String lastName;
	@Column(length = 20, unique = true)
	private String email;
	@Column(length = 20, nullable = false)
	private String password;
	@Enumerated(EnumType.STRING)
	@Column(length = 20)
	private Course course;
	@Column(name = "date_of_birth" , length = 20,nullable = false)
	private LocalDate dob;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	public Student(String firstName, String lastName, String email, String password, Course course, LocalDate dob) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.password = password;
		this.course = course;
		this.dob = dob;
	}
	


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public Course getCourse() {
		return course;
	}


	public void setCourse(Course course) {
		this.course = course;
	}


	public LocalDate getDob() {
		return dob;
	}


	public void setDob(LocalDate dob) {
		this.dob = dob;
	}


	public Integer getStudentId() {
		return studentId;
	}


	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", course=" + course + ", dob=" + dob + "]";
	}
	
	
	

}
