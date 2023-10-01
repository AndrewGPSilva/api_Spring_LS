package com.devgps.api_livros.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devgps.api_livros.entities.Livro;
import com.devgps.api_livros.repository.LivroRepository;

@RestController
@RequestMapping
public class LivroController {

    @Autowired
    private LivroRepository livroRepository;

    // Buscar todos
    @GetMapping("/livros")
    public List<Livro> getAll() {
        return livroRepository.findAll();
    }

    // Cadastrar
    @PostMapping("/livros")
    public Livro create(@RequestBody Livro livro) {
        return livroRepository.save(livro);
    }

    // Buscar por id
    @GetMapping("/livros/{id}")
    public Livro show(@PathVariable Long id) {
        return livroRepository.findById(id).orElse(null);
    }

    // Deletar
    @DeleteMapping("/livros/{id}")
    public void delete(@PathVariable Long id) {
        livroRepository.deleteById(id);
    }

    // Atualizar
    @PutMapping("/livros/{id}")
    public Livro update(@PathVariable Long id, @RequestBody Livro livroAtualizado) {
        Optional<Livro> livroExistente = livroRepository.findById(id);
    
        if (livroExistente.isPresent()) {
            Livro livro = livroExistente.get();

            livro.setNome(livroAtualizado.getNome());
            livro.setDescricao(livroAtualizado.getDescricao());
            livro.setAutor(livroAtualizado.getAutor());
    
            livroRepository.save(livro);
    
            return livro;
        } else {
            return null;
        }
    }
}
