package br.com.pessoaservice.controller.model;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "Pessoa")
public class Pessoa implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@ApiModelProperty(value = "Id da pessoa.", required=true)
	private Integer idPessoa;
	
	@ApiModelProperty(value = "Nome da pessoa.", required=true)
	private String nome;
	
	@ApiModelProperty(value = "Idade da pessoa.", required=true)
	private int idade;
}