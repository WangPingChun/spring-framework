package test.aop;

import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author WangPingChun
 */
public class AopTests {
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("test/spring-aop.xml");
	}


	@Test
	public void aspectJTest() {
		context.getBean("test", TestBean.class).test();
	}
}
