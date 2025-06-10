import java.util.HashSet;
import java.util.Set;

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
//        Exception in thread "main" java.lang.IllegalArgumentException: Il prezzo unitario non può essere negativo.
//                at Prodotto.<init>(Prodotto.java:25)
//        at Main.main(Main.java:13)

        // In questo caso stiamo accedendo direttamente agli attributi dell'oggetto Prodotto perchè l'abbiamo reso pubblico
        System.out.println("Prezzo del Laptop (accedendo direttamente): " + laptop.prezzoUnitario);

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
        TransazioneVendita transazione1 = new TransazioneVendita("T001", laptop, 1, "2024-05");
        TransazioneVendita transazione2 = new TransazioneVendita("T002", maglietta, 2, "2024-05");
        TransazioneVendita transazione3 = new TransazioneVendita("T003", libroJavaPDF, 1, "2024-06");
        TransazioneVendita transazione4 = new TransazioneVendita("T005", laptop, 5, "2024-06");
        TransazioneVendita transazione5 = new TransazioneVendita("T005", canzoneMP3, 10, "2024-06");
        TransazioneVendita transazione6 = new TransazioneVendita("T001", smartphone, 3, "2024-07");

        // Visualizzazione
        System.out.println("\nDettagli delle Transazioni di Vendita:");
        transazione1.visualizzaDettagliTransazione();
        System.out.println("---");
        transazione2.visualizzaDettagliTransazione();
        System.out.println("---");
        transazione3.visualizzaDettagliTransazione();
        System.out.println("---");
        transazione4.visualizzaDettagliTransazione();
        System.out.println("---");
        transazione5.visualizzaDettagliTransazione();
        System.out.println("---");

        // Verifica del calcolo del ricavo totale
        System.out.println("\n--- Dimostrazione Interfaccia ComparabilePerRicavo ---");
        // Usare metodo default dell'interfaccia per confrontare le transazioni
        transazione4.stampaConfrontoRicavo(transazione1); // Transazione 4 ha un ricavo maggiore (5 laptop vs 1 laptop)
        transazione3.stampaConfrontoRicavo(transazione5); // Libro vs Canzoni
        transazione2.stampaConfrontoRicavo(transazione2); // Stesso ricavo

        System.out.println("\nVerifica di equals():");
        System.out.println("Transazione 1 == Transazione 5 (diverso ID, oggetti diversi): " + transazione1.equals(transazione5));
        System.out.println("Transazione 1 == Transazione 6 (stesso ID, oggetti diversi): " + transazione1.equals(transazione6)); // Dovrebbe essere true

        System.out.println("\nVerifica di hashCode():");
        System.out.println("Hash di Transazione 1: " + transazione1.hashCode());
        System.out.println("Hash di Transazione 5: " + transazione5.hashCode()); // Dovrebbe essere uguale a transazione1.hashCode()
        System.out.println("Hash di Transazione 6: " + transazione6.hashCode());

        Set<TransazioneVendita> setDiTransazioni = new HashSet<>();
        setDiTransazioni.add(transazione1);
        setDiTransazioni.add(transazione5); // Questo elemento non verrà aggiunto se equals/hashCode sono corretti, perché è considerato "uguale" a transazione1
        setDiTransazioni.add(transazione6);

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

    }
}