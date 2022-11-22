package cl.generation.web.services;

import cl.generation.web.models.Respuesta;

public interface RespuestaService {

	public Respuesta guardarRespuesta(Respuesta respuesta);
	public String modificarRespuesta(Respuesta respuesta);
	public Respuesta verRespuesta(Long id);
	public String verEmocion(Long id);
}
