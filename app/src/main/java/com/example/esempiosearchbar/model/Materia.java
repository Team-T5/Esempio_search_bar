package com.example.esempiosearchbar.model;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Materia extends RealmObject {

    @PrimaryKey
    private String Nome;

    private RealmList<Libro> Libri;
    private RealmList<Categoria> Categorie;

    //Costruttore
    public void Materia(){};

    //Getters
    public String getNome() {
        return Nome;
    }


    public RealmList<Libro> getLibri() {
        return Libri;
    }


    public RealmList<Categoria> getCategorie() {
        return Categorie;
    }


}
