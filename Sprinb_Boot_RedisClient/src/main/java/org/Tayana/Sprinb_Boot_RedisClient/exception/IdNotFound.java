package org.Tayana.Sprinb_Boot_RedisClient.exception;

public class IdNotFound extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() 
	{
		return "invalid Id";
	}

}
