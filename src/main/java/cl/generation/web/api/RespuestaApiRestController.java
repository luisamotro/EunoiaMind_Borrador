package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Respuesta;
import cl.generation.web.services.RespuestaServiceImpl;

@RestController
public class RespuestaApiRestController {

	@Autowired
	private RespuestaServiceImpl respuestaServiceImpl;
	
	
	// localhost:9081/guardar/respuesta
	
	@RequestMapping("/guardar/respuesta")
	public Respuesta guardarRespuesta(@RequestBody Respuesta respuesta) {
		return	respuestaServiceImpl.guardarRespuesta (respuesta); 		
	}
}
