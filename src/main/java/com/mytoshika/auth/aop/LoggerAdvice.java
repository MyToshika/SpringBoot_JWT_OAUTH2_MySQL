package com.mytoshika.auth.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAdvice {
	private Logger log = LoggerFactory.getLogger(this.getClass());

	@Around("@annotation(Loggable)")
	public Object logExecutionTime(ProceedingJoinPoint joinPoint) throws Throwable {

		long start = System.currentTimeMillis();
		Object proceed = joinPoint.proceed();

		log.info("Start :: " + joinPoint.getSignature());
		long executionTime = System.currentTimeMillis() - start;
		log.info("End :: " +joinPoint.getSignature()+ " executed in " + executionTime + "ms");
		return proceed;
	}

}
