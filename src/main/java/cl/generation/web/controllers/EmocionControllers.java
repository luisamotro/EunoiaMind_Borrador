package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/emocion")
public class EmocionControllers {

	//https:localhost:9081/emocion/listaDeEmociones
	@RequestMapping("/listaDeEmociones")
	public String getEmocion() {
		System.out.println("metodo obtener emocion");
		return "Estoy en la lista de emociones";
	}
	


	
}
