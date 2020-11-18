package Clases;

import Tipos.Profesor;
import Enumeraciones.Curso;

public class ImplProfesor extends ImplPersona implements Profesor{
	
	private String Curso;
	
	public ImplProfesor(int id, String dni, String nombre, String apellido1, String apellido2, 
			String fechaNac, String Curso) {
		super(id, dni, nombre, apellido1, apellido2, fechaNac);
		
		this.Curso = Curso;
	}

	@Override
	public String getCurso() {
		return Curso;
	}
	
	public void setCurso(Curso curso) {
	}

}
