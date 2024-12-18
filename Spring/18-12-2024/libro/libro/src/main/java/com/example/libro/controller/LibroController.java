package com.example.libro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.libro.model.Libro;
import com.example.libro.service.LibroService;

@RestController // Indica che questa classe è un controller RESTful di Spring.
@RequestMapping("/api/libri") // Mappa tutte le richieste a livello di classe all'URL di base /api/libri.
public class LibroController {
    @Autowired // Inietta LibroService nel controller.
    private LibroService libroService;

    /**
     * Restituisce una lista di tutti i libri.
     * 
     * @return lista di tutti i libri
     */
    @GetMapping // Mappa le richieste GET all'URL /api/libri.
    public List<Libro> getAllLibri() {
        return libroService.findAll();
    }

    /**
     * Cerca un libro per ID e restituisce un ResponseEntity
     * contenente il libro o un 404 Not Found se il libro non esiste.
     * 
     * @param id ID del libro
     * @return un ResponseEntity contenente il libro o un 404 Not Found se il libro
     *         non esiste.
     */
    @GetMapping("/{id}") // Mappa le richieste GET all'URL /api/libri/{id}
    public ResponseEntity<Libro> geLibroById(@PathVariable Long id) {
        Optional<Libro> libro = libroService.findById(id);

        if (libro.isPresent())
            return ResponseEntity.ok(libro.get());

        return ResponseEntity.notFound().build();

    }

    /**
     * Crea un nuovo libro usando i dati forniti nel corpo della richiesta
     * 
     * @param libro Libro da inseire
     * @return Libro inserito, null in caso di errore
     */
    @PostMapping // Mappa le richieste POST all'URL /api/libri.
    public Libro createLibro(@RequestBody Libro libro) {
        return libroService.save(libro);
    }

    /**
     * Aggiorna un libro esistente con i dati forniti.
     * 
     * @param id           ID del libro da modificare
     * @param libroDetails detagli del libro modificato
     * @return Restituisce un ResponseEntity con il libro aggiornato o un 404 Not
     *         Found se il libro non esiste.
     */
    @PutMapping("/{id}") // Mappa le richieste PUT all'URL /api/libri/{id}
    public ResponseEntity<Libro> updateLibro(@PathVariable Long id, @RequestBody Libro libroDetails) {

        Optional<Libro> libroOptional = libroService.findById(id);

        if (libroOptional.isPresent()) {
            Libro libro = libroOptional.get();
            libro.setTitolo(libroDetails.getTitolo());
            libro.setAutore(libroDetails.getAutore());
            libro.setPrezzo(libroDetails.getPrezzo());
            return ResponseEntity.ok(libroService.save(libro));
        }

        return ResponseEntity.notFound().build();

    }

    /**
     * Elimina un libro per ID.
     * 
     * @param id ID del libro
     * @return Restituisce un ResponseEntity con status 204 No Content se
     *         l'eliminazione ha successo o un 404 Not Found se il libro non esiste
     */
    @DeleteMapping("/{id}") // Mappa le richieste DELETE all'URL /api/libri/{id}.
    public ResponseEntity<Void> deleteLibro(@PathVariable Long id) {
        Optional<Libro> libro = libroService.findById(id);

        if (libro.isPresent()) {
            libroService.deleteById(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

}
