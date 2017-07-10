package net.antra.design.dynamicproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class ProxyHandler implements InvocationHandler{
	private Object obj;
	
	public ProxyHandler(Object obj) {
		super();
		this.obj = obj;
	}

	@Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object ret = null;
        System.out.println("Before saving..");
        ret = method.invoke(obj, args);
        System.out.println("After saving..");
        return ret;
    }
}
