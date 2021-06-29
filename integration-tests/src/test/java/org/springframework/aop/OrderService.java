package org.springframework.aop;

/**
 * @author WangPingChun
 */
public interface OrderService {
	Order createOrder(String username, String product);

	Order queryOrder(String username);
}
