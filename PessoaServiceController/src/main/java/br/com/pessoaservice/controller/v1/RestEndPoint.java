package br.com.pessoaservice.controller.v1;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.pessoaservice.controller.model.Pessoa;
import br.com.pessoaservice.controller.repository.PessoaMapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value = "pessoas")
@Path("/pessoa")
public class RestEndPoint {
	@Autowired
	private PessoaMapper pessoaMapper;
	
	@ApiOperation(value = "Lista todas pessoas da base de dados em formato JSON")
	@GET
	@Path("/listarPessoasJSON")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> listaPessoas(){
		return pessoaMapper.listaTodas();
    }
	
	@ApiOperation(value = "Lista pessoas da base de dados filtrador por ID")
	@GET
	@Path("/listarPessoasPorId")
    @Produces(MediaType.APPLICATION_JSON)
	public List<Pessoa> listaPessoasPorID(@QueryParam("idPessoa") Integer idPessoa){
		return pessoaMapper.listaPessoasPorID(idPessoa);
    } 
	
	@ApiOperation(value = "Cadastra pessoa na base de dados")
	@POST
	@Path("/cadastrarPessoa")
    @Produces(MediaType.APPLICATION_JSON)
	public void cadastrarPessoa(Pessoa pessoa){
		pessoaMapper.cadastrarPessoa(pessoa);
    }
	
	@ApiOperation(value = "Atualiza pessoa na base de dados")
	@PUT
	@Path("/atualizarPessoa")
    @Produces(MediaType.APPLICATION_JSON)
	public void atualizarPessoa(@RequestBody Pessoa pessoa) {
		pessoaMapper.atualizarPessoa(pessoa);
	}
	
	@ApiOperation(value = "Deleta pessoa da base de dados")
	@DELETE
	@Path("/deletarPessoa/{idPessoa}")
    @Produces(MediaType.APPLICATION_JSON)
	public void deletarPessoa(@PathParam("idPessoa") int idPessoa) {
		pessoaMapper.deletarPessoa(idPessoa);
	}
}