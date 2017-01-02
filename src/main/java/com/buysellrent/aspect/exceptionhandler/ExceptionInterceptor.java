package com.buysellrent.aspect.exceptionhandler;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import com.buysellrent.domain.response.ErrorResponse;
import com.buysellrent.exception.BussinesException;
import com.buysellrent.util.*;

/**
 * 
 * @author taner cakiroglu
 *
 */

@Aspect
public class ExceptionInterceptor {

	@Around(value = "com.buysellrent.aspect.exceptionhandler.ExceptionManager.handleExcepiton()" + "&& target(bean) "
			+ "&& @annotation(com.buysellrent.aspect.exceptionhandler.HandleException)"
			+ "&& @annotation(handleExcpetion)", argNames = "bean,handleExcpetion")
	public Object handleExcpetion(ProceedingJoinPoint joinPoint, Object bean, HandleException handleExcpetion)
			throws Throwable {

		Object ret = null;
		try {
			ret = joinPoint.proceed();
			return ret;
		} catch (BussinesException bex) {
			ErrorResponse error = new ErrorResponse(Constants.BUSSINESSEXCEPTION,false);
			error.setError(bex.getMessage());
			return Util.constructJSON(error);
		} catch (Exception ex) {
			ex.printStackTrace();
			ErrorResponse error = new ErrorResponse(ex.getMessage(),false);
			error.setError(ex.getStackTrace());
			return Util.constructJSON(error);
		}

	}

}