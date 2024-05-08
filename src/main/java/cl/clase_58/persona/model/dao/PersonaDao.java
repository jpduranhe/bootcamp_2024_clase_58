package cl.clase_58.persona.model.dao;

import java.util.List;

import cl.clase_58.persona.model.entidad.Persona;

public interface PersonaDao {

	boolean guardar(Persona persona);
	boolean editar(Persona persona);
	Persona obtenerPorId(int id);
	List<Persona> getListado();
}
