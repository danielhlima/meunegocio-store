package br.com.danielhlima.meunegociostore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.danielhlima.meunegociostore.domain.Store;

public interface StoreRepository extends JpaRepository<Store, Integer>{

}
