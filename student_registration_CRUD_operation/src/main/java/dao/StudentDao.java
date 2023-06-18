package dao;

import java.util.List;

import pojos.Course;
import pojos.Student;

public interface StudentDao {
	//To add student
	String registerNewStudent(Student student);
	//To authenticate student
	String authenticateStudent(String email, String password);
	//To get student details dependeing on given course type
	List<Student> getAllStudentCourse(Course course);
	//To update course of perticular student
	String updateCourseName(int id , Course course);
	//To delete student
	String deleteStudent(int id);

}
