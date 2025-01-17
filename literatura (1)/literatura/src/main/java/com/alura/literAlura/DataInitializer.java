package com.alura.literAlura;

import com.alura.literAlura.model.Autor;
import com.alura.literAlura.model.Libro;
import com.alura.literAlura.repository.AutorRepository;
import com.alura.literAlura.repository.LibroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    @Autowired
    private AutorRepository autorRepository;

    @Autowired
    private LibroRepository libroRepository;

    @Override
    public void run(String... args) throws Exception {
        // Verificar si ya hay autores en la base de datos
        if (autorRepository.count() == 0) {
            // Insertar autores
            Autor autor1 = new Autor("Mary Shelley", 1797, null);
            Autor autor2 = new Autor("Jules Verne", 1828, null);
            Autor autor3 = new Autor("Mark Twain", 1835, 1910);

            autorRepository.save(autor1);
            autorRepository.save(autor2);
            autorRepository.save(autor3);
        }

        // Verificar si ya hay libros en la base de datos
        if (libroRepository.count() == 0) {
            // Insertar libros
            libroRepository.save(new Libro("Frankenstein", "Inglés", 100, autorRepository.findById(1L).orElse(null)));
            libroRepository.save(new Libro("Twenty Thousand Leagues Under the Sea", "Inglés", 150, autorRepository.findById(2L).orElse(null)));
            libroRepository.save(new Libro("The Adventures of Tom Sawyer", "Inglés", 200, autorRepository.findById(3L).orElse(null)));
        }
    }
}