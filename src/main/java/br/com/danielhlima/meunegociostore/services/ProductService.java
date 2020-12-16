package br.com.danielhlima.meunegociostore.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhlima.meunegociostore.domain.Product;
import br.com.danielhlima.meunegociostore.exceptions.ProductNotFoundException;
import br.com.danielhlima.meunegociostore.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	public Product createOrUpdateProduct(Product prd) {
		return productRepository.save(prd);
	}
	
	public Product findById(int id) {
		
		Optional<Product> product = productRepository.findById(id);
		
		if(!product.isPresent())
			throw new ProductNotFoundException("id-"+id);
		
		return product.get();
	}
}
