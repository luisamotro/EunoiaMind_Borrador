package cl.generation.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.generation.web.models.Usuario;
import cl.generation.web.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService{

	@Autowired 
	private UsuarioRepository usuarioRepository;
	 
	@Override
	public Usuario guardarUsuario (Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	
}
