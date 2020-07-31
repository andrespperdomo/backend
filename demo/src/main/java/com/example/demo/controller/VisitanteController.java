package com.example.demo.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.SystemPropertyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.VisitasEntity;
import com.example.demo.model.RespuestaBase;
import com.example.demo.model.RespuestaCustomizada;
import com.example.demo.service.VisitanteService;

@RestController
@RequestMapping("/api/visitas")
public class VisitanteController{
	
	static final Logger LOGGER = LoggerFactory.getLogger(VisitanteController.class);
	
	
	@Autowired
	VisitanteService service;
	
	/**
	 * Metodo que consulta el top 3 para planetas y personas
	 * @param tipoVisita
	 * @return consultas topo de visitas para planetas y personas
	 */
	@GetMapping
	public ResponseEntity<RespuestaBase> consultaTopVisitas(@RequestParam String tipoVisita){
		LOGGER.info(new Object(){}.getClass().getSimpleName()+":"+getMethodName());
		
		try {
			Iterable<VisitasEntity> entity = service.consultaTopVisitas(tipoVisita);
			RespuestaCustomizada<Iterable<VisitasEntity>> respuesta = new RespuestaCustomizada<>();
			respuesta.setCodigoEstatus(HttpStatus.OK.value());
			respuesta.setMensaje("Consulta exitosa");
			respuesta.setData(entity);
			return new ResponseEntity<RespuestaBase>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			RespuestaBase respuestaBase = new RespuestaBase(HttpStatus.CONFLICT.value(), e.getMessage());
			return new ResponseEntity<RespuestaBase>(respuestaBase, HttpStatus.OK);
		}
	}
	/**
	 * Servicio que registrar las visitas para personas y planetas
	 * @param visitasEntity
	 * @return el planeta o persona registrada
	 */
	@PostMapping
	public ResponseEntity<RespuestaBase> registroVisitaPersona(@RequestBody VisitasEntity visitasEntity){
		LOGGER.info(new Object(){}.getClass().getSimpleName()+":"+getMethodName());
		try {
			VisitasEntity entity = service.registroVisitas(visitasEntity);
			RespuestaCustomizada<VisitasEntity> respuesta = new RespuestaCustomizada<>();
			respuesta.setCodigoEstatus(HttpStatus.OK.value());
			respuesta.setMensaje("Consulta exitosa");
			respuesta.setData(entity);
			return new ResponseEntity<RespuestaBase>(respuesta, HttpStatus.OK);
		} catch (Exception e) {
			RespuestaBase respuestaBase = new RespuestaBase(HttpStatus.CONFLICT.value(), e.getMessage());
			return new ResponseEntity<RespuestaBase>(respuestaBase, HttpStatus.OK);
		}
	}
	
	public static String getMethodName() {

	    // Verficamos que exista
	    if (Thread.currentThread().getStackTrace().length>2) {
	        return Thread.currentThread().getStackTrace()[2].getMethodName();
	    } else {
	        return "undefined";
	    }
	}

}
