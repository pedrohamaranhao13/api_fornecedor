package br.com.phamtecnologia.domian.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.phamtecnologia.domian.entities.Fornecedor;
import br.com.phamtecnologia.dtos.FornecedorPostDto;


public interface FornecedorService {

	public void create(FornecedorPostDto dto) throws Exception;
	public void update(Fornecedor fornecedor) throws Exception;
	public void delete(UUID id) throws Exception;
	
	List<Fornecedor> findAll() throws Exception;
	Fornecedor findById(UUID id) throws Exception;
	
}
