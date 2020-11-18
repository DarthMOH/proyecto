package Clases;

import Enumeraciones.Curso;
import Tipos.Alumno;

public class ImplAlumno extends ImplPersona implements Alumno{
	
	private String Curso;
	private Double notaMedia;

	public ImplAlumno(int id, String dni, String nombre, String apellido1, String apellido2, String fechaNac, String Curso, Double notaMedia) {
		super(id, dni, nombre, apellido1, apellido2, fechaNac);
		
		this.Curso = Curso;
		this.notaMedia = notaMedia;
	}
	
	@Override
	public String getCurso() {
		return Curso;
	}
	
	public void setCurso(Curso curso) {
	}

	@Override
	public Double notaMedia() {
		return notaMedia;
	}

	@Override
	public void setNotaMedia(Double notaMedia) {
		this.notaMedia = notaMedia;
		
	}


}
