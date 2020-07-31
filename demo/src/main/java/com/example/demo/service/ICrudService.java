package com.example.demo.service;



public interface ICrudService<Entity, IdDataType> {	
	
	public Entity registroVisitas(Entity entity);
	
	
	public Iterable<Entity> consultaTopVisitas(String  tipoVisita);
	
	
	
}
