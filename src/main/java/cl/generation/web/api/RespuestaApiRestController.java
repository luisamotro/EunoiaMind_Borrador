package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Respuesta;
import cl.generation.web.services.RespuestaServiceImpl;

@RestController
public class RespuestaApiRestController {

	@Autowired
	private RespuestaServiceImpl respuestaServiceImpl;
	
	
	// localhost:9085/guardar/respuesta LISTO
	
	@RequestMapping("/guardar/respuesta")
	public Respuesta guardarRespuesta(@RequestBody Respuesta respuesta) {
		return	respuestaServiceImpl.guardarRespuesta (respuesta); 		
	}
	
	// localhost:9085/modificar/respuesta LISTO
	
	@RequestMapping("/modificar/respuesta")
	public String modificarRespuesta(@RequestBody Respuesta respuesta) {
		if (respuesta.getId() != null) {
			String mensaje = respuestaServiceImpl.modificarRespuesta(respuesta);
			return mensaje;
		}
		return "NO existe respuesta para modificar";
	}
	
	@RequestMapping("/ver/respuestas")
	public Respuesta verRespuestas(@RequestParam(value = "id", required = true) Long id) {
		return respuestaServiceImpl.verRespuesta(id);
	}
	
	@RequestMapping("/ver/respuestas/emocion")
	public String verEmocion(@RequestParam(value = "id", required = true) Long id) {
		return respuestaServiceImpl.verEmocion(id);
	}
}
