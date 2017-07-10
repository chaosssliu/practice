package net.antra.test;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

public class MainRun {
	public static void main(String[] arg) {
		Result result = JUnitCore.runClasses(UnitTest_1Basic.class, 
				UnitTest_2LifeCycle.class);
		
	      for (Failure failure : result.getFailures()) {
	         System.out.println(failure.getMessage());
	      }
			
	      System.out.println("All tests pass: "+result.wasSuccessful());
	}
}
