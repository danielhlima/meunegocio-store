package br.com.danielhlima.meunegociostore.exceptions;

public class StoreNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public StoreNotFoundException(String message) {
		super(message);
	}
}