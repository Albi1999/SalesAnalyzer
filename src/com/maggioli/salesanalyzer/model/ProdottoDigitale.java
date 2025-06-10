package com.maggioli.salesanalyzer.model;

public class ProdottoDigitale extends Prodotto {
    public String formatoFile;
    public double dimensioneMB;

    public ProdottoDigitale(String idProdotto, String nome, String categoria, double prezzoUnitario, String formatoFile, double dimensioneMB) {
        super(idProdotto, nome, categoria, prezzoUnitario); // Chiama il costruttore della superclasse com.maggioli.salesanalyzer.model.Prodotto per inizializzare gli attributi ereditati
        this.formatoFile = formatoFile;
        this.dimensioneMB = dimensioneMB;
    }

    // Metodo specifico per com.maggioli.salesanalyzer.model.ProdottoDigitale
    public double calcolaCostoDownload() {
        return 0.1 + (dimensioneMB * 0.001);
    }

    @Override
    public void visualizzaDettagli() {
        super.visualizzaDettagli();
        System.out.println("  - Tipo: Digitale");
        System.out.println("  - Formato File: " + formatoFile);
        System.out.println("  - Dimensione: " + dimensioneMB + " MB");
        System.out.println("  - Costo Download Stimato: " + String.format("%.2f", calcolaCostoDownload()) + " euro");
    }
}