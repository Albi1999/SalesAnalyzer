public interface Scontabile {
    // Metodo astratto: una classe che implementa Scontabile DEVE fornire l'implementazione di questo metodo.
    // È implicitamente public e abstract.
    void applicaSconto(double percentualeSconto);

    // Metodo default: ha un'implementazione di base ma può essere sovrascritto.
    // Utile se in futuro vogliamo aggiungere un nuovo metodo all'interfaccia
    // senza dover modificare tutte le classi esistenti che la implementano.
    default double getPrezzoDopoSconto(double prezzoOriginale, double percentualeSconto) {
        if (percentualeSconto < 0 || percentualeSconto > 100) {
            System.out.println("Percentuale di sconto non valida per il calcolo.");
            return prezzoOriginale; // Restituisce il prezzo originale in caso di errore
        }
        return prezzoOriginale * (1 - percentualeSconto / 100);
    }
}