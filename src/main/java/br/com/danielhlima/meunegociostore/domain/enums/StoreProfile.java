package br.com.danielhlima.meunegociostore.domain.enums;

public enum StoreProfile {
	STORE_FREE(3, "ROLE_STORE_FREE"),
	STORE_PRO(4, "ROLE_STORE_PRO");
	
	private int cod;
	private String description;
	
	private StoreProfile(int cod, String descricao) {
		this.cod = cod;
		this.description = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescription () {
		return description;
	}
	
	public static StoreProfile toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (StoreProfile x : StoreProfile.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
