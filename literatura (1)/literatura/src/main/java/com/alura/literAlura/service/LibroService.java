package com.alura.literAlura.service;

import com.alura.literAlura.client.GutendexClient;
import com.alura.literAlura.model.Libro;
import com.alura.literAlura.model.Autor;
import com.alura.literAlura.repository.LibroRepository;
import com.alura.literAlura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LibroService {
    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private GutendexClient gutendexClient;

    public List<Libro> buscarPorTitulo(String titulo) {
        // Llamar al cliente de Gutendex para buscar libros
        List<String> titulosLibros = gutendexClient.buscarLibrosPorTitulo(titulo);

        // Convertir los títulos a objetos Libro
        return titulosLibros.stream()
                .map(t -> {
                    // Aquí debes obtener el autor correspondiente, por ejemplo, el primero
                    Autor autor = autorRepository.findById(1L).orElse(null); // Cambia según tu lógica
                    return new Libro(t, "Inglés", 0, autor); // Ajusta los parámetros según sea necesario
                })
                .collect(Collectors.toList());
    }

    public List<Libro> listarTodos() {
        return libroRepository.findAll();
    }

    public List<Libro> listarLibrosDesdeAPI() {
        // Llamar a la API para obtener todos los libros
        List<String> titulosLibros = gutendexClient.buscarLibrosPorTitulo(""); // Puedes ajustar la búsqueda
        return titulosLibros.stream()
                .map(t -> {
                    // Aquí debes obtener el autor correspondiente, por ejemplo, el primero
                    Autor autor = autorRepository.findById(1L).orElse(null); // Cambia según tu lógica
                    return new Libro(t, "Inglés", 0, autor); // Ajusta los parámetros según sea necesario
                })
                .collect(Collectors.toList());
    }
}