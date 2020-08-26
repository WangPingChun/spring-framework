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
public class BeanFactoryPostProcessor_2 implements BeanFactoryPostProcessor, Ordered {
	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		System.out.println("调用 BeanFactoryPostProcessor_2。。。");

		final BeanDefinition bd = beanFactory.getBeanDefinition("studentService");
		final MutablePropertyValues pvs = bd.getPropertyValues();
		pvs.addPropertyValue("age", 15);
	}

	@Override
	public int getOrder() {
		return 2;
	}
}
