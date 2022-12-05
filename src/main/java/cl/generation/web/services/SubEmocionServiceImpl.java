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
	public SubEmocion guardarSubEmocion(SubEmocion subEmocion) {
		return subemocionRepository.save(subEmocion);
	}

	@Override
	public String eliminarSubEmocion(Long id) {
		Boolean existe = subemocionRepository.existsById(id);

		if (existe) {
			subemocionRepository.deleteById(id);
		} else {
			return "SubEmocion no existe";
		}
		existe = subemocionRepository.existsById(id);
		if (existe) {
			return "SubEmocion no eliminada";
		}
		return "La SubEmocion fue eliminada";
	}

	@Override
	public String actualizarSubEmocion(SubEmocion subEmocion) {
		Boolean existe = subemocionRepository.existsById(subEmocion.getId());
		
		if(existe) {
			subemocionRepository.save(subEmocion);
			return "SubEmocion actualizada";
		}
		return "SubEmocion no actualizada";
		}

	@Override
	public String obtenerSubEmocion(Long id) {
		Boolean existe = subemocionRepository.existsById(id);
		if (existe) {
			SubEmocion subEmocion = subemocionRepository.findById(id).get();
			return subEmocion.getNombreSubEmocion();
			
		}
		return null;
	}
	
	@Override
	public String obtenerDesSubEmocion(Long id) {
		Boolean existe = subemocionRepository.existsById(id);
		if (existe) {
			SubEmocion subEmocion = subemocionRepository.findById(id).get();
			return subEmocion.getDescripcionSubEmocion();
			
		}
		return null;
	}
	
	
	
	
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

