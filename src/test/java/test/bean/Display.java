package test.bean;

/**
 * @author WangPingChun
 */
public abstract class Display {
	public void display() {
		this.getCar().display();
	}

	public abstract Car getCar();
}
