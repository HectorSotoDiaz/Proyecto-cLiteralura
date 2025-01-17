package com.alura.literAlura.controller;

import com.alura.literAlura.model.Autor;
import com.alura.literAlura.model.Libro;
import com.alura.literAlura.service.AutorService;
import com.alura.literAlura.service.LibroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LiterAluraController {
    @Autowired
    private LibroService libroService;

    @Autowired
    private AutorService autorService;

    @GetMapping("/libros")
    public List<Libro> buscarLibros(@RequestParam String titulo) {
        List<Libro> libros = libroService.buscarPorTitulo(titulo);
        if (libros.isEmpty()) {
            System.out.println("No se encontraron libros con el título: " + titulo);
        }
        return libros;
    }

    @GetMapping("/libros/todos")
    public List<Libro> listarLibros() {
        List<Libro> libros = libroService.listarTodos();
        if (libros.isEmpty()) {
            System.out.println("No hay libros registrados en la base de datos. Cargando desde la API...");
            libros = libroService.listarLibrosDesdeAPI(); // Cargar desde la API si no hay libros
        }
        return libros;
    }

    @GetMapping("/autores/vivos")
    public List<Autor> listarAutoresVivos() {
        List<Autor> autores = autorService.listarAutoresVivos();
        if (autores.isEmpty()) {
            System.out.println("No hay autores vivos registrados en la base de datos. Cargando desde la API...");
            // Aquí puedes implementar la lógica para cargar autores desde la API si es necesario
        }
        return autores;
    }
}