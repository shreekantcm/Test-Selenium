package Demo;

import org.testng.annotations.Test;

public class Test2{
	
	@Test(priority =1)
	public void methods(){
		System.out.println("Test");
	}
	@Test(priority =2)
	public void method(){
		System.out.println("Method");
		Demo.Test1 test = new Test1();
		test.method2();
	}
}
