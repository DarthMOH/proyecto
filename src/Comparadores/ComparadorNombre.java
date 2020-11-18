package Comparadores;

import java.util.Comparator;

import Tipos.Persona;

public class ComparadorNombre implements Comparator<Persona> {
	
	@Override
	public int compare(Persona p1, Persona p2) {
		return p1.getNombre().compareTo(p2.getNombre());
	}

}
