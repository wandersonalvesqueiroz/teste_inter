package com.inter.teste.services;

import java.math.BigInteger;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inter.teste.entities.DigitoUnico;
import com.inter.teste.entities.Usuario;
import com.inter.teste.model.DigitoUnicoRequest;
import com.inter.teste.model.DigitoUnicoResponse;
import com.inter.teste.repository.DigitoUnicoRepository;

@Service
public class DigitoUnicoService {

	@Autowired
	private DigitoUnicoRepository repository;
	
	@Autowired
	private DigitoUnicoCacheService cacheService;

	public List<DigitoUnicoResponse> findAll() {
		return repository.findAll()
				.stream()
				.map(this::mapDigitoUnicoResponse)
				.collect(Collectors.toList());
	}

	public DigitoUnicoResponse findById(Long id) {
		DigitoUnico digitoUnico = repository.findById(id).get();
		
		return mapDigitoUnicoResponse(digitoUnico);
	}

	public DigitoUnicoResponse insert(DigitoUnicoRequest obj) {
		Usuario usuario = new Usuario();
		usuario.setId(obj.getUsuario());
		
		long resultado = calculaDigito(obj.getNumero(), obj.getQuantidade());
		DigitoUnico digitoUnico = new DigitoUnico(obj.getNumero(), obj.getQuantidade(), resultado, usuario);
		
		
		
		return mapDigitoUnicoResponse(repository.save(digitoUnico));
	}

	public void delete(Long id) {
		repository.deleteById(id);
	}

	public Long calculaDigito(Long numero, Long quantidade) {
		
		Optional<Long> resultado = cacheService.find(numero, quantidade);
		
		if(resultado.isPresent()) {
			return resultado.get();
		}
		
		String k = "";
		if(quantidade > 1) {
			for(int i = 0; i < quantidade ; i++){
				k += String.valueOf(numero);
			}
		}else {
			k = String.valueOf(numero);
		}
		
		BigInteger p = new BigInteger(k);
		
		long resultadoCalculo = p.mod(BigInteger.valueOf(9)).equals(BigInteger.ZERO) ? 9 : p.mod(BigInteger.valueOf(9)).longValue();
		
		cacheService.insert(numero, quantidade, resultadoCalculo);
		
		return resultadoCalculo;
	}
	
	private DigitoUnicoResponse mapDigitoUnicoResponse(DigitoUnico digitoUnico) {
		return new DigitoUnicoResponse(
			digitoUnico.getId(),
			digitoUnico.getNumero(),
			digitoUnico.getQuantidade(),
			digitoUnico.getResultado(),
			digitoUnico.getUsuario().getId()
		);
	}
	

}
