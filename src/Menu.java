import java.awt.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.InputMismatchException;

import Clases.Utilidades;
import Comparadores.ComparadorApellidos;
import Comparadores.ComparadorNombre;
import Comparadores.ComparadorNotaMedia;
import Clases.ImplAlumno;
import Clases.ImplProfesor;
import Comparadores.ComparadorDni;
import Tipos.Alumno;
import Tipos.Profesor;

import javax.swing.*;

public class Menu {

	public static void main(String[] args) throws FileNotFoundException, IOException {

		ArrayList<Alumno> listaAlumnos = new ArrayList<Alumno>();
		ArrayList<Profesor> listaProf = new ArrayList<Profesor>();

		// int expo = 0;
		int expo = -1;
		boolean fallo = false;

		String black="\033[30m";
		String red="\033[31m";
		String green="\033[32m";
		String yellow="\033[33m";
		String blue="\033[34m";
		String purple="\033[35m";
		String cyan="\033[36m";
		String white="\033[37m";
		String reset="\u001B[0m";

		do {

			try {

				System.out.print("Introduce el archivo de datos de los alumnos: ");
				String ruta = Utilidades.sc.next();
				Utilidades.leerFicheroAlumnos(listaAlumnos, ruta);
				fallo = false;
			}

			catch (FileNotFoundException e) {
				System.out.println(red + "El archivo indicado no existe" + reset);
				fallo = true;
			}

		} while (fallo);

		do {

			try {

				System.out.print("Introduce el archivo de datos de los profesores: ");
				String ruta2 = Utilidades.sc.next();
				Utilidades.leerFicheroProf(listaProf, ruta2);
				fallo = false;
			}

			catch (FileNotFoundException e) {
				System.out.println(red + "El archivo indicado no existe" + reset);
				fallo = true;
			}

		} while (fallo);

		do {

			try {

				System.out.println(blue + "-----MENÚ-----");

				System.out.println();

				System.out.println("1.-Añadir un alumno");
				System.out.println("2.-Modificar un alumno");
				System.out.println("3.-Añadir un profesor");
				System.out.println("4.-Modificar un profesor");
				System.out.println("5.-Ordenar listas por DNI");
				System.out.println("6.-Ordenar listas por nombre");
				System.out.println("7.-Ordenar listas por apellidos");
				System.out.println("8.-Ordenar lista por nota media");
				System.out.println("9.-Mostrar listado de alumnos");
				System.out.println("10.-Mostrar listado de profesores");
				System.out.println("11.-Mostrar número de alumnos");
				System.out.println("12.-Mostrar número de profesores");
				System.out.println("0.-Salir");

				System.out.println();
				
				System.out.print("Selecciona la acción a realizar 0-10: " + reset);
				expo = Utilidades.sc.nextInt();

				switch (expo) {

				case 1:

					int id = listaAlumnos.size() + 1;

					System.out.print("Introduce un Dni válido: ");
					String dni = Utilidades.sc.next();

					System.out.print("Introduce el nombre: ");
					String nombre = Utilidades.sc.next();

					System.out.print("Introduce el pirmer apellido: ");
					String apellido1 = Utilidades.sc.next();

					System.out.print("Introduce el segundo apellido: ");
					String apellido2 = Utilidades.sc.next();

					System.out.print("Introduce la fecha de nacimiento: ");
					String fechaNac = Utilidades.sc.next();

					System.out.print("Introduce el curso: ");
					String curso = Utilidades.sc.next();

					System.out.print("Introduce la nota media: ");
					Double notaMedia = Utilidades.sc.nextDouble();

					listaAlumnos.add(new ImplAlumno(id, dni, nombre, apellido1, apellido2, fechaNac, curso, notaMedia));

					break;

				case 2:
					Utilidades.modificarAlumno(listaAlumnos);
					break;

				case 3:

					id = listaProf.size() + 1;

					System.out.print("Introduce un Dni válido: ");
					dni = Utilidades.sc.next();
					
					if(Utilidades.ComprobarDNI(dni)) {
						
						System.out.println("Introduce el nombre: ");
						nombre = Utilidades.sc.next();

						System.out.println("Introduce el pirmer apellido: ");
						apellido1 = Utilidades.sc.next();

						System.out.println("Introduce el segundo apellido: ");
						apellido2 = Utilidades.sc.next();

						System.out.println("Introduce la fecha de nacimiento: ");
						fechaNac = Utilidades.sc.next();

						System.out.println("Introduce el curso: ");
						curso = Utilidades.sc.next();

						listaProf.add(new ImplProfesor(id, dni, nombre, apellido1, apellido2, fechaNac, curso));
					}
					
					else {
						System.out.println(red + "El DNI no es válido" + reset);
					}

					break;

				case 4:
					Utilidades.modificarProf(listaProf);
					break;

				case 5:
					listaAlumnos.sort(new ComparadorDni());
					listaProf.sort(new ComparadorDni());

					System.out.println(green + "Listas ordenadas por DNI, presione enter para seguir." + reset);
					System.in.read();
					break;

				case 6:
					listaAlumnos.sort(new ComparadorNombre());
					listaProf.sort(new ComparadorNombre());

					System.out.println(green + "Listas ordenadas por nombre, presione enter para seguir." + reset);
					System.in.read();
					break;

				case 7:
					listaAlumnos.sort(new ComparadorApellidos());
					listaProf.sort(new ComparadorApellidos());

					System.out.println(green + "Listas ordenadas por apellidos, presione enter para seguir." + reset);
					System.in.read();
					break;

				case 8:
					Collections.sort(listaAlumnos, new ComparadorNotaMedia());

					System.out.println(green + "Alumnos ordenados por notas, presione enter para seguir." + reset);
					System.in.read();
					break;

				case 9:
					System.out.println();
					System.out.println();

					Utilidades.DatosAlumno(listaAlumnos);

					System.out.println();
					System.out.println("Presione enter para volver");
					System.in.read();
					break;

				case 10:
					System.out.println();
					System.out.println();

					Utilidades.DatosProf(listaProf);

					System.out.println();
					System.out.println("Presione enter para volver");
					System.in.read();
					break;

				case 11:
					System.out.println();
					System.out.println();

					System.out.print("Hay " + listaAlumnos.size() + " alumnos.");

					System.out.println();
					System.out.println("Presione enter para volver");
					System.in.read();
					break;

				case 12:
					System.out.println();
					System.out.println();

					System.out.print("Hay " + listaProf.size() + " profesores.");

					System.out.println();
					System.out.println("Presione enter para volver");
					System.in.read();
					break;

				case 0:
					break;

				default:
					System.out.println(red + "Opción invalida. Entre 1 - 10" + reset);
					break;

				}

			}

			catch (InputMismatchException e) {
				System.out.println(red + "Ha introducido una opción incorrecta." + reset);
				
			}

		} while (expo != 0);

		System.out.println("Hasta luego.");

	}
}
