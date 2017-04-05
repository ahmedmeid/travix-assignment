package com.travix.busyflights.aspect;

import java.io.IOException;
import java.io.StringWriter;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

/**
 * 
 * @author Ahmed Eid
 * <br>
 * Logging Aspect
 */
@Aspect
@Component
public class LoggingAspect {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * The web service request and response logger
	 * @param joinPoint
	 * @param result
	 * @throws JsonGenerationException
	 * @throws JsonMappingException
	 * @throws IOException
	 */
	@AfterReturning(pointcut="execution(* org.springframework.web.client.RestTemplate.postForEntity(..))", returning ="result")
	public void logWebServiceRequestAndResponse(JoinPoint joinPoint, Object result) throws JsonGenerationException, JsonMappingException, IOException
	{
		Object[] args = joinPoint.getArgs();
		logger.info("Web service request sent to: "+args[0].toString());
		ObjectMapper mapper = new ObjectMapper();
		mapper.setSerializationInclusion(Include.NON_NULL);
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		StringWriter sw = new StringWriter();
		mapper.writeValue(sw, args[1]);
		logger.info(sw.toString());
		
		logger.info("Received response:");
		sw = new StringWriter();
		mapper.writeValue(sw,((ResponseEntity)result).getBody());
		logger.info(sw.toString());	
	}

}
