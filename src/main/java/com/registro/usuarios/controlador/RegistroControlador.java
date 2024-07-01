package com.registro.usuarios.controlador;
import com.registro.usuarios.modelo.Token;
import com.registro.usuarios.servicio.UnifierService;
import com.registro.usuarios.servicio.UnifierServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.servicio.UsuarioServicio;

@Controller
public class RegistroControlador {
	@Autowired
	private UnifierService tokenService;
	@Autowired
	private UsuarioServicio servicio;
	
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}


	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		Token token = tokenService.obtenerToken();

		System.out.println();
		modelo.addAttribute("token", token);
		return "index";
	}
}
