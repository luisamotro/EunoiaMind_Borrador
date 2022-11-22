package cl.generation.web.services;

import cl.generation.web.models.Usuario;

public interface UsuarioService {
	public Usuario guardarUsuario(Usuario usuario);
	public String eliminarUsuario(Long id);
	public String modificarUsuario(Usuario usuario);
	public Usuario obtenerUsuario(Long id);
}
