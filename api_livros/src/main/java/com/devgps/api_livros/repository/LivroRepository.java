package com.devgps.api_livros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devgps.api_livros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    
}
