package br.com.danielhlima.meunegociostore.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielhlima.meunegociostore.domain.Product;
import br.com.danielhlima.meunegociostore.domain.Store;

public interface ProductRepository extends JpaRepository<Product, Integer> {

	List<Product> findByStore(Store store);
}
