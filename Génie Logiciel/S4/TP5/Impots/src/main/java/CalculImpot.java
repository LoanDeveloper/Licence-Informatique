/**
 *
 * @author loant
 */
public class CalculImpot {
    
    public int calcul(int revenu_net_global, double nbParts) throws Exception{
        double revenu_net_imposable = revenu_net_global * 0.9;
        double quotient_familial = revenu_net_imposable / nbParts;
        double tranches;
        
        if(nbParts > 15 || nbParts < 1){
            throw new Exception("Erreur parts");
        }else if(revenu_net_global < 0){
            throw new Exception("Erreur revenu < 0");
        }else if(quotient_familial >= 168994){
            tranches = ((27478 - 10778) * 0.11) + ((78570 - 27479) * 0.3) + ((168994 - 78570) * 0.41) + ((quotient_familial - 168994) * 0.45);
        }else if(quotient_familial >= 78570 && quotient_familial < 168994){
            tranches = ((27478 - 10778) * 0.11) + ((78570 - 27479) * 0.3) + ((quotient_familial - 78570) * 0.41);
        }else if(quotient_familial >= 27478 && quotient_familial < 78570){
            tranches = ((27478 - 10778) * 0.11) + ((quotient_familial - 27479) * 0.3);
        }else if(quotient_familial >= 10778 && quotient_familial < 27478){
            tranches = ((quotient_familial - 10778) * 0.11);
        }else{
            tranches = 0;
        }
        return (int)(tranches * nbParts);
    }
}
