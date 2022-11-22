package cl.generation.web.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cl.generation.web.models.Emocion;
import cl.generation.web.repositories.EmocionRepository;

@Service
public class EmocionServiceImpl implements EmocionService {
	@Autowired
	private EmocionRepository emocionRepository;

	@Override
	public Emocion guardarEmocion(Emocion emocion) {
		return emocionRepository.save(emocion);
	}

	@Override
	public String eliminarEmocion(Long id) {
		Boolean existe = emocionRepository.existsById(id);
		if (existe) {
			emocionRepository.deleteById(id);
			return "Emoción eliminada";
		} else {
			return "Emoción no existe";
		}

	}

	@Override
	public String actualizarEmocion(Emocion emocion) {
		Boolean existe = emocionRepository.existsById(emocion.getId());
		if (existe) {
			emocionRepository.save(emocion);
			return "Emoción actualizada";
		}
		return "Emoción no actualizado";
	}

	@Override
	public Emocion obtenerEmocion(Long id) {
		Boolean existe = emocionRepository.existsById(id);
		if (existe) {
			Emocion emocion = emocionRepository.findById(id).get();
			return emocion;
		}
		return null;
	}

}
