package cl.generation.web.services;

import cl.generation.web.models.Emocion;

public interface EmocionService {
	public Emocion guardarEmocion(Emocion emocion);
	public String eliminarEmocion(Long id);
	public String actualizarEmocion(Emocion emocion);
	public Emocion obtenerEmocion(Long id);

}
