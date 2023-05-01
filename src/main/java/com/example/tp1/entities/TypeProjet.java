package com.example.tp1.entities;

public enum TypeProjet {
    A("Analyse"),
    C("Conception"),
    D("Développement"),
    E("Evénement");

    private final String label;

    private TypeProjet(String label) {
        this.label = label;
    }

    public String toString() {
        return this.label;
    }
}
