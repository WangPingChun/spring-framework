package test.bean;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

/**
 * @author WangPingChun
 */
public class BeanTests {
	private static DefaultListableBeanFactory bf;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		bf = new DefaultListableBeanFactory();
		new XmlBeanDefinitionReader(bf).loadBeanDefinitions(new ClassPathResource("test/spring.xml"));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		bf.destroySingletons();
	}

	@Test
	public void beanPostProcessor() {
		bf.addBeanPostProcessor(new BeanPostProcessorTest());
		final BeanPostProcessorTest test = bf.getBean("beanPostProcessorTest", BeanPostProcessorTest.class);
		test.display();
	}


	@Test
	public void beanFactoryPostProcessor() {
		ApplicationContext context = new ClassPathXmlApplicationContext("test/spring.xml");
		final StudentService studentService = context.getBean("studentService", StudentService.class);
		System.out.println("student name:" + studentService.getName() + " --- age:" + studentService.getAge());
	}

	@Test
	public void lookupMethod() {
		final Display display = (Display) bf.getBean("display");
		display.display();
	}

	@Test
	public void replaceMethod() {
		final Method method = (Method) bf.getBean("method");
		method.display();
	}
}
