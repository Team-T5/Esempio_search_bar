package com.example.esempiosearchbar.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Libro extends RealmObject {

    @PrimaryKey
    private String ISBN;

    private String Nome, Autore, Versione;
    private RealmList<Esercizio> Esercizi;

    //Costruttore
    public void Libro(){}

    //Getters
    public String getISBN() {
        return ISBN;
    }

    public String getNome() {
        return Nome;
    }

    public String getAutore() {
        return Autore;
    }

    public String getVersione() {
        return Versione;
    }

    public RealmList<Esercizio> getEsercizi() {
        return Esercizi;
    }

    //Setters
    public void setNome(String nome) {
        Nome = nome;
    }

    public void setAutore(String autore) {
        Autore = autore;
    }

    public void setVersione(String versione) {
        Versione = versione;
    }
}
