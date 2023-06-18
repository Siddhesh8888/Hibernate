package tester1;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;
import pojos.Student;

import static utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.Scanner;
public class AddStudentDetalis {

	public static void main(String[] args) {
		
		try(SessionFactory sf = getFactory();
				Scanner sc =new Scanner(System.in))
		{
			StudentDaoImpl studentdao = new StudentDaoImpl();
			System.out.println("Enter Students details : firstName lastName email password course Date of birth");
			
			Student newStudent = new Student(sc.next(), sc.next(), sc.next(), sc.next(), Course.valueOf(sc.next().toUpperCase()), LocalDate.parse(sc.next()));
			System.out.println(studentdao.registerNewStudent(newStudent));
			
		}catch (Exception e) {
			
		}

	}

}
