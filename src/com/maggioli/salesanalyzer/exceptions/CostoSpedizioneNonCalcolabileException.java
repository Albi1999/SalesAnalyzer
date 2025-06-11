package com.maggioli.salesanalyzer.exceptions;

// Estende Exception, quindi è una checked exception
public class CostoSpedizioneNonCalcolabileException extends Exception {
    public CostoSpedizioneNonCalcolabileException(String message) {
        super(message); // Chiama il costruttore della superclasse Exception
    }

    public CostoSpedizioneNonCalcolabileException(String message, Throwable cause) {
        super(message, cause); // Permette di incapsulare l'eccezione originale
    }
}