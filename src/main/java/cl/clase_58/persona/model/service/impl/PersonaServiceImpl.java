package cl.clase_58.persona.model.service.impl;

import java.util.List;

import cl.clase_58.persona.model.dao.PersonaDao;
import cl.clase_58.persona.model.entidad.Persona;
import cl.clase_58.persona.model.service.PersonaService;

public class PersonaServiceImpl implements PersonaService {
	
	
	private PersonaDao personaDao;
	
	
	public PersonaServiceImpl(PersonaDao personaDao) {
		this.personaDao=personaDao;
	}

	@Override
	public boolean crearPersona(Persona persona) {
		
		if(persona != null 
				&& persona.getNombre() !=null
				&& persona.getApellidos() !=null 
				&& !persona.getNombre().isBlank() 
				&& !persona.getApellidos().isBlank() 
				&& persona.getEdad()>0) {
			
			return personaDao.guardar(persona);
		} else {
			
			return false;
		}
		
		
	}

	@Override
	public List<Persona> obtenerPersonas() {
		return personaDao.getListado();
	}

	@Override
	public boolean editarPersona(Persona persona) {
		if(persona.getId()>0) {
			personaDao.editar(persona);
			return true;
		}
		return false;
	}

	@Override
	public Persona getById(int id) {
		return personaDao.obtenerPorId(id);
	}

}
