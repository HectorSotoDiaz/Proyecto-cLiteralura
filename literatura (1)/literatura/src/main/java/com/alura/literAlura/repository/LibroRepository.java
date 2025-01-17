package com.alura.literAlura.repository;

import com.alura.literAlura.model.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}