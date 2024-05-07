package cl.clase_58.persona.model.service;

import java.util.List;

import cl.clase_58.persona.model.entidad.Persona;

public interface PersonaService {

	/**
	 * Permite crear una persona en el sistemas
	 * @param persona
	 * @return boolean cuando crea la persona correctamente devuelve un tru y un false cuando no
	 */
	boolean crearPersona(Persona persona);
	
	/**
	 * Devuelve un listado de las personas registradas
	 * @return Listado
	 */
	List<Persona> obtenerPersonas();
}
