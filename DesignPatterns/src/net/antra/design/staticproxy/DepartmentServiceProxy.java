package net.antra.design.staticproxy;

public class DepartmentServiceProxy implements DepartmentService{

	private DepartmentServiceImpl realSubject = new DepartmentServiceImpl();
	
	@Override
	public void saveDept() {
		System.out.println("Do something extra before saving...");
		realSubject.saveDept();
		System.out.println("Do something extra after saving...");
	}
	

}
