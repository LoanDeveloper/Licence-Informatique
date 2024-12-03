/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author loant
 */
public class Complexe {
    private Double reel;
    private Double img;

    public Complexe(Double reel, Double img) {
        this.reel = reel;
        this.img = img;
    }
    
    public Complexe() {
        this.reel = 0.0;
        this.img = 0.0;
    }

    public Double getReel() {
        return reel;
    }

    public void setReel(Double reel) {
        this.reel = reel;
    }

    public Double getImg() {
        return img;
    }

    public void setImg(Double img) {
        this.img = img;
    }
    
    public Complexe addition(Complexe c){
        return new Complexe(c.getReel() + this.getReel(), c.getImg() + this.getImg());
    }
    
    public static Complexe addition(Complexe c1, Complexe c2){
        return new Complexe(c1.getReel() + c2.getReel(), c1.getImg() + c2.getImg());
    }
    
    public Complexe multiplication(double d){
        return new Complexe(this.getReel() * d, this.getImg() * d);
    }
    
    public Complexe multiplication(Complexe c){
        double reel = (this.reel * c.getReel()) - (this.img * c.getImg());
        double img = (this.reel * c.img) + (this.img * c.reel);
        return new Complexe(reel, img);
    }
}
