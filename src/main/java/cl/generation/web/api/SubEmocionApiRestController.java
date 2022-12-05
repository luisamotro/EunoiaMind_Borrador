package cl.generation.web.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import cl.generation.web.models.Emocion;
import cl.generation.web.models.SubEmocion;
import cl.generation.web.models.Usuario;
import cl.generation.web.services.EmocionServiceImpl;
import cl.generation.web.services.SubEmocionServiceImpl;
import cl.generation.web.services.UsuarioServiceImpl;

@RestController
public class SubEmocionApiRestController {

	@Autowired
	private SubEmocionServiceImpl subEmocionServiceImpl;
	@Autowired
	private EmocionServiceImpl emocionServiceImpl;
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;

	// htps:localhost:9085/guardar/subemocion
	@RequestMapping("/guardar/subemocion")
	public SubEmocion guardarSubEmocion(@RequestBody SubEmocion subEmocion,
			@RequestParam(value = "usuario_id", required = false) Long usuario_id,
			@RequestParam(value = "emocion_id", required = false) Long emocion_id) {
		Usuario usuario = usuarioServiceImpl.obtenerUsuario(usuario_id);
		Emocion emocion = emocionServiceImpl.obtenerEmocion(emocion_id);
		subEmocion.setUsuario(usuario); // se asigna el usuario/creador a la subemocion
		subEmocion.setEmocion(emocion); // se asigna la emocion a la subemocion agregada
		return subEmocionServiceImpl.guardarSubEmocion(subEmocion); // se guarda la subemocion
	}

	// htps:localhost:9085/eliminar/subemocion
	@RequestMapping("/eliminar/subemocion")
	public String eliminarSubEmocion(@RequestParam(value = "id", required = false) Long id) {
		String respuesta = subEmocionServiceImpl.eliminarSubEmocion(id);
		return respuesta;
	}

	// http://localhost:9085/actualizar/subemocion
	@RequestMapping("/actualizar/subemocion")
	public String actualizarSubEmocion(@RequestBody SubEmocion subEmocion,
			@RequestParam(value = "usuario_id", required = false) Long usuario_id,
			@RequestParam(value = "emocion_id", required = false) Long emocion_id) { 
		Usuario usuario = usuarioServiceImpl.obtenerUsuario(usuario_id);
		Emocion emocion = emocionServiceImpl.obtenerEmocion(emocion_id);
		subEmocion.setUsuario(usuario);
		subEmocion.setEmocion(emocion);
		
			return subEmocionServiceImpl.actualizarSubEmocion(subEmocion);
		}


	@RequestMapping("/obtener/subemocion")
	public String obtenerSubEmocion(@RequestParam(value = "id", required = true) Long id) {
		return subEmocionServiceImpl.obtenerSubEmocion(id);
	}

	@RequestMapping("/obtener/DesSubEmocion")
	public String obtenerDesSubEmocion(@RequestParam(value = "id", required = true) Long id) {
		return subEmocionServiceImpl.obtenerDesSubEmocion(id);
	}

}
