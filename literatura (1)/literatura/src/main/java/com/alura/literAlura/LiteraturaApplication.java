package com.alura.literAlura;

import com.alura.literAlura.model.Libro;
import com.alura.literAlura.model.Autor;
import com.alura.literAlura.service.LibroService;
import com.alura.literAlura.service.AutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class LiteraturaApplication {
	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);
	}

	@Bean
	public CommandLineRunner run(LibroService libroService, AutorService autorService) {
		return args -> {
			Scanner scanner = new Scanner(System.in);
			int opcion;

			do {
				System.out.println("Menú:");
				System.out.println("1. Buscar libro por título");
				System.out.println("2. Listar todos los libros");
				System.out.println("3. Listar autores vivos");
				System.out.println("0. Salir");
				System.out.print("Seleccione una opción: ");
				opcion = scanner.nextInt();
				scanner.nextLine(); // Limpiar el buffer

				switch (opcion) {
					case 1:
						System.out.print("Ingrese el título del libro: ");
						String titulo = scanner.nextLine();
						List<Libro> libros = libroService.buscarPorTitulo(titulo);
						libros.forEach(libro -> System.out.println(libro.getTitulo()));
						break;
					case 2:
						List<Libro> todosLosLibros = libroService.listarTodos();
						todosLosLibros.forEach(libro -> System.out.println(libro.getTitulo()));
						break;
					case 3:
						List<Autor> autoresVivos = autorService.listarAutoresVivos();
						autoresVivos.forEach(autor -> System.out.println(autor.getNombre()));
						break;
					case 0:
						System.out.println("Saliendo...");
						break;
					default:
						System.out.println("Opción no válida. Intente de nuevo.");
				}
			} while (opcion != 0);
		};
	}
}