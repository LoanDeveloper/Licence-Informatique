public abstract class Rectangle extends Figure{  
    private double largeur;
    private double longueur;

    public Rectangle(double largeur, double longueur, double x, double y) {
        super(x, y);
        this.largeur = largeur;
        this.longueur = longueur;
    }
    
    public double donneSurface(){ return this.largeur * this.longueur; }
    public double donneLongueur(){ return this.longueur;}
    public double donneLargueur(){ return this.largeur;}
    public void changeLargeur(double l){ this.largeur = l;}
    public void changeLongueur(double l){ this.longueur = l;}
          
}
