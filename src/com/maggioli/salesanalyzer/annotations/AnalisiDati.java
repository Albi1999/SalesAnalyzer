package com.maggioli.salesanalyzer.annotations;

import java.lang.annotation.ElementType; // Per specificare dove può essere usata l'annotazione
import java.lang.annotation.Retention;   // Per specificare quando l'annotazione è disponibile
import java.lang.annotation.RetentionPolicy; // Valori per Retention
import java.lang.annotation.Target;  // Per specificare il tipo di elemento a cui può essere applicata l'annotazione

// @Retention(RetentionPolicy.RUNTIME) significa che l'annotazione sarà disponibile a runtime via reflection
// @Target(ElementType.METHOD) significa che questa annotazione può essere applicata solo a metodi
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AnalisiDati {
    // Elementi dell'annotazione (simili ad attributi)
    String descrizione() default "Nessuna descrizione fornita"; // Un elemento con un valore di default
    String autore() default "Sconosciuto"; // Un altro elemento
}