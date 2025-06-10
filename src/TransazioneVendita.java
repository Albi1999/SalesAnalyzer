import java.util.Objects;

public class TransazioneVendita {
    private String idTransazione;
    private Prodotto prodottoVenduto; // Attributo che è un oggetto della classe Prodotto
    private int quantitaVenduta;
    private String dataVendita;

    // Costruttore della classe TransazioneVendita
    public TransazioneVendita(String idTransazione, Prodotto prodottoVenduto, int quantitaVenduta, String dataVendita) {
        this.idTransazione = idTransazione;
        this.prodottoVenduto = prodottoVenduto;
        this.quantitaVenduta = quantitaVenduta;
        this.dataVendita = dataVendita;
    }

    // Metodi Getter per accedere agli attributi privati degli oggetti della classe TransazioneVendita
    public String getIdTransazione() {
        return idTransazione;
    }

    public Prodotto getProdottoVenduto() {
        return prodottoVenduto;
    }

    public int getQuantitaVenduta() {
        return quantitaVenduta;
    }

    public String getDataVendita() {
        return dataVendita;
    }

    // Metodo (funzione della classe) per calcolare il ricavo della transazione
    public double calcolaRicavoTotale() {
        // Accediamo al prezzo unitario del prodotto venduto della classe Prodotto
        return prodottoVenduto.prezzoUnitario() * getQuantitaVenduta();
    }

    // Metodo per visualizzare i dettagli della transazione usando i getter e i record della classe Prodotto
    public void visualizzaDettagliTransazione() {
        System.out.println("ID Transazione: " + getIdTransazione());
        System.out.println("Prodotto: " + getProdottoVenduto().nome() + " (ID: " + getProdottoVenduto().idProdotto() + ")");
        System.out.println("Quantità: " + getQuantitaVenduta());
        System.out.println("Data: " + getDataVendita());
        System.out.println("Ricavo Totale: " + calcolaRicavoTotale() + " euro");
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

    @Override // Indica che stiamo sovrascrivendo il metodo della superclasse (Object
    public int hashCode() {
        // Genera un has basato sugli stessi attributi usati in equals()
        return Objects.hash(idTransazione);
    }

    @Override
    public String toString() {
        return "TransazioneVendita{" +
                "idTransazione='" + idTransazione + '\'' +
                ", prodottoVenduto=" + prodottoVenduto.nome() + // Ci serve solo il nome del prodotto, non l'oggetto completo
                ", quantitaVenduta=" + quantitaVenduta +
                ", dataVendita='" + dataVendita + '\'' +
                '}';

    }
}
