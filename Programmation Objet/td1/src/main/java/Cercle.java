public class Cercle extends Figure{
    private double rayon;
    
    public Cercle(double x, double y, double r){
        super(x, y);
        this.rayon = r;
    }
    
    public void affiche(){
        System.out.println("centre = (" + this.x + ", " + this.y + ")");
    }
   
    public double donneX(){ return this.x;}
    public double donneY(){ return this.y;}
    
    public void changeCentre(double x, double y){
        this.x = x;
        this.y = y;
    }
    
    public double donneSurface(){ return Math.PI * this.rayon * this.rayon;}
    public boolean estInferieur(double x, double y){
        return (((x - this.x) * (x - this.x) + (y - this.y) * (y - this.y)) <= this.rayon * this.rayon);
    }
    
    public double donneRayon(){ return this.rayon;}
    public void changeRayon(double r){
        if (r < 0.0){
            r = 0.0;
        }
        this.rayon = r;
    }
}
