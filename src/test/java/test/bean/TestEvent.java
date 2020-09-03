package test.bean;

import org.springframework.context.ApplicationEvent;

/**
 * @author WangPingChun
 */
public class TestEvent extends ApplicationEvent {
	private String message;

	/**
	 * Create a new ApplicationEvent.
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public TestEvent(Object source) {
		super(source);
	}

	public TestEvent(Object source, String message) {
		super(source);
		this.message = message;
	}

	public void print() {
		System.out.println(message);
	}
}
