package com.example.demo.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.example.demo.entity.VisitasEntity;
import com.example.demo.repository.IVisitanteRepository;


@Service
public class VisitanteService implements ICrudService<VisitasEntity, Integer> {
	
	@Autowired
	IVisitanteRepository repository;

	@Override
	public VisitasEntity registroVisitas(VisitasEntity entity) {
		
		VisitasEntity visitasEntity =repository.findByfiltro(entity.getVisitado(),entity.getTipoVisita());
		//Existe visitante incrementa conteo
		if(visitasEntity!=null) {
			int incrementarConteo = visitasEntity.getConteo()+1;
			visitasEntity.setConteo(incrementarConteo);
			repository.save(visitasEntity);
		}
		// No existe crea registro 
		else {
			entity.setConteo(1);
			visitasEntity =repository.save(entity);
		}
		
		return visitasEntity;
	}

	@Override
	public Iterable<VisitasEntity> consultaTopVisitas(String tipoVisita) {
		// TODO Auto-generated method stu	
		return repository.consultaTopVisitas(tipoVisita);
	}

}
