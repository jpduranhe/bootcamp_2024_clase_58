package cl.clase_58.persona.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;

import cl.clase_58.persona.model.dao.PersonaDao;
import cl.clase_58.persona.model.entidad.Persona;
import cl.clase_58.persona.model.service.PersonaService;
import cl.clase_58.persona.model.service.impl.PersonaServiceImpl;

public class PersonaServiceTest {
	
	private PersonaService personaService;
	private PersonaDao personaDao;
	
	@BeforeEach
	void setup() {
		MockitoAnnotations.initMocks(this);
		
		personaDao= mock(PersonaDao.class);
		
		personaService= new PersonaServiceImpl(personaDao);
		
		when(personaDao.guardar(any(Persona.class))).thenReturn(true);
	}
	
	@Test
	void whenGuardamosUnaPersonaDeManeraExistosa() {
		
		Persona persona=new Persona("Juan","Rojas",39);
		
		boolean resultado = personaService.crearPersona(persona);
		
		assertTrue(resultado);
		verify(personaDao).guardar(any(Persona.class));
		
	}
	@Test
	void whenGuardamosUnaPersonaNula() {
		
		
		boolean resultado = personaService.crearPersona(null);
		
		assertFalse(resultado);
		verify(personaDao,never()).guardar(any(Persona.class));
		
	}
	@Test
	void whenGuardamosUnaPersonaConNombreNulo() {
		
		Persona persona=new Persona(null,"",0);
		
		boolean resultado = personaService.crearPersona(persona);
		
		assertFalse(resultado);
		verify(personaDao,never()).guardar(any(Persona.class));
		
	}
	@Test
	void whenGuardamosUnaPersonaConApellid0Nulo() {
		
		Persona persona=new Persona("",null,0);
		
		boolean resultado = personaService.crearPersona(persona);
		
		assertFalse(resultado);
		verify(personaDao,never()).guardar(any(Persona.class));
		
	}
	@Test
	void whenGuardamosUnaPersonaConNombreVacio() {
		
		Persona persona=new Persona("","rojas",1);
		
		boolean resultado = personaService.crearPersona(persona);
		
		assertFalse(resultado);
		verify(personaDao,never()).guardar(any(Persona.class));
		
	}
	@Test
	void whenGuardamosUnaPersonaConApellidoVacios() {
		
		Persona persona=new Persona("Pablo","",0);
		
		boolean resultado = personaService.crearPersona(persona);
		
		assertFalse(resultado);
		verify(personaDao,never()).guardar(any(Persona.class));
		
	}
	@Test
	void whenGuardamosUnaPersonaConEdadCero() {
		
		Persona persona=new Persona("Pablo","Perez",0);
		
		boolean resultado = personaService.crearPersona(persona);
		
		assertFalse(resultado);
		verify(personaDao,never()).guardar(any(Persona.class));
		
	}
	@Test
	void whenListarFuncionaCorrectamente(){
		List<Persona> listado= new ArrayList<>();
		listado.add(new Persona());
		when(personaDao.getListado()).thenReturn(listado);
		
		List<Persona> listadoObtenido= personaService.obtenerPersonas();
		assertFalse(listadoObtenido.isEmpty());
		assertEquals(1,listadoObtenido.size());
	}
	

}
