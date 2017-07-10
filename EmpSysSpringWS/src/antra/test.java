package antra;

import antra.entity.Department;
import antra.controller.DeptController;

public class test {

	public static void main(String[] args) {
		DeptController dc = null;
		@SuppressWarnings("null")
		Department dept = dc.getDeptDetails(4);
		
		System.out.println(dept.getName()+" "+dept.getEmail());
	}

}
