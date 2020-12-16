package br.com.danielhlima.meunegociostore.exceptions;

public class ProductsFromStoreNotFound extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public ProductsFromStoreNotFound(String message) {
		super(message);
	}
}
