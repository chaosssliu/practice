package util;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import employment.Department;
import employment.Employee;

import java.sql.*;

public class test {
	
	static final EntityManagerFactory EMF = Persistence.createEntityManagerFactory("employee-department-pu");

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		EntityManager entityMgr = EMF.createEntityManager();
		Query query = entityMgr.createQuery("SELECT e FROM Employee e");
		@SuppressWarnings("unchecked")
		List<Employee> empList = query.getResultList();
		for (Employee employee: empList) {
			System.out.println(employee.getFirstName());
		}
		
		entityMgr.close();
		
	}		

}
