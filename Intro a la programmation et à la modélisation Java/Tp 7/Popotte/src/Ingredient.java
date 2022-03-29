import java.util.Objects;

public class Ingredient {
    //attributs

    private String nom;
    private long calories;
    private double glucide;
    private double lipide;
    private double proteine;

    //constructeur
    public Ingredient(String nom, double glucide, double proteine, double lipide, long calories) {
        this.nom = nom;
        this.glucide = glucide;
        this.proteine = proteine;
        this.lipide = lipide;
        this.calories = calories;
    }

    //getters
    public String getNom() {
        return nom;
    }

    public long getCalories() {
        return calories;
    }

    public double getGlucide() {
        return glucide;
    }

    public double getLipide() {
        return lipide;
    }

    public double getProteine() {
        return proteine;
    }

    //toString


    @Override
    public String toString() {
        return "Ingredient{" +
                "nom=" + nom +
                ", glucide=" + glucide +
                ", proteine=" + proteine +
                ", lipide=" + lipide +
                ", calories=" + calories +
                '}';
    }

    //equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ingredient that = (Ingredient) o;
        return Objects.equals(nom, that.nom);
    }
}
