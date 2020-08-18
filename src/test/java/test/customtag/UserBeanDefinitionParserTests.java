package test.customtag;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import com.foo.Component;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.core.io.ClassPathResource;

/**
 * @author WangPingChun
 */
public class UserBeanDefinitionParserTests {
	private static DefaultListableBeanFactory bf;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bf = new DefaultListableBeanFactory();
		new XmlBeanDefinitionReader(bf).loadBeanDefinitions(new ClassPathResource("test/customtag/user-config.xml"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bf.destroySingletons();
	}

	private User getBionicFamily() {
		return bf.getBean("testbean", User.class);
	}

	@Test
	public void testBionicBasic() throws Exception {
		User user = getBionicFamily();
		System.out.println(user.getUsername() + "," + user.getEmail());
	}
}
