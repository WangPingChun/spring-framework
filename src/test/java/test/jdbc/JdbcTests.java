package test.jdbc;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @author WangPingChun
 */
public class JdbcTests {
	private static ApplicationContext context;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		context = new ClassPathXmlApplicationContext("test/jdbc/spring-jdbc.xml");
	}


	@Test
	public void jdbc() {
		UserService userService = context.getBean("userService", UserService.class);
		User user = new User();
		user.setName("张三");
		user.setAge(20);
		user.setSex("男");
		userService.save(user);

		List<User> users = userService.listUsers();
		for (User u : users) {
			System.out.println(u.getId() + " " + u.getName() + " " + u.getAge() + " " + u.getSex());
		}

	}


}
