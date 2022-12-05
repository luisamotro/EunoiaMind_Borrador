package cl.generation.web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.generation.web.models.Respuesta;
import cl.generation.web.repositories.RespuestaRepository;

@Service
public class RespuestaServiceImpl implements RespuestaService{

	@Autowired 
	private RespuestaRepository respuestaRepository;
	 
	@Override
	public  Respuesta guardarRespuesta (Respuesta respuesta) {
		return respuestaRepository.save(respuesta);
	}

	@Override
	public String modificarRespuesta(Respuesta respuesta) {
		Boolean existe = respuestaRepository.existsById(respuesta.getId()); // revisar si el ID existe.
		if(existe) { // siesque existe.
			respuestaRepository.save(respuesta); // guarda la respuesta.
			return "Respuesta modificada correctamente";
		}
		return "no se pudo modificar la respuesta";
	}

	@Override
	public Respuesta verRespuesta(Long id) {
		Boolean existe = respuestaRepository.existsById(id); // revisar si el ID existe.
		if(existe) { // siesque existe.
			Respuesta respuesta = respuestaRepository.findById(id).get(); // encuentra la respuesta con ese ID.
				return respuesta; // retorna la respuesta.
			}
		return null;
	}

	@Override
	public String verEmocion(Long id) {
		Boolean existe = respuestaRepository.existsById(id);
		if(existe) { // siesque existe.
			Respuesta respuesta = respuestaRepository.findById(id).get(); // encuentra la respuesta con ese ID.
				return respuesta.getEmocion().getNombreEmocion(); // retorna la respuesta.
			}
		return null;
	}

	public List<Respuesta> obtenerListaRespuestas() {
		return respuestaRepository.findAll();
	}
	
		
}
