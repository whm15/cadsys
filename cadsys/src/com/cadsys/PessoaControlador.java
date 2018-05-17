package com.cadsys;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import java.util.List;

@ManagedBean(name = "pessoaControlador")
@SessionScoped
public class PessoaControlador {	
	
	@EJB
	private PessoaRepositorio pessoaRepositorio;
	private List<Pessoa> listPessoa;
//	private EstadoCivil estadoCivil;
	
	private String nome;
	private String cpf;


	public String cadastrarPessoa() {

		System.out.println("Teste de Cadastrar Pessoa");
		Pessoa novaPessoa = new Pessoa();
		novaPessoa.setNome(this.nome);
		novaPessoa.setCpf(this.cpf);
	//	novaPessoa.setEstadoCivil(this.estadoCivil);
		
		//chamada do repositorio
		
		this.pessoaRepositorio.cadastrar(novaPessoa);
		
		return null;
	}

	public String listarPessoa() {
		
		 this.listPessoa = this.pessoaRepositorio.listar();
		
		return "listagemPessoas.xhtml";
	}
	
	public String remover(Long id) {
		
		this.pessoaRepositorio.excluir(id);
		 this.listPessoa = this.pessoaRepositorio.listar();

		
		return null;
	}
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public PessoaRepositorio getPessoaRepositorio() {
		return pessoaRepositorio;
	}

	public void setPessoaRepositorio(PessoaRepositorio pessoaRepositorio) {
		this.pessoaRepositorio = pessoaRepositorio;
	}
	
	public List<Pessoa> getListPessoa() {
		return listPessoa;
	}

	public void setListPessoa(List<Pessoa> listPessoa) {
		this.listPessoa = listPessoa;
	}
	
	

}
