package com.inter.teste.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.inter.teste.entities.DigitoUnico;
import com.inter.teste.model.DigitoUnicoRequest;
import com.inter.teste.model.DigitoUnicoResponse;
import com.inter.teste.services.DigitoUnicoService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api")
public class DigitoUnicoResource {
	
	@Autowired
	private DigitoUnicoService service;
	
	@GetMapping(value = "/digitosunicos")
	@ApiOperation(value = "Retorna todos os digitos únicos")
	public ResponseEntity<List<DigitoUnicoResponse>> findAll() {
		List<DigitoUnicoResponse> list = service.findAll();
		return ResponseEntity.ok().body(list);
	}
	
	@GetMapping(value = "/digitounico/{id}")
	@ApiOperation(value = "Retorna um único digito e seu usuário")
	public ResponseEntity<DigitoUnicoResponse> findById(@PathVariable Long id){
		DigitoUnicoResponse digitoUnicoResponse = service.findById(id);
		return ResponseEntity.ok().body(digitoUnicoResponse);
	}
	
	@PostMapping(value = "/digitounico")
	@ApiOperation(value = "Adiciona um digito único")
	public ResponseEntity<DigitoUnicoResponse> insert(@RequestBody DigitoUnicoRequest obj){
		DigitoUnicoResponse digitoUnicoResponse = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(digitoUnicoResponse.getId()).toUri();
		return ResponseEntity.created(uri).body(digitoUnicoResponse);
	}
	
	@DeleteMapping(value = "/digitounico/{id}")
	@ApiOperation(value = "Remove um digito único")
	public ResponseEntity<Void> delete(@PathVariable Long id){
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
	
}
