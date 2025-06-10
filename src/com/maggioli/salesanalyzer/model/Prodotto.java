package com.maggioli.salesanalyzer.model;

import com.maggioli.salesanalyzer.interfaces.Scontabile;

import java.util.Objects;

public class Prodotto implements Scontabile {
    protected String idProdotto;
    protected String nome;
    protected String categoria;
    protected double prezzoUnitario;

    // Costruttore manuale
    public Prodotto(String idProdotto, String nome, String categoria, double prezzoUnitario) {
        if (prezzoUnitario < 0.0) {
            throw new IllegalArgumentException("Il prezzo unitario non può essere negativo.");
        }
        if (idProdotto == null || idProdotto.trim().isEmpty()) { // Valida che l'ID non sia vuoto (String methods)
            // trim() rimuove spazi bianchi all'inizio e alla fine di una stringa
            throw new IllegalArgumentException("L'ID del prodotto non può essere nullo o vuoto.");
        }
        this.idProdotto = idProdotto;
        this.nome = nome;
        this.categoria = categoria;
        this.prezzoUnitario = prezzoUnitario;
    }

    // Metodi Getter manuali (necessari perché non è più un record)
    public String getIdProdotto() { return idProdotto; }
    public String getNome() { return nome; }
    public String getCategoria() { return categoria; }
    public double getPrezzoUnitario() { return prezzoUnitario; }

    @Override
    public void applicaSconto(double percentualeSconto) {
        if (percentualeSconto > 0 && percentualeSconto <= 100) {
            // Calcola il nuovo prezzo dopo lo sconto
            this.prezzoUnitario = getPrezzoDopoSconto(this.prezzoUnitario, percentualeSconto); // Metodo default dell'interfaccia
            System.out.println("Sconto del " + percentualeSconto + "% applicato. Nuovo prezzo: " + String.format("%.2f", this.prezzoUnitario) + " euro");
        } else {
            System.out.println("Percentuale di sconto non valida.");
        }
    }


    // Metodo per visualizzare i dettagli (utilizza i getter)
    public void visualizzaDettagli() {
        System.out.println("ID com.maggioli.salesanalyzer.model.Prodotto: " + getIdProdotto());
        System.out.println("Nome: " + getNome());
        System.out.println("Categoria: " + getCategoria());
        System.out.println("Prezzo base: " + String.format("%.2f", getPrezzoUnitario()) + " euro");
        // %.2f significa <un numero in virgola mobile con due cifre decimali>
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prodotto prodotto = (Prodotto) o;
        return Objects.equals(idProdotto, prodotto.idProdotto);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(idProdotto);
    }

    @Override
    public String toString() {
        return "com.maggioli.salesanalyzer.model.Prodotto{" +
                "idProdotto='" + idProdotto + '\'' +
                ", nome='" + nome + '\'' +
                ", categoria='" + categoria + '\'' +
                ", prezzoUnitario=" + prezzoUnitario +
                '}';
    }
}


// Precedente implementazione come record

//public record com.maggioli.salesanalyzer.model.Prodotto(String idProdotto, String nome, String categoria, double prezzoUnitario) {
//    // I record in Java sono una forma compatta di classe che fornisce automaticamente
//    // metodi come equals(), hashCode() e toString() basati sui campi definiti.
//    // Non abbiamo bisogno di dichiarare esplicitamente i campi, i record li gestiscono automaticamente.
//    // I campi sono finali e non possono essere modificati dopo la creazione dell'istanza.
//    // I record sono immutabili per definizione, quindi non abbiamo bisogno di metodi setter.
//
//    // Possiamo aggiungere metodi personalizzati se necessario, come visualizzaDettagli
//    // ma per i record, toString() generato automaticamente è sufficiente.
//    public void visualizzaDettagli() {
//        System.out.println("ID com.maggioli.salesanalyzer.model.Prodotto: " + idProdotto());
//        System.out.println("Nome: " + nome());
//        System.out.println("Categoria: " + categoria());
//        // Formattazione del prezzo a due decimali usando String.format()
//        System.out.println("Prezzo Unitario: " + String.format("%.2f", prezzoUnitario()) + " euro");
//        // %.2f significa "un numero in virgola mobile con due cifre decimali"
//    }
//
//    // Possiamo anche aggiungere costruttori "compatti" o "personalizzati" se serve validazione
//    // Compact constructor per validazione (mostra l'uso di numeri e controllo)
//    public com.maggioli.salesanalyzer.model.Prodotto {
//        // Valida che il prezzo unitario sia un numero positivo
//        if (prezzoUnitario < 0.0) { // Qui usiamo il tipo primitivo double
//            throw new IllegalArgumentException("Il prezzo unitario non può essere negativo.");
//        }
//        if (idProdotto == null || idProdotto.trim().isEmpty()) { // Valida che l'ID non sia vuoto (String methods)
//            throw new IllegalArgumentException("L'ID del prodotto non può essere nullo o vuoto.");
//
//            // trim() rimuove spazi bianchi all'inizio e alla fine di una stringa
//        }
//    }
//}