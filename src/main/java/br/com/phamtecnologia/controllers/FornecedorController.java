package br.com.phamtecnologia.controllers;

import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.phamtecnologia.domian.entities.Fornecedor;
import br.com.phamtecnologia.domian.interfaces.FornecedorService;
import br.com.phamtecnologia.dtos.FornecedorGetDto;
import br.com.phamtecnologia.dtos.FornecedorPostDto;
import br.com.phamtecnologia.dtos.FornecedorPutDto;
import br.com.phamtecnologia.dtos.SuccessResponseDto;
import jakarta.validation.Valid;

@RestController
@RequestMapping(value = "/api/fornecedores")
public class FornecedorController {
	
	@Autowired
	FornecedorService fornecedorService;
	
	@Autowired
	ModelMapper modelMapper;
	
	@PostMapping
	public ResponseEntity<SuccessResponseDto> post(@RequestBody @Valid FornecedorPostDto dto) throws Exception{
		fornecedorService.create(dto);
		
		SuccessResponseDto response = new SuccessResponseDto();
		response.setStatus(HttpStatus.CREATED);;
		response.setMessage("Fornecedor cadastrado com sucesso.");
		
		return ResponseEntity.status(201).body(response);
	}
	
	@PutMapping
	public ResponseEntity<SuccessResponseDto> put(@RequestBody @Valid FornecedorPutDto dto) throws Exception{
		
		fornecedorService.update(dto);
		
		SuccessResponseDto response = new SuccessResponseDto();
		response.setStatus(HttpStatus.CREATED);;
		response.setMessage("Fornecedor atualizado com sucesso.");
		
		return ResponseEntity.status(200).body(response);
	}
	
	@DeleteMapping("{id}")
	public ResponseEntity<SuccessResponseDto> delete(@PathVariable("id") UUID id) throws Exception {
		fornecedorService.delete(id);
		
		SuccessResponseDto response = new SuccessResponseDto();
		response.setStatus(HttpStatus.CREATED);;
		response.setMessage("Fornecedor excluído com sucesso.");
		
		return ResponseEntity.status(200).body(response);
		
	}
	
	@GetMapping
	public List<FornecedorGetDto> getAll() throws Exception{

		List<Fornecedor> fonecedores = fornecedorService.findAll();
		List<FornecedorGetDto> result = modelMapper.map(fonecedores,
				new TypeToken<List<FornecedorGetDto>>() {}.getType());
		
		return result;
		
	}

}
