package com.alura.literAlura.repository;

import com.alura.literAlura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutorRepository extends JpaRepository<Autor, Long> {
    // Método para encontrar autores vivos (sin año de fallecimiento)
    List<Autor> findByAnioFallecimientoIsNull();
}