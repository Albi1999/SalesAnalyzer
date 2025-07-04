package com.maggioli.salesanalyzer.model;
import com.maggioli.salesanalyzer.exceptions.CostoSpedizioneNonCalcolabileException; // Importa la nuova eccezione


public class ProdottoFisico extends Prodotto { // 'extends Prodotto' indica l'ereditarietà
    public double pesoKG;
    public double dimensioniCM; // Lunghezza, larghezza, altezza in cm e combinate

    // Costruttore specifico per la sottoclasse ProdottoFisico
    public ProdottoFisico(String idProdotto, String nome, String categoria, double prezzoUnitario, double pesoKG, double dimensioniCM) {
        super(idProdotto, nome, categoria, prezzoUnitario); // Chiama il costruttore della superclasse Prodotto per inizializzare gli attributi ereditati
        // È la prima istruzione obbligatoria in un costruttore di sottoclasse se la superclasse non ha un costruttore senza parametri.
        if (pesoKG < 0.0) {
            throw new IllegalArgumentException("Il peso non può essere negativo.");
        }
        if (dimensioniCM < 0.0) {
            throw new IllegalArgumentException("Le dimensioni non possono essere negative.");
        }
        this.pesoKG = pesoKG;
        this.dimensioniCM = dimensioniCM;
    }

    // Metodo specifico della sottoclasse
    public double calcolaCostoSpedizione() throws CostoSpedizioneNonCalcolabileException {
        if (pesoKG < 0 || dimensioniCM < 0) {
            // Se peso o dimensioni sono negativi, lanciamo la nostra eccezione controllata
            throw new CostoSpedizioneNonCalcolabileException("Impossibile calcolare costo spedizione per peso o dimensioni negativi.");
        }
        return 5.0 + (pesoKG * 0.5) + (dimensioniCM * 0.1);
    }

    @Override // Usiamo questa annotazione per indicare che stiamo sovrascrivendo un metodo della superclasse
    // in altri casi lo abbiamo utilizzato per metodi come equals() e hashCode()
    public void visualizzaDettagli() {
        // Chiamo il metodo della superclasse per riutilizzare il codice
        super.visualizzaDettagli();
        System.out.println("  - Tipo: Fisico");
        System.out.println("  - Peso: " + pesoKG + " kg");
        System.out.println("  - Dimensioni: " + dimensioniCM + " cm^3");
        try {
            System.out.println("  - Costo Spedizione Stimato: " + String.format("%.2f", calcolaCostoSpedizione()) + " euro");
        } catch (CostoSpedizioneNonCalcolabileException e) {
            // Catturiamo l'eccezione qui per poter comunque visualizzare gli altri dettagli
            System.out.println("  - Errore nel calcolo spedizione: " + e.getMessage());
        }
    }
}
