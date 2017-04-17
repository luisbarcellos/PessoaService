package br.com.pessoaservice.controller.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import br.com.pessoaservice.controller.model.Pessoa;

public interface PessoaMapper {
	@Select("select * from pessoa")
	@Results(value={
		@Result(column="idpessoa",property="idPessoa"),
		@Result(column="nome",property="nome"),
		@Result(column="idade",property="idade")})
	public List<Pessoa> listaTodas();
	
	@Select("select * from pessoa where idpessoa = #{idPessoa}")
	@Results(value={
		@Result(column="idpessoa",property="idPessoa"),
		@Result(column="nome",property="nome"),
		@Result(column="idade",property="idade")})
	public List<Pessoa> listaPessoasPorID(Integer idPessoa);
	
	@Insert("insert into pessoa(nome, idade) values (#{nome}, #{idade})")
	@Options(useGeneratedKeys=true, keyProperty = "idpessoa")
	public void cadastrarPessoa(Pessoa pessoa);
	
	@Update("update pessoa set nome=#{nome}, idade=#{idade} where idpessoa = #{idPessoa}")
	public void atualizarPessoa(Pessoa pessoa);
	
	@Delete("delete from pessoa where idpessoa = #{idPessoa}")
	public void deletarPessoa(int idPessoa);
}