package com.example.esempiosearchbar.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Categoria extends RealmObject {

    @PrimaryKey
    private String Nome;

    private RealmList<Esercizio> Esercizi;

    //Costruttore
    public void Categoria(){}

    //Getters
    public String getNome() {
        return Nome;
    }

    public RealmList<Esercizio> getEsercizi() {
        return Esercizi;
    }
}
