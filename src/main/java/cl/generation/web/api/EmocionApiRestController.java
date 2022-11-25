package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.generation.web.models.Emocion;
import cl.generation.web.services.EmocionServiceImpl;

@RestController
public class EmocionApiRestController {

	@Autowired
	private EmocionServiceImpl emocionServiceImpl;

	//localhost:9085/guardar/emociones
	@RequestMapping("/guardar/emociones")
	public Emocion guardarEmocion(@RequestBody Emocion emocion) {
		return emocionServiceImpl.guardarEmocion(emocion); // "Emocion guardada";

	}

	//localhost:9085/eliminar/emociones
	@RequestMapping("/eliminar/emociones")
	public String eliminarEmocion(@RequestParam(value = "id", required = false) Long id) {
		return emocionServiceImpl.eliminarEmocion(id);
	}

	//localhost:9085/actualizar/emociones
	@RequestMapping("/actualizar/emociones")
	public String actualizarEmocion(@RequestBody Emocion emocion) {
		if (emocion.getId() != null) {
			return emocionServiceImpl.actualizarEmocion(emocion);
		}
		return "No se actualizó ninguna emoción";
	}

	//localhost:9085/obtener/emociones
	@RequestMapping("/obtener/emociones")
	public Emocion obtenerEmocion(@RequestParam(value = "id", required = true) Long id) {
		return emocionServiceImpl.obtenerEmocion(id);
	}

}
