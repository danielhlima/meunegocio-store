package br.com.danielhlima.meunegociostore.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.danielhlima.meunegociostore.domain.Product;
import br.com.danielhlima.meunegociostore.services.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	
	
	@GetMapping("/test")
	public ResponseEntity<String> smokeHealthCheck() {
		return ResponseEntity.ok("Serviço Rodando");
	}
	
	@GetMapping("/store/{storeId}")
	public ResponseEntity<List<Product>> getProductsByStore(@PathVariable int storeId){		
		List<Product> products = productService.findByStore(storeId);
		return ResponseEntity.ok().body(products);
	}
}
