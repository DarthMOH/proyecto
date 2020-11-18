package Comparadores;

import java.util.Comparator;

import Tipos.Persona;

public class ComparadorApellidos implements Comparator<Persona>{

	@Override
	public int compare(Persona p1, Persona p2) {
		
		if(p1.getApellido1() != p2.getApellido1())
			return p1.getApellido2().compareTo(p2.getApellido2());
		
		return p1.getApellido1().compareTo(p2.getApellido1());
		
	}

}
