/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loant
 */
public class ObjetBougeant {
    
    /**
     * Nom de l'objet
     */
    private String nom;
    
    /**
     * Coordonnée X de l'objet
     */
    private Integer x;
    
    /**
     * Coordonnée Y de l'objet
     */
    private Integer y;
    
    /**
     * Rayon de l'objet
     */
    private Double r;
    
    /**
     * Constante DELTA_R est égale à 5.0 pour tous
     */
    private Double DELTA_R = 5.0;
    
    /*Accesseurs*/

    /**
     *
     * @return
     */

    public String getnom(){
        return nom;
    }

    /**
     *
     * @return
     */
    public int getX(){
        return x;
    }

    /**
     *
     * @return
     */
    public int getY(){
        return y;
    }

    /**
     *
     * @return
     */
    public Double getR(){
        return r;
    }
    
    /*Mutateurs*/

    /**
     *
     * @param nom
     */

    public void setNom(String nom){
        this.nom = nom;
    }

    /**
     *
     * @param x
     */
    public void setX(int x){
        this.x = x;
    }

    /**
     *
     * @param y
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     *
     * @param r
     */
    public void setR(Double r){
        this.r = r;
    }
    
    /**
     *
     * @param dx
     * @param dy
     */
    public void deplace(Integer dx, Integer dy){
        this.x = x+dx;
        this.y = y+dy;
    }
    
    /**
     *
     * @return
     */
    public Boolean estPoint(){
        if (this.r.equals(0.0)){
            return true;
        }else{
            return false;
        }
    }
    
    /**
     *
     */
    public void grossir(){
        this.DELTA_R +=1;
    }

    /**
     *
     */
    public void retrecir(){
        this.DELTA_R -=1;
    }

    /**
     *
     * @param delta
     */
    public void grossir(Double delta){
        this.DELTA_R += delta;
    }

    /**
     *
     * @param delta
     */
    public void retrecir(Double delta){
        this.DELTA_R -= delta;
    }
    private Boolean collision(ObjetBougeant that){
        Double d = Math.sqrt(Math.pow(that.x - this.x,2)+Math.pow(that.y - this.y,2));
        return d < (this.r+that.r);
    }

    /**
     *
     * @param that
     */
    public void absorde(ObjetBougeant that){
        if (this.collision(that)){
            this.r = this.r+that.r;
            that.r = 0.0;
        }
    }
    public void estAbsorbe(ObjetBougeant that){
        if (that.collision(this)){
            that.r = that.r+this.r;
            this.r = 0.0;
        }
    }
    
    public ObjetBougeant pond(){
        ObjetBougeant o = new ObjetBougeant();
        o.setR(this.r/2);
        o.setX(this.x+10);
        o.setY(this.y+10);
        return o;
    }
    public ObjetBougeant pond(ObjetBougeant that){
        ObjetBougeant op = new ObjetBougeant();
        op.setR(this.r+that.r);
        op.setX(this.x+that.x);
        op.setY(this.y+that.y);
        return op;
    }
    
    public String toString() {
        return "ObjetBougeant{" + "nom=" + nom + ", x=" + x + ", y=" + y + ", r=" + r + ", DELTA_R=" + DELTA_R + '}';
    }
    
    
}
