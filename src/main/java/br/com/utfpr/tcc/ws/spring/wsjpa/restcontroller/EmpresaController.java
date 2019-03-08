package br.com.utfpr.tcc.ws.spring.wsjpa.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.utfpr.tcc.ws.spring.wsjpa.dao.EmpresaDAO;
import br.com.utfpr.tcc.ws.spring.wsjpa.model.Empresa;
import br.com.utfpr.tcc.ws.spring.wsjpa.model.Resposta;

@RestController
@RequestMapping(value = "/empresas", consumes = "application/json", produces = "application/json")
public class EmpresaController {

	@Autowired
	private EmpresaDAO empresaDAO;
	
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<Resposta> listar() {
		
		List<Empresa> listaEmpresas = empresaDAO.listar();
		
		if(listaEmpresas == null) {
			return new ResponseEntity<Resposta>(HttpStatus.PRECONDITION_FAILED);
		}
		
		return new ResponseEntity<Resposta>(
				new Resposta(HttpStatus.OK.value(), "ok", listaEmpresas),
				HttpStatus.OK);
	}
	
}
