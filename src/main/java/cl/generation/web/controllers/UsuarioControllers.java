package cl.generation.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/usuario")
public class UsuarioControllers {

	@RequestMapping("/")
	public String getUsuario() {
		System.out.println("metodo obtener usuario");
		return "index.jsp";
	}
	
	//htps://localhost:9080/usuario/home
	@RequestMapping("/home")
	public String home() {
		System.out.println("En el metodo home");
		return "home";
	}
	

	

	
	
	
	
	
	
	
	
}
