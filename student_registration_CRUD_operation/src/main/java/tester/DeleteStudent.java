package tester1;

import org.hibernate.SessionFactory;

import dao.StudentDaoImpl;

import static utils.HibernateUtils.getFactory;

import java.util.Scanner;
public class DeleteStudent {

	public static void main(String[] args) {
		try(SessionFactory sf = getFactory();
				Scanner sc = new Scanner(System.in)){
			
			StudentDaoImpl dao = new StudentDaoImpl();
			System.out.println("Enter Student id to delete record : ");
			System.out.println(dao.deleteStudent(sc.nextInt()));
			
		}catch(Exception e){
			e.printStackTrace();
		}

	}

}
