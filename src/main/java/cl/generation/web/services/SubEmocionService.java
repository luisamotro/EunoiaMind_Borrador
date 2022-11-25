package cl.generation.web.services;

import cl.generation.web.models.SubEmocion;


public interface SubEmocionService {

	public SubEmocion guardarSubEmocion(SubEmocion subemocion);
	public String eliminarSubEmocion(Long id);
	public String actualizarSubEmocion(SubEmocion subEmocion);
	public String obtenerSubEmocion(Long id);
	public String obtenerDesSubEmocion (Long id);

}
