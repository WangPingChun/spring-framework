package test.transaction;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author WangPingChun
 */
public class TransactionTests {
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("test/transaction/spring-transaction.xml");
	}


	@Test
	public void jdbc() {
		UserService userService = context.getBean("userService", UserService.class);
		User user = new User();
		user.setName("李四");
		user.setAge(26);
		user.setSex("男");
		userService.save(user);

	}


}
