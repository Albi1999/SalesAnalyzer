// Usiamo 'record' invece di 'class'
public record Prodotto(String idProdotto, String nome, String categoria, double prezzoUnitario) {
    // I record in Java sono una forma compatta di classe che fornisce automaticamente
    // metodi come equals(), hashCode() e toString() basati sui campi definiti.
    // Non abbiamo bisogno di dichiarare esplicitamente i campi, i record li gestiscono automaticamente.
    // I campi sono finali e non possono essere modificati dopo la creazione dell'istanza.
    // I record sono immutabili per definizione, quindi non abbiamo bisogno di metodi setter.

    // Possiamo aggiungere metodi personalizzati se necessario, come visualizzaDettagli
    // ma per i record, toString() generato automaticamente è spesso sufficiente.
    public void visualizzaDettagli() {
        System.out.println("ID Prodotto: " + idProdotto()); // Nota: i getter sono metodi con lo stesso nome del componente
        System.out.println("Nome: " + nome());
        System.out.println("Categoria: " + categoria());
        System.out.println("Prezzo Unitario: " + prezzoUnitario() + " euro");
    }

    // Possiamo anche aggiungere costruttori "compatti" o "personalizzati" se serve validazione
    // Esempio di costruttore compatto per validazione (opzionale)
    public Prodotto { // Questo è il "compact constructor"
        if (prezzoUnitario < 0) {
            throw new IllegalArgumentException("Il prezzo unitario non può essere negativo.");
        }
    }
}