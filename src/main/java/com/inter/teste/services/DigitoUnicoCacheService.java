package com.inter.teste.services;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.inter.teste.model.DigitoUnicoCacheKey;

@Service
public class DigitoUnicoCacheService {

	private static final int MAX_CACHE = 10;

	private final Map<DigitoUnicoCacheKey, Long> cacheCalculo;
	
	public DigitoUnicoCacheService () {
		cacheCalculo = new LinkedHashMap<>() {
			protected boolean removeEldestEntry(Map.Entry<DigitoUnicoCacheKey, Long> eldest) {
				return this.size() > MAX_CACHE;
			}
		};
	}

	public Optional<Long> find(Long numero, Long quantidade) {
		Long resultado = cacheCalculo.get(new DigitoUnicoCacheKey(numero, quantidade));

		return Optional.ofNullable(resultado);
	}

	public void insert(long numero, long quantidade, long resultado) {
		DigitoUnicoCacheKey digitoUnicoCacheKey = new DigitoUnicoCacheKey(numero, quantidade);
		cacheCalculo.put(digitoUnicoCacheKey, resultado);
	}
}
