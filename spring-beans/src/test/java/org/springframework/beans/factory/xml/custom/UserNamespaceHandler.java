package org.springframework.beans.factory.xml.custom;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * @author WangPingChun
 */
public class UserNamespaceHandler extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user", new UserDefinitionParser());
	}
}
