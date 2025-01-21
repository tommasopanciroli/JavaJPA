package org.example;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "evento")
public class Evento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "titolo")
    private String titolo;

    @Column(name = "data_evento")
    private LocalDate dataEvento;

    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "tipo_evento")
    private String tipoEvento;

    @Column(name = "numero_max_partecipanti")
    private int numPartecipanti;

    public Evento() {

    }

    public Evento (String title, LocalDate data, String descr, String eventType, int partecipanti) {
        this.titolo = title;
        this.dataEvento = data;
        this.descrizione = descr;
        this.numPartecipanti = partecipanti;
    }

    public Long getId() {
        return this.id;
    }

    
}
