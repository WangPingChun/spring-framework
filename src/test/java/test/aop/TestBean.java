package test.aop;

/**
 * @author WangPingChun
 */
public class TestBean {
	private String testString = "testStr";

	public String getTestString() {
		return testString;
	}

	public void setTestString(String testString) {
		this.testString = testString;
	}

	public void test() {
		System.out.println("test");
	}
}
