package org.Tayana.Sprinb_Boot_RedisClient.exception;

import org.Tayana.Sprinb_Boot_RedisClient.dto.ResponseStructure;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class MerchantHandler extends ResponseEntityExceptionHandler 
{
	
	@ExceptionHandler(IdNotFound.class)
	public ResponseEntity<ResponseStructure<String>> IdNotFound(IdNotFound found)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData("invalid ID");
		structure.setMessage(found.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	
	}
	@ExceptionHandler(InvalidCredentials.class)
	public ResponseEntity<ResponseStructure<String>> InvalidCredentials(InvalidCredentials credentials)
	{
		ResponseStructure<String> structure=new ResponseStructure<String>();
		structure.setData("invalid credentials");
		structure.setMessage(credentials.getMessage());
		structure.setStatusCode(HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<ResponseStructure<String>>(structure,HttpStatus.NOT_FOUND);
	
	}
}
