package net.antra.design.staticproxy;

public class StaticProxyTest {
	public static void main(String[] args) {
	//	DepartmentService ds = new DepartmentServiceImpl();
		DepartmentService ds = new DepartmentServiceProxy();
		doSomething(ds);
	}

	private static void doSomething(DepartmentService ds) {
		ds.saveDept();
	}
}
