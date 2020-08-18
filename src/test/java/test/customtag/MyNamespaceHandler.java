package test.customtag;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author WangPingChun
 */
public class MyNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserBeanDefinitionParser());
	}
}
