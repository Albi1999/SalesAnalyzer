public interface ComparabilePerRicavo {
    // Metodo astratto: restituisce un valore numerico che rappresenta il "ricavo" dell'oggetto.
    // Questo permette di confrontare diversi tipi di oggetti in base al loro contributo monetario.
    double getValoreRicavo();

    // Metodo default:
    // fornisce un'implementazione di base per confrontare il ricavo tra due oggetti che implementano questa interfaccia.
    default void stampaConfrontoRicavo(ComparabilePerRicavo altroOggetto) {
        if (this.getValoreRicavo() > altroOggetto.getValoreRicavo()) {
            System.out.println("L'oggetto corrente ha un ricavo maggiore (" +
                    String.format("%.2f", this.getValoreRicavo()) + " vs " +
                    String.format("%.2f", altroOggetto.getValoreRicavo()) + ")");
        } else if (this.getValoreRicavo() < altroOggetto.getValoreRicavo()) {
            System.out.println("L'altro oggetto ha un ricavo maggiore (" +
                    String.format("%.2f", altroOggetto.getValoreRicavo()) + " vs " +
                    String.format("%.2f", this.getValoreRicavo()) + ")");
        } else {
            System.out.println("Gli oggetti hanno lo stesso ricavo (" +
                    String.format("%.2f", this.getValoreRicavo()) + ")");
        }
    }
}