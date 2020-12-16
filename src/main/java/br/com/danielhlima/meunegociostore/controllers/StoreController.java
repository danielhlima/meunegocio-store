package br.com.danielhlima.meunegociostore.controllers;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.danielhlima.meunegociostore.domain.Store;
import br.com.danielhlima.meunegociostore.services.StoreService;

@RestController
@RequestMapping("stores")
public class StoreController {

	@Autowired
	private StoreService storeService;
	
	@GetMapping("/test")
	public ResponseEntity<String> smokeHealthCheck() {
		return ResponseEntity.ok("Serviço Rodando");
	}
	
	@GetMapping()
	public ResponseEntity<List<Store>> findAll() {
		List<Store> list = storeService.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@PostMapping()
	public ResponseEntity<Store> create(@Valid @RequestBody Store store){
		Store savedStore = storeService.createOrUpdateStore(store);
		URI location = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedStore.getId()).toUri();
		
		return ResponseEntity.created(location).build();
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Store> retrieveStore(@PathVariable int id) {
		Store store =  storeService.findById(id);
		return ResponseEntity.ok().body(store);
	}
}
