package br.com.utfpr.tcc.ws.spring.wsjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.utfpr.tcc.ws.spring.wsjpa.model.Empresa;

@Repository
@Transactional
public class EmpresaDAO {

	@PersistenceContext
	private EntityManager manager;
	
	public List<Empresa> listar() {
		return manager.createNamedQuery("select * from Empresa e", Empresa.class)
				.getResultList();
	}
}
