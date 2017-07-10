package net.antra.test;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import net.antra.cs.domain.Course;
import net.antra.cs.domain.CourseStudentAssoc;
import net.antra.cs.domain.Student;
import net.antra.cs.domain.Teacher;

public class TestApp {
	
	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("course_student_teacher_pu");
	public static void main(String[] args) {
//		addTeacher();
//		addCourse();
//		addStudent();
//		addCourseStudentAssoc();
//		getCourse();
		queryJPQL();
		EMF.close();
	}

	public static void addCourse(){
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		//create a new course
		Course course = new Course();
		course.setCredit(1);
		course.setName("Math");
		//set teacher to a coures
		Teacher teacher = em.find(Teacher.class, 3);
		course.setTeacher(teacher);
		//em.persist(teacher); cascade type = all, no need to persist teacher first
		em.persist(course);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}

	private static void addTeacher() {
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		//create a new teacher
		Teacher teacher = new Teacher();
		teacher.setAge(25);
		teacher.setName("Rosie");
		//em.persist(teacher); cascade type = all, no need to persist teacher first
		em.persist(teacher);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	private static void addStudent() {
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		Student student = new Student();
		student.setName("Liu");
		em.persist(student);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}	
	
	private static void addCourseStudentAssoc() {
		EntityManager em = EMF.createEntityManager();
		em.getTransaction().begin();
		CourseStudentAssoc csa = new CourseStudentAssoc();
		Course course = em.find(Course.class, 11);
		Student student = em.find(Student.class, 2);
		csa.setCourse(course);
		csa.setStudent(student);
		em.persist(csa);
		em.flush();
		em.getTransaction().commit();
		em.close();
	}
	
	private static void getCourse() {
		EntityManager em = EMF.createEntityManager();
		Course course = em.find(Course.class, 11);
		for(CourseStudentAssoc csa:course.getCourseStudentAssoc()){
			System.out.println(csa.getStudent().getName());
		}
		em.close();
	}
	
	private static void queryJPQL() {
		EntityManager em = EMF.createEntityManager();
		Query query = em.createQuery("select name from Course c where c.teacher.seqId = :teacherId");
		query.setParameter("teacherId", 3);
		List<String> list = query.getResultList();
		for(String str : list){
			System.out.println(str);
		}
		em.close();
	}

}
