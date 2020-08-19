package test.dep;

import org.junit.Test;

import org.springframework.beans.factory.BeanCurrentlyInCreationException;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author WangPingChun
 */
public class DepTests {

	@Test(expected = BeanCurrentlyInCreationException.class)
	public void testCircleByConstructor() throws Throwable {
		/*
		 * 1. Spring 容器创建 "testA" bean，首先去“当前创建 bean 池” singletonsCurrentlyInCreation 查找是否当前 bean 正在创建，如果
		 * 没发现，则继续准备其需要的构造参数 "testB"，并将 "testA" 标识符放到”当前创建 bean 池“
		 * 2. Spring 容器创建 "testB" bean，首先去”当前创建 bean 池“ singletonsCurrentlyInCreation 查找是否当前 bean 正在创建，如果
		 * 没发现，则继续准备其需要的构造参数 "testC"，并将 "testB" 标识符放到”当前创建 bean 池“
		 * 3. Spring 容器创建 "testC" bean，首先去”当前创建 bean 池“ singletonsCurrentlyInCreation 查找是否当前 bean 正在创建，如果
		 * 没发现，则继续准备其需要的构造参数 "testA"，并将 "testC" 标识符放到”当前创建 bean 池“
		 * 4. 到此为止 Spring 容器要去创建 "testA" bean，发现该 bean 标识符在“当前创建 bean 池”中，因此表示循环依赖，抛出 BeanCurrentlyInCreationException
		 */
		try {
			new ClassPathXmlApplicationContext("test/dep.xml");
		}
		catch (Exception e) {
			throw e.getCause().getCause().getCause();
		}
	}

	@Test
	public void testCircleBySetter() throws Throwable {
		/*
		 * 1. Spring 容器创建 "testA" bean，首先根据无参构造器创建 bean，并暴露一个 "ObjectFactory" 用于返回一个提前暴露一个创建中的 bean
		 * 并将 "testA" 标识符放到 ”当前创建 bean 池“，然后进行 setter 注入 "testB"
		 * 2. Spring 容器创建 "testB" bean，首先根据无参构造器创建 bean，并暴露一个 "ObjectFactory" 用于返回一个提前暴露一个创建中的 bean
		 * 并将 "testB" 标识符放到 ”当前创建 bean 池“，然后进行 setter 注入 "testC"
		 * 3. Spring 容器创建 "testC" bean，首先根据无参构造器创建 bean，并暴露一个 "ObjectFactory" 用于返回一个提前暴露一个创建中的 bean
		 * 并将 "testC" 标识符放到 ”当前创建 bean 池“，然后进行 setter 注入 "testA"。进行注入 "testA" 时由于提前暴露了 "ObjectFactory" 工厂
		 * 从而使用它返回提前暴露一个创建中的 bean
		 * 4.最后再依赖注入 "testB" 和 "testA"，完成 setter 注入
		 */
		try {
			new ClassPathXmlApplicationContext("test/dep-setter.xml");
		}
		catch (Exception e) {
			throw e.getCause().getCause().getCause();
		}
	}

	@Test
	public void testCircleByPrototype() throws Throwable {
		// 对于 prototype 作用域 bean，Spring 容器无法完成依赖注入，因为 Spring 容器不进行缓存 prototype 作用域的 bean，
		// 因此无法提前暴露一个创建中的 bean
		try {
			final ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("test/dep-prototype.xml");
			System.out.println(ctx.getBean("testA"));
		}
		catch (Exception e) {
			throw e.getCause().getCause().getCause();
		}
	}
}
