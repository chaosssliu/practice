package net.antra.design.dynamicproxy;

import java.lang.reflect.Proxy;

public class DynamicProxyTest {
	public static void main(String[] args) {
		DepartmentService ds = new DepartmentServiceImpl();
		DepartmentService dsProxy = (DepartmentService) newProxy(ds);
		doSomething(dsProxy);
	}

	private static void doSomething(DepartmentService ds) {
		ds.saveDept();
	}
	
	public static Object newProxy(Object obj){
        Class[] interfaces = obj.getClass().getInterfaces();
       
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(), interfaces, new ProxyHandler(obj));
    }
}
