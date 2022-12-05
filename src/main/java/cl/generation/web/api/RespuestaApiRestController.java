package cl.generation.web.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cl.generation.web.models.Emocion;
import cl.generation.web.models.Respuesta;
import cl.generation.web.models.Usuario;
import cl.generation.web.services.EmocionServiceImpl;
import cl.generation.web.services.RespuestaServiceImpl;
import cl.generation.web.services.UsuarioServiceImpl;

@RestController
public class RespuestaApiRestController {

	@Autowired
	private RespuestaServiceImpl respuestaServiceImpl;
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	@Autowired
	private EmocionServiceImpl emocionServiceImpl;
	
	// localhost:9085/guardar/respuesta OK
	
	@RequestMapping("/guardar/respuesta")
	public Respuesta guardarRespuesta(@RequestBody Respuesta respuesta, // lee el cuerpo de la consulta "json"
		@RequestParam (value="usuario_id", required = false)Long usuario_id, // lee el parametro en url
		@RequestParam (value="emocion_id", required = false)Long emocion_id){ //lee el parametro en url
		Usuario usuario = usuarioServiceImpl.obtenerUsuario(usuario_id); // obtiene el "usuario" a traves del id, y lo asigna a nueva variable
		Emocion emocion = emocionServiceImpl.obtenerEmocion(emocion_id); // obtiene la "emocion" a traves del id, y lo asigna a nueva variable
		respuesta.setUsuario(usuario); // setea el usuario encontrado a la respuesta
		respuesta.setEmocion(emocion);
		ArrayList<Respuesta> respondido = new ArrayList<Respuesta>();
		usuario.setRespuestas(respondido);//
		return	respuestaServiceImpl.guardarRespuesta (respuesta); 	// guarda la respuesta.
	}
	
	// localhost:9085/modificar/respuesta LISTO
	
	@RequestMapping("/modificar/respuesta")
	public String modificarRespuesta(@RequestBody Respuesta respuesta,
			@RequestParam (value="usuario_id", required = false)Long usuario_id,
			@RequestParam (value="emocion_id", required = false)Long emocion_id){
		if (respuesta.getId() != null) {
			Usuario usuario = usuarioServiceImpl.obtenerUsuario(usuario_id); // obtiene el "usuario" a traves del id, y lo asigna a nueva variable
			Emocion emocion = emocionServiceImpl.obtenerEmocion(emocion_id); // obtiene la "emocion" a traves del id, y lo asigna a nueva variable
			respuesta.setUsuario(usuario); // setea el usuario encontrado a la respuesta
			respuesta.setEmocion(emocion);
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
	
	@RequestMapping("ver/lista_de_respuestas")
	public List<Respuesta> obtenerListaRespuestas(){
		return respuestaServiceImpl.obtenerListaRespuestas();
		
	}
}
