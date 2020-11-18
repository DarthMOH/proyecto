package Comparadores;

import java.util.Comparator;

import Tipos.Persona;

public class ComparadorDni implements Comparator<Persona>{

	@Override
	public int compare(Persona p1, Persona p2) {
		return p1.getDni().compareTo(p2.getDni());
	}

}
