package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.generation.web.models.Emocion;
import cl.generation.web.models.SubEmocion;
import cl.generation.web.services.SubEmocionServiceImpl;

@RestController
public class SubEmocionApiRestController {

	@Autowired
	private SubEmocionServiceImpl subEmocionServiceImpl;

	// htps:localhost:9081/guardar/subemociones
	@RequestMapping("/guardar/subemociones")
	public SubEmocion guardarSubEmocion(@RequestBody SubEmocion subemocion) {
		/*
		 * { 
		 * "nombreSubE":"chill",
		 * "descripcion":"sentimiendo de relajacion", 
		 *  }
		 */
		return subEmocionServiceImpl.guardarSubEmocion(subemocion); // "Emocion guardada";

	}
}

	
	
	

