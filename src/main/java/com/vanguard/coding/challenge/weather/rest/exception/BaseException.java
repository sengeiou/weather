/**
 * 
 */
package com.vanguard.coding.challenge.weather.rest.exception;

/**
 * @author praveendas
 *
 */
public class BaseException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;


	public BaseException() {
        super();
    }

    public BaseException(String message) {
        super(message);
    }

}
