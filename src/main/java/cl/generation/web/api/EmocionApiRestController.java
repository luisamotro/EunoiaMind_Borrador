package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import cl.generation.web.models.Emocion;
import cl.generation.web.services.EmocionServiceImpl;

@RestController
public class EmocionApiRestController {

	@Autowired
	private EmocionServiceImpl emocionServiceImpl;

	// htps:localhost:9081/guardar/emociones
	@RequestMapping("/guardar/emociones")
	public Emocion guardarEmocion(@RequestBody Emocion emocion) {
		/*
		 * { 
		 * "nombreEmocion":"Feliz",
		 * "descripcion":"sentimiendo de felicidad",
		 * "pregunta": "¿porque estas tan feliz?" ,
		 *  "tipo": "6" 
		 *  }
		 */
		return emocionServiceImpl.guardarEmocion(emocion); // "Emocion guardada";

	}
}
