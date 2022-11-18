package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/subemocion")
public class SubEmocionControllers {


	//https:localhost:9081/subemocion/listaDeSubEmociones
	@RequestMapping("/listaDeSubEmociones")
	public String getSubEmocion() {
		System.out.println("metodo obtener Subemocion");
		return "Estoy en la lista de subemociones";
	}
	
}
