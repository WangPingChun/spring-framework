package test.aop;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author WangPingChun
 */
@Aspect
public class AspectJTest {
	@Pointcut("execution(* *.test(..))")
	public void test() {

	}

	@Before("test()")
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@After("test()")
	public void afterTest() {
		System.out.println("afterTest");
	}

	@Around("test()")
	public Object around(ProceedingJoinPoint joinPoint) {
		System.out.println("before1");
		Object result = null;
		try {
			result = joinPoint.proceed();
		}
		catch (Throwable throwable) {
			throwable.printStackTrace();
		}
		System.out.println("after1");
		return result;
	}

}
