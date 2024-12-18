package com.example.libro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.libro.model.Libro;
import com.example.libro.repository.LibroRepository;

@Service // Indica che questa classe è un servizio di Spring, che contiene la logica di business.
public class LibroService 
{
    @Autowired // Utilizzato per l'iniezione delle dipendenze. In questo caso, libroRepository viene iniettato nel LibroService
    private LibroRepository libroRepository;

    /**
     * Recupera tutti i libri dal database
     * @return Lista dei libri
     */
    public List<Libro> findAll()
    {
        return libroRepository.findAll();
    }

    /**
     * Cerca un libro per ID
     * @param id id del libro da cercare
     * @return restituisce un Optional<Libro> per gestire il caso in cui il libro non venga trovato.
     */
    public Optional<Libro> findById(long id) 
    {
        return libroRepository.findById(id);
    }

    /**
     * Salva un nuovo libro o aggiorna uno esistente.
     * 
     * @param libro libro da salvare o aggiornare
     * @return libro che è stato salvato, null in caso di errore
     */
    public Libro save(Libro libro) 
    {
        return libroRepository.save(libro);
    }
    
    /**
     * Elimina un libro per ID.
     * @param id ID del libro da eliminare
     */
    public void deleteById(Long id) 
    {
        libroRepository.deleteById(id);
    }
}
