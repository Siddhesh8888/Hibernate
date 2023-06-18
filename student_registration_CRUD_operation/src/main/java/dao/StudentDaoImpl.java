package dao;

import org.hibernate.Session;
import org.hibernate.Transaction;

import static utils.HibernateUtils.getFactory;

import java.io.Serializable;
import java.util.List;

import pojos.Course;
import pojos.Student;

public class StudentDaoImpl implements StudentDao {

	@Override
	public String registerNewStudent(Student student) {

		String msg = "Registration of student failed!!!";
		//1.get session from sf
		Session session = getFactory().getCurrentSession();//session is 
		//2.begin tx
		Transaction tx = session.beginTransaction();
		
		try {
			
			Serializable id = session.save(student);
			tx.commit();
			msg = "Student registered successfully with id : "+id;
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return msg;
	}

	@Override
	public String authenticateStudent(String email, String password) {

		String msg = "Login not successful!!";
		String jpql = "select s from Student s where s.email =:em and s.password=:pass";
		Student student = null;
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			
			student = session.createQuery(jpql, Student.class)
			.setParameter("em", email)
			.setParameter("pass", password)
			.getSingleResult();
			tx.commit();
			msg = "Login successful!!";
						
			
		} catch (RuntimeException e) {
			if(tx!=null) {
				
				tx.rollback();
				msg = "Login not successful please enter valid email and password!!";
				}
			
		}
		return msg;
	}
	

	@Override
	public List<Student> getAllStudentCourse(Course course) {
		
		List<Student> studList=null;
		String jpql = "select s from Student s where s.course=:c1"; 
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			
			studList = session.createQuery(jpql, Student.class)
					.setParameter("c1", course)
					.getResultList();
		
			tx.commit();
			
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
		}
		return studList;
	}

	@Override
	public String updateCourseName(int id, Course course) {
		
		String msg = "Course updatation failed!!!";
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		
		try {
			
			Student s1 = session.get(Student.class, id);
			if(s1!=null) {
				s1.setCourse(course);
				msg = "Course updatation Successfully!!!";
			}
			else
				msg = "Please Enter valid Student id!!!";
			
			tx.commit();
			
			
		}catch (RuntimeException e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		
		return msg;
	}

	@Override
	public String deleteStudent(int id) {
		String msg = "Record not deleted!!!";
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try {
			Student student = session.get(Student.class, id);
			if(student!=null) {
				session.delete(student);
				msg = "Student Id : "+id+" deleted successfully!!!";
			}
			else
				msg = "Please Enter valid Student Id...";
			
			tx.commit();
			
			
		} catch (Exception e) {
			if(tx!=null)
				tx.rollback();
			throw e;
		}
		return msg;
	}
	
	

}
