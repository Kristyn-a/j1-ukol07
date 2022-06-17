package cz.czechitas.ukol7.model;

public enum Barva {
    Bila ("bílá"),
    Zluta ("žlutá"),
    Oranzova ("oranžová"),
    Cervena ("červená"),
    Modra ("modrá"),
    Cerna ("černá");

    private final String barva;
    Barva (String barva){
        this.barva = barva;
    }
    public String getBarva(){
        return barva;
    }
}
