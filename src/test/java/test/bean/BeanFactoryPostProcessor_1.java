package test.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.core.Ordered;

/**
 * @author WangPingChun
 */
public class BeanFactoryPostProcessor_1 implements BeanFactoryPostProcessor, Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("调用 BeanFactoryPostProcessor_1。。。");
		System.out.println("容器中有 BeanDefinition 的个数：" + beanFactory.getBeanDefinitionCount());

		final BeanDefinition bd = beanFactory.getBeanDefinition("studentService");
		final MutablePropertyValues pvs = bd.getPropertyValues();
		pvs.addPropertyValue("name", "test");
		pvs.addPropertyValue("age", 30);
	}

	@Override
	public int getOrder() {
		return 1;
	}
}
