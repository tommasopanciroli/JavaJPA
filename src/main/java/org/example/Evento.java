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
        this.tipoEvento = eventType;
        this.numPartecipanti = partecipanti;
    }

    public Long getId() {
        return this.id;
    }

    public Long setId(Long id) {
        return this.id = id;
    }

    public String getTitolo () {
        return this.titolo;
    }

    public String setTitolo(String tit) {
        return this.titolo = tit;
    }

    public LocalDate getDataEvento() {
        return this.dataEvento;
    }

    public LocalDate setDataEvento(LocalDate date) {
        return this.dataEvento = date;
    }

    public String getDescrizione() {
        return this.descrizione;
    }

    public String setDescrizione(String descr) {
        return this.descrizione = descr;
    }

    public String getTipoEvento() {
        return this.tipoEvento;
    }

    public String setTipoEvento(String type) {
        return this.tipoEvento = type;
    }

    public int getNumPartecipanti() {
        return this.numPartecipanti;
    }

    public int setNumPartecipanti(int num) {
        return this.numPartecipanti = num;
    }
}
