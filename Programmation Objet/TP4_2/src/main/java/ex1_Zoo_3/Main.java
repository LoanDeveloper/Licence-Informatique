package ex1_Zoo_3;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MammifereAquatique ma = new MammifereAquatique("baleine", true, false);
        MammifereTerrestre mt = new MammifereTerrestre("Cheval", false, "plaine");
        ReptileAquatique ra = new ReptileAquatique("Vipere", true, true);
        ReptileTerrestre rt = new ReptileTerrestre("gekko",false ,"arbre" );

        ArrayList<Animals> animaux = new ArrayList<>();
        animaux.add(ma);
        animaux.add(mt);
        animaux.add(ra);
        animaux.add(rt);

        int reptile = 0;
        int terrestre = 0;
        for(Animals a : animaux ){
            if(a instanceof Reptile){
                reptile++;
            }
            if(a instanceof MammifereTerrestre || a instanceof ReptileTerrestre){
                terrestre++;
            }
        }
        System.out.println(reptile + " " + terrestre);
    }
}
