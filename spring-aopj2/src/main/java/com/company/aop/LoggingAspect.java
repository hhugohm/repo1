package com.company.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import com.mycompany.modelo.Usuario;


@Aspect
public class LoggingAspect {
/*
	@Before("execution(* com.company.services.UsuarioService.consultaUsuario(..))")
	public void logBefore(JoinPoint joinPoint) {
		System.out.println("*********************ADVISE BEFORE*******************");
		System.out.println("metodo logBefore() esta corriendo!");
		System.out.println("metodo interceptado : " + joinPoint.getSignature().getName());
		//Usuario user = (Usuario) joinPoint.getTarget();
		//System.out.println("@@@@@@  user:" + user.getNombre());
		System.out.println("*****************************************************");
	}
	*/
	
	
	@Before(value="execution(* com.company.services.UsuarioService.consultaUsuario(..)) && args(user,..))")
	public void logBefore(JoinPoint joinPoint,Usuario user) {
		System.out.println("*********************ADVISE BEFORE*******************");
		System.out.println("metodo logBefore() esta corriendo!");
		System.out.println("metodo interceptado : " + joinPoint.getSignature().getName());
		//Usuario user = (Usuario) joinPoint.getTarget();
		System.out.println("@@@@@@  user:" + user.getNombre());
		System.out.println("*****************************************************");
	}
	
	@After("execution(* com.company.services.UsuarioService.consultaUsuario(..))")
	public void logAfter(JoinPoint joinPoint) {
		System.out.println("****************ADVISE AFTER*************************");
		System.out.println("metodo logAfter() esta corriendo!");
		System.out.println("metodo interceptado : " + joinPoint.getSignature().getName());
		System.out.println("******************************************************");
 
	}
	
	@AfterReturning(
		      pointcut = "execution(* com.company.services.UsuarioService.agregarUsuario(..))",
		      returning= "result")
		   public void logAfterReturning(JoinPoint joinPoint, Object result) {
		    System.out.println("****************ADVISE AFTERRETURN********************");
			System.out.println("metodo logAfterReturning() esta corriendo!");
			System.out.println("metodo interceptado : " + joinPoint.getSignature().getName());
			System.out.println("El metodo retorna el valor : " + result);
			System.out.println("******************************************************");
		 
		   }
	
	@AfterThrowing(
		      pointcut = "execution(* com.company.services.UsuarioService.ProbarThrowException(..))",
		      throwing= "error")
		    public void logAfterThrowing(JoinPoint joinPoint, Throwable error) {
		    System.out.println("****************ADVISE AfterThrowing********************");
			System.out.println("metodo logAfterThrowing() esta corriendo!");
			System.out.println("metodo interceptado : " + joinPoint.getSignature().getName());
			System.out.println("Exception : " + error);
			System.out.println("********************************************************");
		 
		    }
	
	@Around("execution(* com.company.services.UsuarioService.procesarInformacion(..))")
	   public void logAround(ProceedingJoinPoint joinPoint) throws Throwable {
		System.out.println("****************ADVISE Around ****************************");
		System.out.println("metodo logAround() is running!");
		System.out.println("metodo interceptado : " + joinPoint.getSignature().getName());
		//System.out.println("parametros de entrada : " + Arrays.toString(joinPoint.getArgs()));
	 
		System.out.println("Ejecucion antes del procesamiento del metodo!");
		joinPoint.proceed(); //continue on the intercepted method
		System.out.println("Ejecucion luego del procesamiento del metodo!");
	 
		System.out.println("***********************************************************");
	 
	   }
}
