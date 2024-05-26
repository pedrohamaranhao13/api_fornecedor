package br.com.phamtecnologia.domian.interfaces;

import java.util.List;
import java.util.UUID;

import br.com.phamtecnologia.domian.entities.Fornecedor;


public interface FornecedorService {

	public void post(Fornecedor fornecedor) throws Exception;
	public void put(Fornecedor fornecedor) throws Exception;
	public void delete(UUID id) throws Exception;
	
	List<Fornecedor> findAll() throws Exception;
	Fornecedor findById(UUID id) throws Exception;
	
}
