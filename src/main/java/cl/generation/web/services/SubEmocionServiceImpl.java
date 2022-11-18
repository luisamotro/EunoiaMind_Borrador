package cl.generation.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.generation.web.models.SubEmocion;
import cl.generation.web.repositories.SubEmocionRepository;

@Service
public class SubEmocionServiceImpl implements SubEmocionService {

	@Autowired 
	private SubEmocionRepository subemocionRepository;
	 
	@Override
	public SubEmocion guardarSubEmocion (SubEmocion subEmocion) {
		return subemocionRepository.save(subEmocion);
	}
	
	
	
	
}
