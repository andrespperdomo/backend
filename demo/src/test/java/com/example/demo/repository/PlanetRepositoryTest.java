package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.constantes.ConstantesTest;
import com.example.demo.entity.VisitasEntity;

public class PlanetRepositoryTest {
	
	@Autowired
	IVisitanteRepository repository;
	
	@Test
	public void registrarPersona() {
	    VisitasEntity entity=new VisitasEntity();
	    entity.setTipoVisita(ConstantesTest.PLANET);
	    entity.setVisitado("people");
		VisitasEntity res =repository.save(entity);
		assertTrue(res.getId()>0);
	}
	
	@Test
	public void consultaTopPersonas() {
		Iterable<VisitasEntity> res =repository.consultaTopVisitas(ConstantesTest.PLANET);
		assertTrue(res.iterator().hasNext());
	}

}
