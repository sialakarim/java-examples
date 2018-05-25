package org.supcom.javase.models;

public enum Continent {

    Asia("Asia"),Europe("Europe"),NorthAmerica("North America"),Africa("Africa"),Oceania("Oceania"),Antarctica("Antarctica"),SouthAmerica("South America");
    private final String name;

     Continent(String name){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}
