package com.example.demo.services;

import static org.junit.jupiter.api.Assertions.assertTrue;
import java.util.List;
import javax.validation.constraints.AssertTrue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.entity.VisitasEntity;
import com.example.demo.service.VisitanteService;

@SpringBootTest
class PlanetsServicesTest {
	
	@Autowired
	VisitanteService service;
	
	@Test
	void insertarPlaneta() {
		VisitasEntity entity=new VisitasEntity();
		entity.setTipoVisita("PLANET");
		entity.setVisitado("planet");
		VisitasEntity vi = service.registroVisitas(entity);
		assertTrue(vi.getId()>0);
		
	}

	@Test
	void consultarTopPlaneta() {		
		List<VisitasEntity> visitas=(List<VisitasEntity>)service.consultaTopVisitas("PLANET");
		//assertTrue(visitas.size()>0);
	}


}
