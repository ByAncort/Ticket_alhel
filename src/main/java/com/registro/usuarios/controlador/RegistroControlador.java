package com.registro.usuarios.controlador;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
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

import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class RegistroControlador {
	@Autowired
	private UnifierService unifierService;
	@Autowired
	private UnifierService UnifierService;
	@Autowired
	private UsuarioServicio servicio;
	@Autowired
	private UnifierService guardarTicket;
	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}


	@GetMapping("/")
	public String verPaginaDeInicio(Model model) {
		String bpname = "Incidencias Arrendatarios";
		String informacion = unifierService.consultarInformacion(bpname);
		//System.out.println(informacion);

		ObjectMapper objectMapper = new ObjectMapper();
		List<Map<String, Object>> dataList = null;
		try {
			Map<String, Object> resultMap = objectMapper.readValue(informacion, new TypeReference<Map<String, Object>>() {});
			dataList = (List<Map<String, Object>>) resultMap.get("data");
		} catch (IOException e) {
			e.printStackTrace();
		}

		model.addAttribute("informacion", dataList);

		return "index";
	}

}
