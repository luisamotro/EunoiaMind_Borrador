package cl.generation.web.services;

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
	
	
	
	
	
	
}
