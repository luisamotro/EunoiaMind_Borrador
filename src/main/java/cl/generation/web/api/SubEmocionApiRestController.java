package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.generation.web.models.Emocion;
import cl.generation.web.models.SubEmocion;
import cl.generation.web.models.Usuario;
import cl.generation.web.services.SubEmocionServiceImpl;

@RestController
public class SubEmocionApiRestController {

	@Autowired
	private SubEmocionServiceImpl subEmocionServiceImpl;

	// htps:localhost:9085/guardar/subemocion
	@RequestMapping("/guardar/subemocion")
	public SubEmocion guardarSubEmocion(@RequestBody SubEmocion subemocion) {
		/*
		 * { "nombreSubE":"chill", 
		 * "descripcion":"sentimiendo de relajacion"
		 * }
		 */
		return subEmocionServiceImpl.guardarSubEmocion(subemocion);
	}
	
	// htps:localhost:9085/eliminar/subemocion
	@RequestMapping("/eliminar/subemocion")
	public String eliminarSubEmocion(@RequestParam(value = "id", required = false) Long id) {
		String respuesta = subEmocionServiceImpl.eliminarSubEmocion(id);
		return respuesta;
	}

	// http://localhost:9085/actualizar/subemocion
	@RequestMapping("/actualizar/subemocion")
	public String actualizarSubEmocion(@RequestBody SubEmocion subEmocion) {
		return subEmocionServiceImpl.actualizarSubEmocion(subEmocion); 
	}
	

	@RequestMapping("/obtener/subemocion")
	public String obtenerSubEmocion (@RequestParam(value = "id", required = true ) Long id) {
		return subEmocionServiceImpl.obtenerSubEmocion(id);
	}
	
	@RequestMapping("/obtener/DesSubEmocion")
	public String obtenerDesSubEmocion (@RequestParam(value = "id", required = true ) Long id) {
		return subEmocionServiceImpl.obtenerDesSubEmocion(id);
	}
	

}
