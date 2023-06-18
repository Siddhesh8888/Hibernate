package tester1;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;
import pojos.Course;

import static utils.HibernateUtils.*;

import java.util.Scanner;
public class UpdateCourse {

	public static void main(String[] args) {
		
		try(SessionFactory sf =getFactory();
				Scanner sc = new Scanner(System.in))
		{
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter Student Id and Course [DAC,DBDA,DITISS]: ");
			System.out.println(dao.updateCourseName(sc.nextInt(),Course.valueOf(sc.next().toUpperCase())));
			
		}
		catch (IllegalArgumentException e) {
			System.out.println("Please Enter valid course...");
		}

	}

}
