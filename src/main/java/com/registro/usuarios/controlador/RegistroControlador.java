package com.registro.usuarios.controlador;
import com.registro.usuarios.servicio.UnifierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.registro.usuarios.servicio.UsuarioServicio;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RegistroControlador {
	@Autowired
	private UnifierService unifierService;
	@Autowired
	private UnifierService tokenService;
	@Autowired
	private UsuarioServicio servicio;
	@Autowired
	private UnifierService guardarTicket;
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}


	@GetMapping("/")
	public String verPaginaDeInicio(Model modelo) {
		String token = tokenService.obtenerToken();

		System.out.println();
		modelo.addAttribute("token", token);
		return "index";
	}

}
