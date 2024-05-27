package br.com.phamtecnologia.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class FornecedorPostDto {

	@NotBlank(message = "Informe o nome do fornecedor.")
	private String nome;
	
	@NotBlank(message = "Informe a descrição do fornecedor.")
	private String descricao;
	
	@Min(value = 1, message = "Quantidade deve ser maior ou igual a 1.")
	private Double preco;
	
	@Min(value = 1, message = "Quantidade deve ser maior ou igual a 1.")
	private Integer quantidade;
}
