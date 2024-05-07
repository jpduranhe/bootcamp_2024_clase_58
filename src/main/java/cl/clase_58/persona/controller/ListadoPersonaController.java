package cl.clase_58.persona.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import cl.clase_58.persona.model.dao.PersonaDao;
import cl.clase_58.persona.model.dao.impl.PersonaDaoImpl;
import cl.clase_58.persona.model.entidad.Persona;
import cl.clase_58.persona.model.service.PersonaService;
import cl.clase_58.persona.model.service.impl.PersonaServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/listado")
public class ListadoPersonaController extends HttpServlet {

	private static final long serialVersionUID = 3905336657589653213L;
	
	private PersonaService personaService;
	private PersonaDao personaDao;

	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		personaDao= new PersonaDaoImpl();
		personaService= new PersonaServiceImpl(personaDao);
		
		super.service(arg0, arg1);
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Persona> listado = personaService.obtenerPersonas();
		
		req.setAttribute("listadoPersonas", listado);
		
		req.getRequestDispatcher("/persona/view/tabla-personas.jsp").forward(req, resp);
		
		
	}
	
	
	
	

}
