package app.labs.ex04.aop02;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;

public class PerformanceAspect {
	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		
		Signature s = joinPoint.getSignature();
		String methodName = s.getName();
		System.out.println("[Log] Before: " + methodName + " time check start");
		
		long startTime = System.nanoTime();
		
		Object result = null;
		
		try {
			result = joinPoint.proceed();
		}
		catch(Exception ex) {
			System.out.println("[Log] Exception: " + methodName);
		}
		finally {
			System.out.println("[Log] Finally: " + methodName);
		}

		long endTime = System.nanoTime();
		System.out.println("[Log] after: " + methodName + " time check end");
		System.out.println("[Log] " + methodName + ":" + (endTime-startTime) + "ns");
		
		return result;
	}
}
