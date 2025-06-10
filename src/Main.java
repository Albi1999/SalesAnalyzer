import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        // Creazione di un primo oggetto Prodotto
        // new Prodotto() invoca il costruttore della classe Prodotto per creare una nuova istanza
        Prodotto laptop = new Prodotto("P001", "Laptop", "Elettronica", 1200.00);
        Prodotto smartphone = new Prodotto("P002", "Smartphone", "Elettronica", 800.00);
        Prodotto libro = new Prodotto("P003", "Libro di Programmazione", "Libri", 30.00);
        Prodotto maglietta = new Prodotto("P004", "Maglietta", "Abbigliamento", 20.00);

        // In questo caso stiamo accedendo direttamente agli attributi dell'oggetto Prodotto perchè l'abbiamo reso pubblico
        System.out.println("Prezzo del Laptop (accedendo direttamente): " + laptop.prezzoUnitario());

        // Metodo visualizzaDettagli() per stampare i dettagli dei prodotti
        System.out.println("Dettagli dei prodotti:");
        laptop.visualizzaDettagli();
        System.out.println("---");
        smartphone.visualizzaDettagli();
        System.out.println("---");
        libro.visualizzaDettagli();
        System.out.println("---");
        maglietta.visualizzaDettagli();
        System.out.println("---");

        // Creazione di oggetti TransazioneVendita
        // Ogni transazione fa riferimento a un oggetto Prodotto
        TransazioneVendita transazione1 = new TransazioneVendita("T001", laptop, 1, "2024-05");
        TransazioneVendita transazione2 = new TransazioneVendita("T002", smartphone, 2, "2024-06");
        TransazioneVendita transazione3 = new TransazioneVendita("T003", libro, 3, "2024-07");
        TransazioneVendita transazione4 = new TransazioneVendita("T004", maglietta, 5, "2024-08");
        TransazioneVendita transazione5 = new TransazioneVendita("T001", laptop, 1, "2024-05");
        TransazioneVendita transazione6 = new TransazioneVendita("T005", libro, 2, "2024-06");

        // Visualizzazione
        System.out.println("\nDettagli delle transazioni:");
        transazione1.visualizzaDettagliTransazione();
        System.out.println("---");
        transazione2.visualizzaDettagliTransazione();
        System.out.println("---");
        transazione3.visualizzaDettagliTransazione();
        System.out.println("---");
        transazione4.visualizzaDettagliTransazione();

        System.out.println("\nVerifica di equals():");
        System.out.println("Transazione 1 == Transazione 5 (stesso ID, oggetti diversi): " + transazione1.equals(transazione5)); // Dovrebbe essere true (stesso ID logico)
        System.out.println("Transazione 1 == Transazione 6 (diverso ID, oggetti diversi): " + transazione1.equals(transazione6)); // Dovrebbe essere false

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

    }
}