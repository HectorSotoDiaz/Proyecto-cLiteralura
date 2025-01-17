package com.alura.literAlura.service;

import com.alura.literAlura.model.Autor;
import com.alura.literAlura.repository.AutorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AutorService {
    @Autowired
    private AutorRepository autorRepository;

    public List<Autor> listarAutoresVivos() {
        return autorRepository.findByAnioFallecimientoIsNull();
    }
}