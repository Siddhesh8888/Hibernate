package tester1;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;

import static utils.HibernateUtils.*;

import java.util.Scanner;
public class StudentLogin {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in))
		{
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter Email and Password : ");
			System.out.println(dao.authenticateStudent(sc.next(), sc.next()));
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
