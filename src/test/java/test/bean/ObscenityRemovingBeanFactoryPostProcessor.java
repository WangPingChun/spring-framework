package test.bean;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanDefinitionVisitor;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.util.StringValueResolver;

/**
 * @author WangPingChun
 */
public class ObscenityRemovingBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
	private Set<String> obscenties;

	public ObscenityRemovingBeanFactoryPostProcessor() {
		this.obscenties = new HashSet<>();
	}

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		final String[] beanNames = beanFactory.getBeanDefinitionNames();
		for (String beanName : beanNames) {
			final BeanDefinition bd = beanFactory.getBeanDefinition(beanName);
			StringValueResolver valueResolver = (strVal -> {
				if (isObscene(strVal)) {
					return "****";
				}
				return strVal;
			});

			BeanDefinitionVisitor visitor = new BeanDefinitionVisitor(valueResolver);
			visitor.visitBeanDefinition(bd);
		}
	}

	private boolean isObscene(Object value) {
		final String potentialObscenity = value.toString().toUpperCase();
		return this.obscenties.contains(potentialObscenity);
	}

	public void setObscenties(Set<String> obscenties) {
		this.obscenties.clear();
		for (String obscenty : obscenties) {
			this.obscenties.add(obscenty.toUpperCase());
		}
	}
}
