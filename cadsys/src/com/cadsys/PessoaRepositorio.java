package com.cadsys;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class PessoaRepositorio {
	
	@PersistenceContext(name="cadsys")
	private EntityManager manager;
	
	public void cadastrar (Pessoa pessoa) {
		this.manager.persist(pessoa);
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Pessoa> listar(){
		List<Pessoa> result = null;
		
		Query consulta =  this.manager.createQuery("FROM Pessoa pessoa");
		
		result =  (List<Pessoa>) consulta.getResultList();
		
		return result;
	}
	
	public void excluir(Long idPessoa) {
		this.manager.remove(this.manager.getReference(Pessoa.class, idPessoa));
	}
	

}