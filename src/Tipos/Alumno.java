package Tipos;

import Enumeraciones.Curso;

public interface Alumno extends Persona{
	
	String getCurso();
	Double notaMedia();
	
	void setDni(String dni);
	void setNombre(String nombre);
	void setApellido1(String apellido1);
	void setApellido2(String apellido2);
	void setFechaNac(String fechaNac);
	void setCurso(Curso curso);
	void setNotaMedia(Double notaMedia);
}
