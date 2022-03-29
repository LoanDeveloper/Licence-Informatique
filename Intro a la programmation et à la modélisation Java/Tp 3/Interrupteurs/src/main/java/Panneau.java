import java.util.Random;

public class Panneau {
    private boolean lumiere1;
    private boolean lumiere2;
    private boolean lumiere3;
    private boolean lumiere4;
    private boolean lumiere5;
    
    public Panneau(){
        Random rd = new Random();
        this.lumiere1 = rd.nextBoolean();
        this.lumiere2 = rd.nextBoolean();
        this.lumiere3 = rd.nextBoolean();
        this.lumiere4 = rd.nextBoolean();
        this.lumiere5 = rd.nextBoolean();
        
    }
    public String toString(){
        String s = "[";
        if (this.lumiere1){s += "X";}else{s += "O";}
        if (this.lumiere2){s += "X";}else{s += "O";}
        if (this.lumiere3){s += "X";}else{s += "O";}
        if (this.lumiere4){s += "X";}else{s += "O";}
        if (this.lumiere5){s += "X]";}else{s += "O]";}
        return s;
    }
    
    public void interrupteur1(){
        if(this.lumiere2){this.lumiere2 = false;}else{this.lumiere2 = true;}
    }
    public void interrupteur2(){
        if(this.lumiere2){this.lumiere2 = false;}else{this.lumiere2 = true;}
        if(this.lumiere3){this.lumiere3 = false;}else{this.lumiere3 = true;}

    }
    public void interrupteur3(){
        if(this.lumiere3){this.lumiere3 = false;}else{this.lumiere3 = true;}
        if(this.lumiere4){this.lumiere4 = false;}else{this.lumiere4 = true;}
    }
    public void interrupteur4(){
        if(this.lumiere4){this.lumiere4 = false;}else{this.lumiere4 = true;}
        if(this.lumiere5){this.lumiere5 = false;}else{this.lumiere5 = true;}
    }
    public void interrupteur5(){
        if(this.lumiere1){this.lumiere1 = false;}else{this.lumiere1 = true;}
        if(this.lumiere5){this.lumiere5 = false;}else{this.lumiere5 = true;}
    }
    
    public boolean allumes(){
        if (this.lumiere1 && this.lumiere2 && this.lumiere3 && this.lumiere4 && this.lumiere5){
            return true;
        }else{
            return false;
        }
    }
    
    public void reset(){
        this.lumiere1 = false;
        this.lumiere2 = false;
        this.lumiere3 = false;
        this.lumiere4 = false;
        this.lumiere5 = false;
    }
}
