package br.com.utfpr.tcc.ws.spring.wsjpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.utfpr.tcc.ws.spring.wsjpa.model.Usuario;

@Repository
@Transactional
public class UsuarioDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public Usuario busca(int matricula) {
		return manager.find(Usuario.class, matricula);
	}
	
	public void atualizar(Usuario usuario) {
		manager.merge(usuario);
	}
	
	public void inserir(Usuario usuario) {
		manager.persist(usuario);
	}
	
	public void remover(Usuario usuario) {
		manager.remove(usuario);
	}
}
