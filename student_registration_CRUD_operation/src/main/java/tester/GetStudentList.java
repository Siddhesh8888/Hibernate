package tester1;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.*;

import java.util.List;
import java.util.Scanner;
public class GetStudentList {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in))
		{
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter Course type [DAC,DBDA,DITISS]: ");
			List<Student> studentList =null;
			studentList = dao.getAllStudentCourse(Course.valueOf(sc.next().toUpperCase()));
			System.out.println("Students details : ");
			if(studentList.isEmpty())
				System.out.println("students are not admitted to this course");
			else
				studentList.forEach(s->System.out.println(s));
		}
		catch (IllegalArgumentException e) {
			System.out.println("Please Enter valid course...");
		}

	}

}
