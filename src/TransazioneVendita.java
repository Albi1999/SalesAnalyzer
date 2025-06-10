import java.util.Objects;

public class TransazioneVendita implements ComparabilePerRicavo{
    private String idTransazione;
    private Prodotto prodottoVenduto; // Attributo che è un oggetto della classe Prodotto
    private int quantitaVenduta;
    private String dataVendita; // Formato "YYYY-MM"

    // Costruttore della classe TransazioneVendita
    public TransazioneVendita(String idTransazione, Prodotto prodottoVenduto, int quantitaVenduta, String dataVendita) {
        // Validazione dei numeri e stringhe
        if (quantitaVenduta <= 0) { // La quantità deve essere un numero intero positivo
            throw new IllegalArgumentException("La quantità venduta deve essere un numero positivo.");
        }
        if (dataVendita == null || dataVendita.length() != 7 || !dataVendita.contains("-")) { // Controllo formato data
            throw new IllegalArgumentException("Formato data non valido. Usare 'YYYY-MM'.");
        }
        this.idTransazione = idTransazione;
        this.prodottoVenduto = prodottoVenduto;
        this.quantitaVenduta = quantitaVenduta;
        this.dataVendita = dataVendita;
    }

    // Metodi Getter per accedere agli attributi privati degli oggetti della classe TransazioneVendita
    public String getIdTransazione() { return idTransazione; }
    public Prodotto getProdottoVenduto() { return prodottoVenduto; }
    public int getQuantitaVenduta() { return quantitaVenduta; }
    public String getDataVendita() { return dataVendita; }

    // Metodo (funzione della classe) per calcolare il ricavo della transazione
    public double calcolaRicavoTotale() {
        // Accediamo al prezzo unitario del prodotto venduto della classe Prodotto
        return prodottoVenduto.getPrezzoUnitario() * getQuantitaVenduta();
    }

    // Implementazione del metodo dell'interfaccia ComparabilePerRicavo
    @Override
    public double getValoreRicavo() {
        return calcolaRicavoTotale(); // Il valore per il confronto è il ricavo totale della transazione
    }

    // Metodo per visualizzare i dettagli della transazione usando i getter e i record della classe Prodotto
    public void visualizzaDettagliTransazione() {
        System.out.println("ID Transazione: " + getIdTransazione());
        System.out.println("Prodotto: " + getProdottoVenduto().nome + " (ID: " + getProdottoVenduto().idProdotto + ")");
        System.out.println("Quantità: " + getQuantitaVenduta());
        System.out.println("Data: " + getDataVendita());
        // Formattazione del ricavo totale a due decimali
        System.out.println("Ricavo Totale: " + String.format("%.2f", calcolaRicavoTotale()) + " euro");
    }

    @Override
    public boolean equals(Object o) {
        // Controllo per verificare se sono lo stesso oggetto in memoria
        if (this == o) return true;
        // Controllo per verificare se l'altro oggetto è null o non è dello stesso tipo
        if (o == null || getClass() != o.getClass()) return false;
        // Cast dell'oggetto generico 'o' a TransazioneVendita
        TransazioneVendita that = (TransazioneVendita) o;
        // Confronto degli attributi che definiscono l'uguaglianza logica
        // Si utilizza il metodo Objects.equals() per gestire correttamente i casi in cui gli attributi sono null
        return Objects.equals(idTransazione, that.idTransazione);
    }

    @Override // Indica che stiamo sovrascrivendo il metodo della superclasse (Object)
    public int hashCode() {
        // Genera un has basato sugli stessi attributi usati in equals()
        return Objects.hash(idTransazione);
    }

    @Override
    public String toString() {
        return "TransazioneVendita{" +
                "idTransazione='" + idTransazione + '\'' +
                ", prodottoNome='" + prodottoVenduto.nome + '\'' + // Ci serve solo il nome del prodotto, non l'oggetto completo
                ", quantitaVenduta=" + quantitaVenduta +
                ", dataVendita='" + dataVendita + '\'' +
                ", ricavoTotale=" + String.format("%.2f", calcolaRicavoTotale()) +
                '}';
    }

    // Metodo per estrarre l'anno dalla stringa data
    public int getAnnoVendita() {
        // Utilizziamo il metodo substring della classe String
        String annoString = dataVendita.substring(0, 4); // Prende i primi 4 caratteri (l'anno)
        // Convertiamo la stringa in un intero usando la classe Integer (wrapper)
        return Integer.parseInt(annoString);
    }

    // Metodo per estrarre il mese dalla stringa data
    public int getMeseVendita() {
        String meseString = dataVendita.substring(5, 7); // Prende i caratteri dal 5° al 7° (il mese)
        return Integer.parseInt(meseString);
    }
}
