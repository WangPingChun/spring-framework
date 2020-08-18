package test.customtag;

import org.w3c.dom.Element;

import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.xml.AbstractSingleBeanDefinitionParser;
import org.springframework.util.StringUtils;

/**
 * @author WangPingChun
 */
public class UserBeanDefinitionParser extends AbstractSingleBeanDefinitionParser {
	@Override
	protected Class<?> getBeanClass(Element element) {
		return User.class;
	}

	@Override
	protected void doParse(Element element, BeanDefinitionBuilder builder) {
		final String username = element.getAttribute("username");
		final String email = element.getAttribute("email");

		// 将提取的数据放入 BeanDefinitionBuilder中，待到完成所有 bean 的解析后统一注册到 beanFactory 中
		if (StringUtils.hasText(username)) {
			builder.addPropertyValue("username", username);
		}
		if (StringUtils.hasText(email)) {
			builder.addPropertyValue("email", email);
		}
	}
}
