package employment;

import java.util.*;

public class Department {
	private int id;
	private String name;
	private String email;
	private Set<Employee> empSet;
	
	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(String name, String email) {
		super();
//		this.id = id;
		this.name = name;
		this.email = email;
		
	}
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	
	
	public Set<Employee> getEmpList() {
		return empSet;
	}
	public void setEmpList(Set<Employee> empSet) {
		this.empSet = empSet;
	}
	
}
