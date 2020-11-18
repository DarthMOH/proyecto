package Comparadores;

import java.util.Comparator;

import Tipos.Alumno;

public class ComparadorNotaMedia implements Comparator<Alumno>{

	@Override
	public int compare(Alumno p1, Alumno p2) {
		return p1.notaMedia().compareTo(p2.notaMedia());
	}

}
