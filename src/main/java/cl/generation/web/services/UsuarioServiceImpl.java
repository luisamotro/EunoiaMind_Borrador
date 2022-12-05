package cl.generation.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.generation.web.models.Respuesta;
import cl.generation.web.models.SubEmocion;
import cl.generation.web.models.Usuario;
import cl.generation.web.repositories.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardarUsuario(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public String eliminarUsuario(Long id) {
		Boolean existe = usuarioRepository.existsById(id);

		if (existe) {
			// elimino el usuario pasando el id (pk)
			usuarioRepository.deleteById(id);
		} else {
			return "Usuario no existe en la tabla";
		}
		existe = usuarioRepository.existsById(id);
		// si es distinto de nulo, no fue eliminado
		if (existe) {
			return "Usuario no eliminado";
		}

		return "El usuario fue eliminado";
	}

	@Override
	public String modificarUsuario(Usuario usuario) {

		Boolean existe = usuarioRepository.existsById(usuario.getId());

		if (existe) {
			usuarioRepository.save(usuario);
			return "Usuario actualizado";
		}
		return "Usuario no actualizado";
	}

	@Override
	public Usuario obtenerUsuario(Long id) {
		// Optional<Usuario> user = usuarioRepository.findById(id);
		Boolean existe = usuarioRepository.existsById(id);

		if (existe) {
			Usuario user = usuarioRepository.findById(id).get();
			return user;
		}
		return null;
	}
	
	public String obtenerNombre(Long id) {
		// Optional<Usuario> user = usuarioRepository.findById(id);
		Boolean existe = usuarioRepository.existsById(id);

		if (existe) {
			Usuario user = usuarioRepository.findById(id).get();
			return user.getNombreUsuario();
		}
		return "el nombre de usuario no fue encontrado";
	}

	@Override
	public String obtenerCorreo(Long id) {
		Boolean existe = usuarioRepository.existsById(id);

		if (existe) {
			Usuario user = usuarioRepository.findById(id).get();
			return user.getCorreo();
		}
		return "el correo no fue encontrado";
	}
	
	@Override
	public String obtenerContraseña(Long id) {
		Boolean existe = usuarioRepository.existsById(id);

		if (existe) {
			Usuario user = usuarioRepository.findById(id).get();
			return user.getContraseña();
		}
		return "la contraseña no fue encontrada";
	}
	
	public List<Respuesta> obtenerRespuestas(Long id) {
		Boolean existe = usuarioRepository.existsById(id);

		if (existe) {
			Usuario user = usuarioRepository.findById(id).get();
			return user.getRespuestas();
		}
		return null;
	}
	

	public List<SubEmocion> obtenerSubEmociones(Long id) {
		Boolean existe = usuarioRepository.existsById(id);

		if (existe) {
			Usuario user = usuarioRepository.findById(id).get();
			return user.getSubemociones();
		}
		return null;
	}
	
}

