package com.example.demo.repository;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.constantes.ConstantesTest;
import com.example.demo.entity.VisitasEntity;
import com.example.demo.repository.IVisitanteRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class PeopleRepositoryTest {

	@Autowired
	IVisitanteRepository repository;
	
	@Test
	public void registrarPersona() {
	    VisitasEntity entity=new VisitasEntity();
	    entity.setTipoVisita(ConstantesTest.PEOPLE);
	    entity.setVisitado("people");
		VisitasEntity res =repository.save(entity);
		assertTrue(res.getId()>0);
	}
	
	@Test
	public void consultaTopPersonas() {
	    VisitasEntity entity=new VisitasEntity();
	    entity.setTipoVisita(ConstantesTest.PEOPLE);
	    entity.setVisitado("people");
		Iterable<VisitasEntity> res =repository.consultaTopVisitas(ConstantesTest.PEOPLE);
		assertTrue(res.iterator().hasNext());
	}
	
}
