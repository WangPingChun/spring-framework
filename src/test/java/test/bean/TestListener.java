package test.bean;

import org.springframework.context.ApplicationListener;

/**
 * @author WangPingChun
 */
public class TestListener implements ApplicationListener<TestEvent> {
	@Override
	public void onApplicationEvent(TestEvent event) {
		event.print();
	}
}
