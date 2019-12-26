package com.example.esempiosearchbar.model;


import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class Esercizio extends RealmObject {

    @PrimaryKey
    private String timestamp;

    private String codiceIdentificativo, Capitolo;
    private int numTentativi;
    private String tempoSvolgimento;
    private RealmList<Voto> Voti;
    private RealmList<String> Fotografie;

    //Costruttore
    public void Esercizio(){}

    //Getters
    public String getTimestamp() {
        return timestamp;
    }

    public String getCodiceIdentificativo() {
        return codiceIdentificativo;
    }

    public String getCapitolo() {
        return Capitolo;
    }

    public int getNumTentativi() {
        return numTentativi;
    }

    public String getTempoSvolgimento() {
        return tempoSvolgimento;
    }

    public RealmList<Voto> getVoti() {
        return Voti;
    }

    public RealmList<String> getFotografie() {
        return Fotografie;
    }

    //Setters
    public void setCodiceIdentificativo(String codiceIdentificativo) {
        this.codiceIdentificativo = codiceIdentificativo;
    }

    public void setCapitolo(String capitolo) {
        Capitolo = capitolo;
    }
}
