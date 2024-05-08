package cl.clase_58.persona.model.service;

import java.util.List;

import cl.clase_58.persona.model.entidad.Persona;

public interface PersonaService {

	/**
	 * Permite crear una persona en el sistema
	 * @param persona
	 * @return boolean cuando crea la persona correctamente devuelve un tru y un false cuando no
	 */
	boolean crearPersona(Persona persona);
	
	/**
	 * Permite editar una persona en el sistema
	 * @param persona
	 * @return boolean cuando crea la persona correctamente devuelve un tru y un false cuando no
	 */
	boolean editarPersona(Persona persona);
	
	
	/**
	 * Permite obtener una persona por su id
	 * @param persona
	 * @return boolean cuando crea la persona correctamente devuelve un tru y un false cuando no
	 */
	Persona getById(int id);
	
	/**
	 * Devuelve un listado de las personas registradas
	 * @return Listado
	 */
	List<Persona> obtenerPersonas();
}
