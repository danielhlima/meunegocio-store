package br.com.danielhlima.meunegociostore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielhlima.meunegociostore.domain.Product;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
