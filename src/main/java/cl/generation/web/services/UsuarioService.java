package cl.generation.web.services;

import java.util.List;

import cl.generation.web.models.Respuesta;
import cl.generation.web.models.SubEmocion;
import cl.generation.web.models.Usuario;

public interface UsuarioService {
	public Usuario guardarUsuario(Usuario usuario);
	public String eliminarUsuario(Long id);
	public String modificarUsuario(Usuario usuario);
	public Usuario obtenerUsuario(Long id);
	public String obtenerNombre(Long id);
	public String obtenerCorreo(Long id);
	public String obtenerContraseña(Long id);
	public List<Respuesta> obtenerRespuestas(Long id);
	public List<SubEmocion> obtenerSubEmociones(Long id);
}
