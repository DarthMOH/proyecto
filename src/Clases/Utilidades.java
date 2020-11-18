package Clases;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import Enumeraciones.Curso;
import Tipos.Alumno;
import Tipos.Profesor;

public class Utilidades {

	public static String[] tabla;

	public static Scanner sc = new Scanner(System.in);

	public static void leerFicheroAlumnos(ArrayList<Alumno> lista, String ruta)
			throws FileNotFoundException, IOException {

		String cadena;
		int id = 1;

		FileReader f = new FileReader(ruta);
		BufferedReader b = new BufferedReader(f);

		while ((cadena = b.readLine()) != null) {

			tabla = cadena.split(",");

			String dni = tabla[0];
			String nombre = tabla[1];
			String apellido1 = tabla[2];
			String apellido2 = tabla[3];
			String fechaNac = tabla[4];
			String Curso = tabla[5];
			Double NotaMedia = Double.parseDouble(tabla[6]);

			lista.add(new ImplAlumno(id, dni, nombre, apellido1, apellido2, fechaNac, Curso, NotaMedia));
			id++;
		}

		b.close();
	}

	public static void leerFicheroProf(ArrayList<Profesor> lista, String ruta)
			throws FileNotFoundException, IOException {

		String cadena;
		Integer id = 1;

		FileReader f = new FileReader(ruta);
		BufferedReader b = new BufferedReader(f);

		while ((cadena = b.readLine()) != null) {

			tabla = cadena.split(",");

			String dni = tabla[0];
			String nombre = tabla[1];
			String apellido1 = tabla[2];
			String apellido2 = tabla[3];
			String fechaNac = tabla[4];
			String Curso = tabla[5];

			lista.add(new ImplProfesor(id, dni, nombre, apellido1, apellido2, fechaNac, Curso));
			id++;

		}

		b.close();

	}

	public static void DatosAlumno(ArrayList<Alumno> lista) {

		for (int i = 0; i < lista.size(); i++) {

			Alumno cadena = lista.get(i);

			System.out.println(CuadraTexto(cadena.getid().toString(), 3).substring(0, 3) + " "
					+ CuadraTexto((String) cadena.getDni(), 10) + " "
					+ CuadraTexto(cadena.getNombre(), 15).substring(0, 15) + " "
					+ CuadraTexto(cadena.getApellido1(), 15).substring(0, 15) + " "
					+ CuadraTexto(cadena.getApellido2(), 15).substring(0, 15) + " "
					+ CuadraTexto(cadena.getFechaNac(), 10).substring(0, 10) + "   " + cadena.getEdad() + "  "
					+ CuadraTexto(cadena.getCurso(), 4).substring(0, 4) + "   " + cadena.notaMedia());

		}

	}

	public static void DatosProf(ArrayList<Profesor> listaProf) {

		for (int i = 0; i < listaProf.size(); i++) {

			Profesor cadena = listaProf.get(i);

			System.out.println(CuadraTexto(cadena.getid().toString(), 3).substring(0, 3) + " "
					+ CuadraTexto((String) cadena.getDni(), 10) + " "
					+ CuadraTexto(cadena.getNombre(), 15).substring(0, 15) + " "
					+ CuadraTexto(cadena.getApellido1(), 15).substring(0, 15) + " "
					+ CuadraTexto(cadena.getApellido2(), 15).substring(0, 15) + " "
					+ CuadraTexto(cadena.getFechaNac(), 10).substring(0, 10) + "   " + cadena.getEdad() + "  "
					+ CuadraTexto(cadena.getCurso(), 4).substring(0, 4));
		}

	}

	public static String CuadraTexto(String texto, int numChar) {

		for (int i = texto.length(); i < numChar; i++) {
			texto += " ";
		}

		return texto;
	}

	public static Boolean ComprobarDNI(String dni) {
		
		char[] letras = { 'T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H',
				'L', 'C', 'K', 'E' };
		
		Boolean verd = false;
		String dniFinal = dni.substring(0, 8) + letras[Integer.parseInt(dni.substring(0, 8)) % 23];
		
		if (dni.equals(dniFinal))
			verd = true;
		else
			verd = false;

		return verd;

	}

	public static void modificarAlumno(ArrayList<Alumno> lista) {

		String dni, nombre, apellido1, apellido2, fechaNac;
		String curso = null;
		Double notaMedia;

		System.out.println("¿DNI del alumno?: ");
		dni = sc.next();
		int i = 0;

		for (i = 0; i < lista.size() - 1; i++) {
			if (dni.equals(lista.get(i).getDni())) {
				break;
			}
		}

		System.out.println(i + " " + lista.get(i).getNombre() + " " + lista.get(i).getDni());

		int seleccion = -1;
		do {
			System.out.println("1.-Modificar DNI");
			System.out.println("2.-Modificar nombre");
			System.out.println("3.-Modificar apellido1");
			System.out.println("4.-Modificar apellido2");
			System.out.println("5.-Modificar fecha de nacimiento");
			System.out.println("6.-Modificar curso");
			System.out.println("7.-Modificar nota media");
			System.out.println("8.-Salir");
			System.out.println("Selecciona la acción a realizar 1-8: ");
			seleccion = sc.nextInt();

			switch (seleccion) {

			case 1:
				do {
					System.out.println("¿Nuevo dni?: ");

					dni = sc.next().toUpperCase();

					if (dni.length() == 9) {
						if (Utilidades.ComprobarDNI(dni) == true)
							System.out.println("OK");
						else {
							System.out.println("El dni es incorrecto");
						}
					} else {
						System.out.println("El DNI es incorrecto");
					}

				} while (dni.length() != 9 || Utilidades.ComprobarDNI(dni) == false);
				lista.get(i).setDni(dni);

				break;
			case 2:
				System.out.println("¿Nuevo nombre?: ");
				nombre = sc.next();
				lista.get(i).setNombre(nombre);
				break;

			case 3:
				System.out.println("¿Nuevo primer apellido?: ");
				apellido1 = sc.next();
				lista.get(i).setApellido1(apellido1);
				break;

			case 4:
				System.out.println("¿Nuevo segundo apellido?: ");
				apellido2 = sc.next();
				lista.get(i).setApellido2(apellido2);
				break;

			case 5:
				System.out.println("¿Nueva fecha?: ");
				fechaNac = sc.next();
				lista.get(i).setFechaNac(fechaNac);
				break;

			case 6:
				System.out.println("¿Nuevo curso?: ");
				curso = sc.next().toUpperCase();
				((Alumno) lista.get(i)).setCurso(Curso.valueOf(curso));
				break;

			case 7:
				System.out.println("¿Nueva nota media?: ");
				notaMedia = sc.nextDouble();
				((Alumno) lista.get(i)).setNotaMedia(notaMedia);
				break;
			}

		} while (seleccion != 8);
	}

	public static void modificarProf(ArrayList<Profesor> lista) {

		String dni, nombre, apellido1, apellido2, fechaNac;
		String curso = null;

		System.out.println("¿DNI del profesor?: ");
		dni = sc.next();
		int i = 0;

		for (i = 0; i < lista.size() - 1; i++) {
			if (dni.equals(lista.get(i).getDni())) {
				break;
			}
		}

		System.out.println(i + " " + lista.get(i).getNombre() + " " + lista.get(i).getDni());

		int seleccion = -1;
		do {
			System.out.println("1.-Modificar DNI");
			System.out.println("2.-Modificar nombre");
			System.out.println("3.-Modificar apellido1");
			System.out.println("4.-Modificar apellido2");
			System.out.println("5.-Modificar fecha de nacimiento");
			System.out.println("6.-Modificar curso");
			System.out.println("7.-Salir");
			System.out.println("Selecciona la acción a realizar 1-7: ");
			seleccion = sc.nextInt();

			switch (seleccion) {

			case 1:
				do {
					System.out.println("¿Nuevo dni?: ");

					dni = sc.next().toUpperCase();

					if (dni.length() == 9) {
						if (Utilidades.ComprobarDNI(dni) == true)
							System.out.println("OK");
						else {
							System.out.println("El dni es incorrecto");
						}
					} else {
						System.out.println("El DNI es incorrecto");
					}

				} while (dni.length() != 9 || Utilidades.ComprobarDNI(dni) == false);
				lista.get(i).setDni(dni);

				break;
			case 2:
				System.out.println("¿Nuevo nombre?: ");
				nombre = sc.next();
				lista.get(i).setNombre(nombre);
				break;

			case 3:
				System.out.println("¿Nuevo primer apellido?: ");
				apellido1 = sc.next();
				lista.get(i).setApellido1(apellido1);
				break;

			case 4:
				System.out.println("¿Nuevo segundo apellido?: ");
				apellido2 = sc.next();
				lista.get(i).setApellido2(apellido2);
				break;

			case 5:
				System.out.println("¿Nueva fecha?: ");
				fechaNac = sc.next();
				lista.get(i).setFechaNac(fechaNac);
				break;

			case 6:
				System.out.println("¿Nuevo curso?: ");
				curso = sc.next().toUpperCase();
				((Alumno) lista.get(i)).setCurso(Curso.valueOf(curso));
				break;
			}

		} while (seleccion != 7);
	}
}
