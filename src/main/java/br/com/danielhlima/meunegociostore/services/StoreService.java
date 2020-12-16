package br.com.danielhlima.meunegociostore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhlima.meunegociostore.domain.Store;
import br.com.danielhlima.meunegociostore.exceptions.StoreNotFoundException;
import br.com.danielhlima.meunegociostore.repositories.StoreRepository;

@Service
public class StoreService {

	@Autowired
	private StoreRepository storeRepository;
	
	public Store createOrUpdateStore(Store store) {
		return storeRepository.save(store);
	}
	
	public Store findById(int id) {
		
		Optional<Store> store = storeRepository.findById(id);
		
		if(!store.isPresent())
			throw new StoreNotFoundException("id-"+id);
		
		return store.get();
	}

	public List<Store> findAll() {
		return storeRepository.findAll();
	}
}
