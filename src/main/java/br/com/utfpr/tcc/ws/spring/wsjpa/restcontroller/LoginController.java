package br.com.utfpr.tcc.ws.spring.wsjpa.restcontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.utfpr.tcc.ws.spring.wsjpa.dao.UsuarioDAO;
import br.com.utfpr.tcc.ws.spring.wsjpa.model.Resposta;
import br.com.utfpr.tcc.ws.spring.wsjpa.model.Usuario;

@RestController
@RequestMapping(consumes = "application/json", produces = "application/json")
public class LoginController {

	@Autowired
	private UsuarioDAO usuarioDAO;
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public ResponseEntity<Resposta> login(@RequestBody Usuario usuarioEntrada) {
		
		Usuario usuarioLogin = usuarioDAO.busca(usuarioEntrada.getMatricula());
		
		if(usuarioLogin == null) {
			return configuraRetornoErro(HttpStatus.INTERNAL_SERVER_ERROR, "Usuario inexistente");
		}
		
		if(!(usuarioLogin.mesmaSenha(usuarioEntrada.getSenha()))) {
			return configuraRetornoErro(HttpStatus.PRECONDITION_FAILED, "Usuario ou senha incorretos");
		}
		
		return new ResponseEntity<Resposta>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.POST)
	public ResponseEntity<Resposta> cadastrar(@RequestBody Usuario usuarioEntrada) {
		
		try {
			usuarioDAO.inserir(usuarioEntrada);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Resposta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Resposta>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.PUT)
	public ResponseEntity<Resposta> atualizar(@RequestBody Usuario usuarioEntrada) {
		
		try {
			usuarioDAO.atualizar(usuarioEntrada);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Resposta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Resposta>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/cadastrar", method=RequestMethod.DELETE)
	public ResponseEntity<Resposta> remover(@RequestBody Usuario usuarioEntrada) {
		
		try {
			usuarioDAO.remover(usuarioEntrada);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<Resposta>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<Resposta>(HttpStatus.OK);
	}
	private ResponseEntity<Resposta> configuraRetornoErro(HttpStatus status, String msg) {
		return new ResponseEntity<Resposta>(new Resposta(status.value(), msg), status);
	}
}