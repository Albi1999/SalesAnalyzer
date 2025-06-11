package com.maggioli.salesanalyzer.app;

import com.maggioli.salesanalyzer.model.Prodotto;
import com.maggioli.salesanalyzer.model.ProdottoDigitale;
import com.maggioli.salesanalyzer.model.ProdottoFisico;
import com.maggioli.salesanalyzer.model.TransazioneVendita;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // Creazione di un primo oggetto Prodotto
        // new Prodotto() invoca il costruttore della classe Prodotto per creare una nuova istanza
        Prodotto smartphone = new Prodotto("P005", "Smartphone", "Elettronica", 800.00);
        Prodotto libro = new Prodotto("P006", "Libro di Programmazione", "Libri", 30.00);

        // Creazione di oggetti ProdottoFisico e ProdottoDigitale
        ProdottoFisico laptop = new ProdottoFisico("P001", "Laptop", "Elettronica", 1200.00, 2.5, 30.0 * 20.0 * 2.0);
        ProdottoFisico maglietta = new ProdottoFisico("P002", "Maglietta", "Abbigliamento", 25.50, 0.2, 20.0 * 15.0 * 1.0);
        ProdottoDigitale libroJavaPDF = new ProdottoDigitale("P003", "Libro Java (PDF)", "Libri", 40.00, "PDF", 50.0);
        ProdottoDigitale canzoneMP3 = new ProdottoDigitale("P004", "Canzone (MP3)", "Musica", 1.99, "MP3", 5.0);

        // Creazione di un secondo oggetto Prodotto con un prezzo negativo per testare la validazione
//        Prodotto prodottoConPrezzoNegativo = new Prodotto("P005", "Prodotto con Prezzo Negativo", "Test", -50.00);
//
//    Output ottenuto:
//        Exception in thread "main" java.lang.IllegalArgumentException: Il prezzo unitario non può essere negativo.
//                at Prodotto.<init>(Prodotto.java:25)
//        at Main.main(Main.java:13)

        // In questo caso stiamo accedendo direttamente agli attributi dell'oggetto Prodotto perchè l'abbiamo reso pubblico
        System.out.println("Prezzo del Laptop (accedendo direttamente): " + laptop.getPrezzoUnitario());

        // Metodo visualizzaDettagli() per stampare i dettagli dei prodotti
        System.out.println("Dettagli dei prodotti:");
        laptop.visualizzaDettagli(); // Chiamata al metodo visualizzaDettagli() della classe ProdottoFisico
        System.out.println("---");
        smartphone.visualizzaDettagli(); // Chiamata al metodo visualizzaDettagli() della classe Prodotto
        System.out.println("---");
        libro.visualizzaDettagli(); // Chiamata al metodo visualizzaDettagli() della classe Prodotto
        System.out.println("---");
        libroJavaPDF.visualizzaDettagli(); // Chiamata al metodo visualizzaDettagli() della classe ProdottoDigitale
        System.out.println("---");
        maglietta.visualizzaDettagli(); // Chiamata al metodo visualizzaDettagli() della classe ProdottoFisico
        System.out.println("---");
        canzoneMP3.visualizzaDettagli(); // Chiamata al metodo visualizzaDettagli() della classe ProdottoDigitale

        // Sconto sui prodotti
        System.out.println("\n--- Dimostrazione Interfaccia Scontabile ---");
        System.out.println("Prezzo originale Laptop: " + String.format("%.2f", laptop.getPrezzoUnitario()));
        laptop.applicaSconto(10); // Chiama il metodo implementato da Prodotto
        System.out.println("Prezzo dopo sconto 10% sul laptop: " + String.format("%.2f", laptop.getPrezzoUnitario()));
        System.out.println("Prezzo teorico dopo un altro sconto del 5% (senza applicarlo): " +
                String.format("%.2f", laptop.getPrezzoDopoSconto(laptop.getPrezzoUnitario(), 5))); // Usa il metodo default dell'interfaccia

        System.out.println("---");
        System.out.println("Prezzo originale Maglietta: " + String.format("%.2f", maglietta.getPrezzoUnitario()));
        maglietta.applicaSconto(20);
        System.out.println("Prezzo dopo sconto 20% sulla maglietta: " + String.format("%.2f", maglietta.getPrezzoUnitario()));
        System.out.println("---");
        System.out.println("Prezzo originale Canzone MP3: " + String.format("%.2f", canzoneMP3.getPrezzoUnitario()));
        canzoneMP3.applicaSconto(50); // Sconto del 50% su un prodotto digitale
        System.out.println("Prezzo dopo sconto 50% sulla canzone MP3: " + String.format("%.2f", canzoneMP3.getPrezzoUnitario()));
        System.out.println("---");

        // Creazione di oggetti TransazioneVendita
        // Ogni transazione fa riferimento a un oggetto Prodotto
        // *** Ora usiamo una List generica per memorizzare le TransazioniVendita ***
        // List<TransazioneVendita> dichiara una lista che conterrà SOLO oggetti di tipo TransazioneVendita
        // ArrayList<TransazioneVendita> è un'implementazione concreta di List
        List<TransazioneVendita> tutteLeTransazioni = new ArrayList<>();

        // Creiamo le transazioni e le aggiungiamo alla lista
        TransazioneVendita transazione1 = new TransazioneVendita("T001", laptop, 1, "2024-05");
        tutteLeTransazioni.add(transazione1); // Aggiunge l'oggetto alla lista

        TransazioneVendita transazione2 = new TransazioneVendita("T002", maglietta, 2, "2024-05");
        tutteLeTransazioni.add(transazione2);

        TransazioneVendita transazione3 = new TransazioneVendita("T003", libroJavaPDF, 1, "2024-06");
        tutteLeTransazioni.add(transazione3);

        TransazioneVendita transazione4 = new TransazioneVendita("T004", laptop, 5, "2024-06");
        tutteLeTransazioni.add(transazione4);

        TransazioneVendita transazione5 = new TransazioneVendita("T005", canzoneMP3, 10, "2024-06");
        tutteLeTransazioni.add(transazione5);

        TransazioneVendita transazione6 = new TransazioneVendita("T001", laptop, 1, "2024-05"); // Stessa ID della transazione 1

        tutteLeTransazioni.add(new TransazioneVendita("T006", maglietta, 1, "2024-06"));
        tutteLeTransazioni.add(new TransazioneVendita("T007", libroJavaPDF, 3, "2024-05"));
        tutteLeTransazioni.add(new TransazioneVendita("T008", laptop, 2, "2024-05"));
        tutteLeTransazioni.add(new TransazioneVendita("T009", canzoneMP3, 5, "2024-06"));
        tutteLeTransazioni.add(new TransazioneVendita("T010", maglietta, 3, "2024-05"));

        // Tentativo di aggiungere un oggetto di tipo sbagliato
        // tutteLeTransazioni.add("Non è una transazione!"); // ERRORE DI COMPILAZIONE! I Generics prevengono questo.

        System.out.println("\n--- Elenco Dettagli delle Transazioni dalla Lista ---");
        // Iteriamo sulla lista usando un for-each loop
        for (TransazioneVendita trans : tutteLeTransazioni) {
            trans.visualizzaDettagliTransazione();
            System.out.println("---");
        }

        // Utilizzo del Generic per calcolare il ricavo totale
        System.out.println("\n--- Analisi Totale Ricavi (Metodo Generico) ---");
        double ricavoTotale = TransazioneVendita.calcolaRicavoTotaleLista(tutteLeTransazioni);
        System.out.println("Ricavo totale da tutte le transazioni: " + String.format("%.2f", ricavoTotale) + " euro.");


        // Funzioni di Stream API per filtrare, ordinare e raccogliere le transazioni (utilizzando Lambda e Method References)
        System.out.println("\n--- Filtrare Transazioni del Mese di Maggio 2024 ---");
        // filter() prende un Predicate (un'interfaccia funzionale con un metodo boolean test(T t))
        // QuataVendita().eqi usiamo una lambda: trans -> trans.getDuals("2024-05")
        List<TransazioneVendita> transazioniMaggio = tutteLeTransazioni.stream() // Ottiene uno stream dalla lista
                // L'utilizzo di una stream permette di convertire la collezione in un flusso di elementi su cui è possibile eseguire operazioni.
                .filter(trans -> trans.getDataVendita().equals("2024-05")) // Filtra usando una funzione Lambda
                .collect(Collectors.toList()); // Raccoglie i risultati in una nuova lista

        System.out.println("Transazioni di Maggio 2024:");
        transazioniMaggio.forEach(trans -> trans.visualizzaDettagliTransazione()); // forEach() prende un Consumer (void accept(T t))
        // Funzione lambda usata per stampare ogni transazione
        System.out.println("---");

        System.out.println("\n--- Ricavo Totale per Categoria 'Elettronica' ---");
        // Filtriamo per categoria e poi sommiamo i ricavi
        double ricavoElettronica = tutteLeTransazioni.stream()
                .filter(trans -> trans.getCategoriaProdotto().equals("Elettronica")) // Filtra per categoria
                .mapToDouble(TransazioneVendita::calcolaRicavoTotale) // Mappa ogni transazione al suo ricavo (method reference)
                // mapToDouble() permette di trasformare ogni elemento dello stream in un double
                .sum(); // Somma tutti i ricavi

        System.out.println("Ricavo totale dalla categoria Elettronica: " + String.format("%.2f", ricavoElettronica) + " euro.");
        System.out.println("---");

        System.out.println("\n--- Transazioni Ordinate per Ricavo Decrescente ---");
        // sorted() prende un Comparator (un'interfaccia funzionale con un metodo int compare(T o1, T o2))
        // Qui usiamo una lambda per definire il criterio di ordinamento
        List<TransazioneVendita> transazioniOrdinate = tutteLeTransazioni.stream()
                .sorted((t1, t2) -> Double.compare(t2.calcolaRicavoTotale(), t1.calcolaRicavoTotale())) // Lambda per ordinamento decrescente
                .collect(Collectors.toList());

        transazioniOrdinate.forEach(trans -> System.out.println("ID: " + trans.getIdTransazione() + ", Ricavo: " + String.format("%.2f", trans.calcolaRicavoTotale())));
        System.out.println("---");


        // Verifica del calcolo del ricavo totale
        System.out.println("\n--- Dimostrazione Interfaccia ComparabilePerRicavo ---");
        // Metodo default dell'interfaccia per confrontare le transazioni
        transazione4.stampaConfrontoRicavo(transazione1); // Transazione 4 ha un ricavo maggiore (5 laptop vs 1 laptop)
        transazione3.stampaConfrontoRicavo(transazione5); // Libro vs Canzoni
        transazione2.stampaConfrontoRicavo(transazione2); // Stesso ricavo

        System.out.println("\nVerifica di equals():");
        System.out.println("Transazione 1 == Transazione 5 (diverso ID, oggetti diversi): " + transazione1.equals(transazione5));
        System.out.println("Transazione 1 == Transazione 6 (stesso ID, oggetti diversi): " + transazione1.equals(transazione6)); // Dovrebbe essere true

        System.out.println("\nVerifica di hashCode():");
        System.out.println("Hash di Transazione 1: " + transazione1.hashCode());
        System.out.println("Hash di Transazione 5: " + transazione5.hashCode());
        System.out.println("Hash di Transazione 6: " + transazione6.hashCode()); // Dovrebbe essere uguale a transazione1.hashCode()

        Set<TransazioneVendita> setDiTransazioni = new HashSet<>();
        setDiTransazioni.add(transazione1);
        setDiTransazioni.add(transazione5);
        setDiTransazioni.add(transazione6); // Questo elemento non verrà aggiunto se equals/hashCode sono corretti, perché è considerato "uguale" a transazione1

        System.out.println("Dimensione del set di transazioni: " + setDiTransazioni.size()); // Dovrebbe essere 2 (T001, T005)

        System.out.println("\nVerifica di toString():");
        System.out.println("Rappresentazione Transazione 1: " + transazione1.toString()); // Si può usare anche solo System.out.println(transazione1);
        System.out.println("Rappresentazione Transazione 2: " + transazione2);

        System.out.println("\nEsempi di Numeri e Stringhe:");

        // Operazioni su numeri primitivi
        int a = 10;
        int b = 3;
        double risultatoDivisione = (double) a / b; // Cast a double per ottenere risultato decimale
        System.out.println("10 / 3 = " + risultatoDivisione);

        // Operazioni con classi wrapper (per convertire stringhe in numeri)
        String prezzoString = "123.45";
        double prezzoDouble = Double.parseDouble(prezzoString); // Converte String a double
        System.out.println("Prezzo da stringa: " + prezzoDouble);

        String quantitaString = "50";
        int quantitaInt = Integer.parseInt(quantitaString); // Converte String a int
        System.out.println("Quantità da stringa: " + quantitaInt);

        // Manipolazione di stringhe
        String saluto = "Hello, Java!";
        System.out.println("Lunghezza del saluto: " + saluto.length());
        System.out.println("Il saluto contiene 'Java': " + saluto.contains("Java"));
        System.out.println("Saluto in maiuscolo: " + saluto.toUpperCase());
        System.out.println("Sostituzione di 'Java' con 'World': " + saluto.replace("Java", "World"));

        // Le stringe in java sono immutabili, quindi ogni operazione che sembra modificarle in realtà crea una nuova stringa
        String original = "Original";
        String modified = original.concat("ly modified"); // Crea una nuova stringa
        System.out.println("Original: " + original);
        System.out.println("Modified: " + modified);

        // Esempio di accesso a data parts dalla transazione
        System.out.println("Anno della transazione 1: " + transazione1.getAnnoVendita());
        System.out.println("Mese della transazione 1: " + transazione1.getMeseVendita());

        // --- Dimostrazione del Pattern Matching ---
        System.out.println("\n--- Dimostrazione Pattern Matching (instanceof) ---");
        // Ipotizziamo di avere una lista mista di prodotti (polimorfismo)
        List<Prodotto> tuttiIProdotti = new ArrayList<>();
        tuttiIProdotti.add(laptop);
        tuttiIProdotti.add(maglietta);
        tuttiIProdotti.add(libroJavaPDF);
        tuttiIProdotti.add(canzoneMP3);
        tuttiIProdotti.add(new Prodotto("P005", "Servizio Consulenza", "Servizi", 500.0));

        for (Prodotto p : tuttiIProdotti) {
            System.out.print("Processing product: " + p.getNome() + ". ");

            // Pattern Matching for instanceof
            if (p instanceof ProdottoFisico pf) { // Se p è un ProdottoFisico, lo assegna a pf
                System.out.println("È un Prodotto Fisico con peso: " + pf.pesoKG + " kg.");
            } else if (p instanceof ProdottoDigitale pd) { // Se p è un ProdottoDigitale, lo assegna a pd
                System.out.println("È un Prodotto Digitale con formato: " + pd.formatoFile);
            } else {
                System.out.println("È un Prodotto generico o sconosciuto.");
            }
        }
        System.out.println("---");

        System.out.println("\n--- Dimostrazione Pattern Matching (switch) ---");
        for (Prodotto p : tuttiIProdotti) {
            String tipoSpeciale = switch (p) {
                    case ProdottoFisico pf when pf.pesoKG < 1.0 -> "Prodotto Fisico Leggero";
                    case ProdottoFisico pf -> "Prodotto Fisico Leggero";
                    case ProdottoDigitale pd when pd.dimensioneMB > 20.0 -> "Prodotto Digitale Grande";
                    case ProdottoDigitale pd -> "Prodotto Digitale Piccolo";
                    default -> "Prodotto Standard"; // Gestisce qualsiasi altro tipo di Prodotto
            };
            System.out.println(p.getNome() + " è un: " + tipoSpeciale);
        }
        System.out.println("---");



        // --- Dimostrazione gestione eccezioni con try-catch ---
        System.out.println("\n--- Gestione Eccezioni ---");

        // Esempio 1: Gestione di IllegalArgumentException (Unchecked)
        System.out.println("\nTest creazione TransazioneVendita con quantità non valida:");
        try {
            // Questa linea lancerà una IllegalArgumentException
            TransazioneVendita transazioneInvalida = new TransazioneVendita("T_INVALID", laptop, 0, "2024-05");
            transazioneInvalida.visualizzaDettagliTransazione(); // Questa linea non sarà raggiunta
        } catch (IllegalArgumentException e) {
            // Il blocco catch cattura l'eccezione
            System.err.println("Errore di input nella transazione: " + e.getMessage()); // System.err stampa su stream errori
        } finally {
            // Questo blocco viene sempre eseguito
            System.out.println("Blocco finally per la creazione della transazione.");
        }


        // --- Refactoring a Stile Funzionale con Stream API ---
        System.out.println("\n--- Refactoring a Stile Funzionale ---");

        // 1. Prodotto più venduto per quantità
        // Usiamo Collectors.groupingBy per aggregare per ID Prodotto
        // e poi Collectors.summingInt per sommare le quantità per ogni gruppo
        Map<String, Integer> quantitaVendutaPerProdotto = tutteLeTransazioni.stream()
                .collect(Collectors.groupingBy(
                        trans -> trans.getProdottoVenduto().getIdProdotto(), // La chiave per il raggruppamento (ID Prodotto)
                        Collectors.summingInt(TransazioneVendita::getQuantitaVenduta) // Il valore da aggregare (somma delle quantità)
                ));

        // Trovare il prodotto con la quantità massima
        Optional<Map.Entry<String, Integer>> prodottoPiuVendutoEntry = quantitaVendutaPerProdotto.entrySet().stream()
                .max(Map.Entry.comparingByValue()); // Trova l'elemento con il valore massimo

        // Gestione del caso in cui non ci siano prodotti
        if (prodottoPiuVendutoEntry.isPresent()) {
            String idProdottoPiuVenduto = prodottoPiuVendutoEntry.get().getKey();
            int maxQuantita = prodottoPiuVendutoEntry.get().getValue();
            // Trova il nome del prodotto usando l'ID
            String nomeProdottoPiuVenduto = tuttiIProdotti.stream()
                    .filter(p -> p.getIdProdotto().equals(idProdottoPiuVenduto))
                    .map(Prodotto::getNome) // Mappa al nome del prodotto
                    .findFirst() // Prende il primo (dovrebbe essercene solo uno con quell'ID)
                    .orElse("Sconosciuto"); // Gestisce il caso in cui non venga trovato

            System.out.println("Prodotto più venduto per quantità: " + nomeProdottoPiuVenduto + " (ID: " + idProdottoPiuVenduto + "), Quantità: " + maxQuantita);
        } else {
            System.out.println("Nessun prodotto venduto.");
        }
        System.out.println("---");

        // 2. Ricavo totale per categoria
        Map<String, Double> ricavoPerCategoria = tutteLeTransazioni.stream()
                .collect(Collectors.groupingBy(
                        TransazioneVendita::getCategoriaProdotto, // Raggruppa per categoria
                        Collectors.summingDouble(TransazioneVendita::calcolaRicavoTotale) // Somma i ricavi
                ));

        System.out.println("Ricavo totale per categoria:");
        ricavoPerCategoria.forEach((categoria, ricavo) ->
                System.out.println("  " + categoria + ": " + String.format("%.2f", ricavo) + " euro")
        );
        System.out.println("---");

        // 3. Filtra transazioni di Giugno 2024 e ordina per ricavo
        System.out.println("\nTransazioni di Giugno 2024 ordinate per ricavo (decrescente):");
        tutteLeTransazioni.stream()
                .filter(trans -> trans.getDataVendita().equals("2024-06")) // Filtra
                .sorted(Comparator.comparingDouble(TransazioneVendita::calcolaRicavoTotale).reversed()) // Ordina per ricavo decrescente
                .limit(2) // Prende solo i primi 2 risultati
                .map(t -> "ID: " + t.getIdTransazione() + ", Prodotto: " + t.getProdottoVenduto().getNome() +
                        ", Ricavo: " + String.format("%.2f", t.calcolaRicavoTotale())) // Trasforma in Stringa per stampa
                .forEach(System.out::println); // Stampa ogni stringa
        System.out.println("---");

    }
}