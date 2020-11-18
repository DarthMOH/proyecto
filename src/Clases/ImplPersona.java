package Clases;

import java.util.Calendar;

public class ImplPersona implements Tipos.Persona {

	protected int id;
	protected String dni;
	protected String nombre;
	protected String apellido1;
	protected String apellido2;
	protected String fechaNac;
	protected Integer edad;

	public ImplPersona(int id, String dni, String nombre, String apellido1, String apellido2, String fechaNac) {

		this.id = id;
		this.dni = dni;
		this.nombre = nombre;
		this.apellido1 = apellido1;
		this.apellido2 = apellido2;
		this.fechaNac = fechaNac;
	}

	public Integer getid() {
		return id;
	}

	public String getDni() {
		return dni;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido1() {
		return apellido1;
	}

	public String getApellido2() {
		return apellido2;
	}

	public Integer getEdad() {

		Calendar c = Calendar.getInstance();
		int dia, mes, anyos;
		String[] fecha = fechaNac.split("/");

		anyos = c.get(Calendar.YEAR) - Integer.valueOf(fecha[2]);
		mes = c.get(Calendar.MONTH) + 1;
		dia = c.get(Calendar.DAY_OF_MONTH);
		edad = anyos;

		if ((Integer.valueOf(fecha[1]) > mes) || (Integer.valueOf(fecha[1]) == mes && Integer.valueOf(fecha[0]) >= dia))
			edad = edad - 1;

		return edad;
	}

	public String getFechaNac() {
		return fechaNac;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido1(String apellido1) {
		this.apellido1 = apellido1;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public void setFechaNac(String fechaNac) {
		this.fechaNac = fechaNac;
	}

}