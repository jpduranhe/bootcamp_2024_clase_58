package cl.clase_58.persona.controller;

import java.io.IOException;

import cl.clase_58.persona.model.dao.PersonaDao;
import cl.clase_58.persona.model.dao.impl.PersonaDaoImpl;
import cl.clase_58.persona.model.entidad.Persona;
import cl.clase_58.persona.model.service.PersonaService;
import cl.clase_58.persona.model.service.impl.PersonaServiceImpl;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/edicion")
public class EdicionPersonaController extends HttpServlet{

	private static final long serialVersionUID = -1932733509115339195L;
	private PersonaService personaService;
	private PersonaDao personaDao;
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		personaDao= new PersonaDaoImpl();
		personaService= new PersonaServiceImpl(personaDao);
	}
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String idParameter= req.getParameter("id");
		int id= Integer.parseInt(idParameter);
		
		Persona persona=personaService.getById(id);
		
		
		req.setAttribute("id", persona.getId());
		req.setAttribute("nombre", persona.getNombre());
		req.setAttribute("apellidos", persona.getApellidos());
		req.setAttribute("edad", persona.getEdad());
		
		RequestDispatcher dispatcher= req.getRequestDispatcher("/persona/view/formulario-edicion.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String nombreFormulario= req.getParameter("nombre");
		String apellidosFormulario= req.getParameter("apellidos");
		String edadFormulario= req.getParameter("edad");
		String idFormulario= req.getParameter("id");
		int edad = Integer.parseInt(edadFormulario);
		int id = Integer.parseInt(idFormulario);
		
		Persona persona= new Persona(id,nombreFormulario,apellidosFormulario,edad);
		
		boolean resultado= personaService.editarPersona(persona);
		
		String urlDispatcher= (resultado)?"ingreso-formulario-existoso.jsp":"ingreso-formulario-fallido.jsp";
		
		RequestDispatcher dispatcher= req.getRequestDispatcher("/persona/view/"+urlDispatcher);
		dispatcher.forward(req, resp);
	}

	
	
	
	

}
