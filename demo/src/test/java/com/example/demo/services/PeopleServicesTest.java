package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;



import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.entity.VisitasEntity;
import com.example.demo.service.VisitanteService;

@RunWith(SpringRunner.class)
@SpringBootTest
class PeopleServicesTest {
	
	@Autowired
	VisitanteService service;
	
	@Test
	void insertarPersonas() {
		VisitasEntity entity=new VisitasEntity();
		entity.setTipoVisita("PEOPLE");
		entity.setVisitado("people");
		VisitasEntity vi = service.registroVisitas(entity);
		assertTrue(vi.getId()>0);
		
	}

	@Test
	void consultarTopPersonas() {		
		Iterable<VisitasEntity> visita =service.consultaTopVisitas("PEOPLE");
		for(VisitasEntity v:visita) {
			System.out.println("--->"+v.getTipoVisita());
		}
		assertTrue(visita.iterator().hasNext());
	}


}
