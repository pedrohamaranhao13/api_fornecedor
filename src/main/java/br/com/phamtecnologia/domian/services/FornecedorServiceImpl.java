package br.com.phamtecnologia.domian.services;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.phamtecnologia.domian.entities.Fornecedor;
import br.com.phamtecnologia.domian.interfaces.FornecedorService;
import br.com.phamtecnologia.dtos.FornecedorPostDto;
import br.com.phamtecnologia.repositories.FornecedorRepository;

@Service
public class FornecedorServiceImpl implements FornecedorService{

	@Autowired
	FornecedorRepository fornecedorRepository;
	
	@Override
	public void create(FornecedorPostDto dto) throws Exception {
		
		Fornecedor fornecedor = new Fornecedor();
		
		fornecedor.setId(UUID.randomUUID());
		fornecedor.setNome(dto.getNome());
		fornecedor.setPreco(new BigDecimal(dto.getPreco()));
		fornecedor.setQuantidade(dto.getQuantidade());
		fornecedor.setDescricao(dto.getDescricao());
		
		fornecedorRepository.save(fornecedor);
	}

	@Override
	public void update(Fornecedor fornecedor) throws Exception {
		fornecedorRepository.save(fornecedor);
	}

	@Override
	public void delete(UUID id) throws Exception {
		Fornecedor fornecedor = findById(id);
		fornecedorRepository.delete(fornecedor);
	}

	@Override
	public List<Fornecedor> findAll() throws Exception {
		return (List<Fornecedor>) fornecedorRepository.findAll() ;
	}

	@Override
	public Fornecedor findById(UUID id) throws Exception {
		return fornecedorRepository.findById(id).get();
	}

	
}
