package com.example.libro.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity // Indica che questa classe è un'entità JPA che verrà mappata a una tabella del database.
@Table(name = "libri")
public class Libro 
{
    @Id // Indica il campo id come chiave primaria della tabella.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Specifica che il valore dell'ID sarà generato automaticamente dal database utilizzando una
                                                        //strategia di incremento
    private long id;

    @Column(name = "titolo", nullable = false)
    private String titolo;

    @Column(name = "autore", nullable = false)
    private String autore;

    @Column(name = "prezzo", nullable = false)
    private double prezzo;

    // costruttori
    public Libro() {
    }

    public Libro(String titolo, String autore, double prezzo) {
        this.titolo = titolo;
        this.autore = autore;
        this.prezzo = prezzo;
    }

    // Getter e Setter
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getAutore() {
        return autore;
    }

    public void setAutore(String autore) {
        this.autore = autore;
    }

    public double getPrezzo() {
        return prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    
    
    
    
}