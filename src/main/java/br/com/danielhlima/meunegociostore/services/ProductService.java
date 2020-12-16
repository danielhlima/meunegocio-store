package br.com.danielhlima.meunegociostore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhlima.meunegociostore.domain.Product;
import br.com.danielhlima.meunegociostore.domain.Store;
import br.com.danielhlima.meunegociostore.exceptions.ProductNotFoundException;
import br.com.danielhlima.meunegociostore.exceptions.ProductsFromStoreNotFound;
import br.com.danielhlima.meunegociostore.repositories.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private StoreService storeService;
	
	public Product createOrUpdateProduct(Product prd) {
		return productRepository.save(prd);
	}
	
	public Product findById(int id) {
		
		Optional<Product> product = productRepository.findById(id);
		
		if(!product.isPresent())
			throw new ProductNotFoundException("id-"+id);
		
		return product.get();
	}
	
	public List<Product> findByStore(int storeId) {
		
		Store store = null;
		try {
			store = storeService.findById(storeId);
		}catch(Exception e) {
			throw new ProductsFromStoreNotFound("Store id: "+storeId);
		}
		
		Optional<List<Product>> products = Optional.of(productRepository.findByStore(store));	
		if(!products.isPresent() || products.get().isEmpty())
			throw new ProductsFromStoreNotFound("Store id: "+storeId);
		
		return products.get();
	}
}
