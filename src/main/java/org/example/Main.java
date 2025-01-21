package org.example;
import jakarta.persistence.EntityManager;
import jdk.jfr.Event;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        EntityManager entity=EntityManagerUtil.getEntityManager();
        try {
            // Avvio di una nuova transazione
            entity.getTransaction().begin();

            // Creazione di una nuova istanza di Evento
            Evento comicon = new Evento("Lucca Comics",LocalDate.of(2025,10,13),
                    "Fiera del fumetto, cosplay e videogames","pubblico",1500);
            // Persistenza della nuova entità nel database
            entity.persist(comicon);

            // Commit della transazione (invio dei comandi al database)
            entity.getTransaction().commit();

            System.out.println("Evento creato con ID: " + comicon.getId());

            // Recupero di un evento per ID
            Long eventoId = comicon.getId(); // Usare l'ID generato
            entity.getTransaction().begin();
            Evento eventoRecuperato = entity.find(Evento.class, eventoId);
            entity.getTransaction().commit();

            if (eventoRecuperato != null) {
                System.out.println("Evento trovato: " + eventoRecuperato.getTitolo());
            } else {
                System.out.println("Evento con ID " + eventoId + " non trovata.");
            }

            // Eliminazione di un evento per ID
            entity.getTransaction().begin();
            Evento eventoDaEliminare = entity.find(Evento.class, eventoId);
            if (eventoDaEliminare != null) {
                entity.remove(eventoDaEliminare);
                System.out.println("Evento con ID " + eventoId + " eliminato.");
            } else {
                System.out.println("Evento con ID " + eventoId + " non trovato per l'eliminazione.");
            }
            entity.getTransaction().commit();


        } catch (Exception e) {
            // Gestione degli errori
            if (entity.getTransaction().isActive()) {
                // Rollback della transazione in caso di errore
                entity.getTransaction().rollback();
            }
            // Stampa del tracciato dell'errore
            e.printStackTrace();
        } finally {
            // Chiusura dell'EntityManager per liberare le risorse
            entity.close();
        }

    }
}