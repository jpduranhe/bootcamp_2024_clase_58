package cl.clase_58.persona.model.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cl.clase_58.persona.model.dao.PersonaDao;
import cl.clase_58.persona.model.entidad.Persona;
import cl.clase_58.shared.model.dao.DAO;

public class PersonaDaoImpl  extends DAO implements PersonaDao {
	
	
	

	@Override
	public boolean guardar(Persona persona) {
		
		String nombre= persona.getNombre();
		String apellidos= persona.getApellidos();
		int edad= persona.getEdad();
		
		String insertSql="insert into persona (nombre,apellidos,edad)";
		insertSql+=" values('"+nombre+"','"+apellidos+"',"+edad+")";
		
		int registrosAfectados=ejecutarSql(insertSql);
		boolean resultado= (registrosAfectados>0);
		return resultado;
	}

	@Override
	public List<Persona> getListado() {
		try {
			List<Persona> listado= new ArrayList<>();
		
		
			String selectAllsql="select nombre,apellidos,edad from persona";
			
			ResultSet rsl= this.consultar(selectAllsql);
			
			while(rsl.next()) {
				
					String nombre=rsl.getString("nombre");
					String apellidos= rsl.getString("apellidos");
					int edad= rsl.getInt("edad");
				
					Persona persona= new Persona(nombre,apellidos, edad);
					listado.add(persona);
				
			}
			
			return listado;
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			return null;
		}
		
	}
	
	
	

}
