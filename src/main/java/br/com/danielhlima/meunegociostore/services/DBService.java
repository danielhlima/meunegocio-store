package br.com.danielhlima.meunegociostore.services;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.danielhlima.meunegociostore.domain.Product;
import br.com.danielhlima.meunegociostore.domain.Store;
import br.com.danielhlima.meunegociostore.domain.enums.StoreProfile;
import br.com.danielhlima.meunegociostore.repositories.ProductRepository;
import br.com.danielhlima.meunegociostore.repositories.StoreRepository;

@Service
public class DBService {

	@Autowired
	private StoreRepository storeRepository;
	
	@Autowired
	private ProductRepository productRepository;
	
	public void instantiateTestDataBase() throws ParseException{
					
		Store st1 = new Store(null, "Loja Dom Pedro", "dompedro@dompedro.com", "Nesta loja você encontra uma variedade de produtos no ramo da construção civil", 3, StoreProfile.STORE_FREE);
		st1.getPhones().addAll(Arrays.asList("111111111", "222222222"));
		Store st2 = new Store(null, "Loja Dona Ana", "donaana@donaana.com", "A loja dos melhores quitutes", 4, StoreProfile.STORE_PRO);
		st2.getPhones().addAll(Arrays.asList("333333333", "444444444"));
		Store st3 = new Store(null, "Loja Dom Clementino", "domclementino@domclementino.com", "Encontre aqui tudo em informática", 7, StoreProfile.STORE_FREE);
		st3.getPhones().addAll(Arrays.asList("555555555", "6666666666"));
		
		storeRepository.saveAll(Arrays.asList(st1, st2, st3));
		
		
		Product pd1 = new Product(null, "Tilojo Baiano", 1.00, 10000, st1);
		Product pd2 = new Product(null, "Bloco de concreto", 1.50, 10000, st1);
		Product pd3 = new Product(null, "Cano PVC 5mm", 3.20, 10000, st1);
		Product pd4 = new Product(null, "Cano PVC 10mm", 7.40, 10000, st1);
		Product pd5 = new Product(null, "Resistência Lorenzzeti 5400w", 30.00, 10000, st1);
		Product pd6 = new Product(null, "Chave Inglesa 8mm", 5.00, 100, st1);
		Product pd7 = new Product(null, "Chave Inglesa 9mm", 5.00, 150, st1);
		Product pd8 = new Product(null, "Chave Inglesa 10mm", 6.00, 30, st1);
		Product pd9 = new Product(null, "Alicate de bico", 15.00, 10, st1);
		Product pd10 = new Product(null, "Alicate de corte", 17.00, 2, st1);
		Product pd11 = new Product(null, "Estilete", 8.00, 40, st1);
		
		Product pd12 = new Product(null, "Brigadeiro Gourmet", 5.00, 100, st2);
		Product pd13 = new Product(null, "Beijinho gourmet", 5.00, 150, st2);
		Product pd14 = new Product(null, "Bolo Floresta Negra", 6.00, 30, st2);
		Product pd15 = new Product(null, "Bolo Formigueiro", 15.00, 10, st2);
		Product pd16 = new Product(null, "Pudim de Leite Condensado", 17.00, 2, st2);
		Product pd17 = new Product(null, "Cocada", 8.00, 40, st2);
		
		Product pd18 = new Product(null, "Teclado sem fio", 5.00, 100, st3);
		Product pd19 = new Product(null, "Teclado com fio", 5.00, 150, st3);
		Product pd20 = new Product(null, "Mouse sem fio", 6.00, 30, st3);
		Product pd21 = new Product(null, "Mouse com fio", 15.00, 10, st3);
		Product pd22 = new Product(null, "Cabo HDMI", 17.00, 2, st3);
		Product pd23 = new Product(null, "Cabo VGA", 8.00, 40, st3);
		
		productRepository.saveAll(Arrays.asList(pd1, pd2, pd3, pd4, pd5, pd6,
				pd7, pd8, pd9, pd10, pd11, pd12, pd13, pd14, pd15, pd16,
				pd17, pd18, pd19, pd20, pd21, pd22, pd23));
	}
}
