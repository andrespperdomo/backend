package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="VISITAS")
public class VisitasEntity {

	  @Id 
	  @GeneratedValue(strategy=GenerationType.AUTO)
	  private Long id;
	  @Column(name="VISITADO")
	  private String visitado;
	  @Column(name="CONTEO")
	  private int conteo;
	  @Column(name="TIPO_VISITA")
	  private String tipoVisita;
	  
	  
	 
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getVisitado() {
		return visitado;
	}
	public void setVisitado(String visitado) {
		this.visitado = visitado;
	}
	public int getConteo() {
		return conteo;
	}
	public void setConteo(int conteo) {
		this.conteo = conteo;
	}
	public String getTipoVisita() {
		return tipoVisita;
	}
	public void setTipoVisita(String tipoVisita) {
		this.tipoVisita = tipoVisita;
	}
	  
}
