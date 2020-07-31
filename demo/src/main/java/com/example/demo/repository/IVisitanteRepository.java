package com.example.demo.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.VisitasEntity;

@Repository
public interface IVisitanteRepository extends CrudRepository<VisitasEntity, Integer> {
	
	@Query(value = "SELECT V FROM VisitasEntity V WHERE V.visitado = :visitado and V.tipoVisita = :tipoVisita " )
	public VisitasEntity findByfiltro(@Param("visitado") String visitado, @Param("tipoVisita") String tipoVisita);
	

	@Query(value = "SELECT VI FROM VisitasEntity VI WHERE VI.visitado=:visitado and VI.tipoVisita =:tipoVisita ")
	public Iterable<VisitasEntity> consultaVisitas(@Param("visitado") String visitado, @Param("tipoVisita") String tipoVisita);
	
	@Query(value = "SELECT * FROM VISITAS  WHERE tipo_Visita=:tipoVisita ORDER BY conteo DESC LIMIT 3 ", nativeQuery=true)
    public Iterable<VisitasEntity> consultaTopVisitas(@Param("tipoVisita") String tipoVisita);
}
