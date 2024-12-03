package ExpBool;

import java.util.HashMap;

/**
 *
 * @author loant
 */
public class ExpConstante extends ExpBooleenne{
    private boolean valeur;
    protected final static ExpConstante VRAI = new ExpConstante(true);        
    protected final static ExpConstante FAUX = new ExpConstante(false);

    public ExpConstante(boolean valeur) {
        this.valeur = valeur;
    }

    @Override
    public boolean evalue(ContexteEval c) throws VariableInconnueException{
        return valeur;
    }

    @Override
    public String toString() {
        if (valeur == true){
            return "vrai";
        }else{
            return "faux";
        }
    }

    @Override
    public ExpBooleenne transformeNonEt() {
        return this;
    }
   
    public boolean equals(Object o){
        if (o == this){
            return true;
        }else{
            if (o instanceof ExpConstante){
                ExpConstante p = (ExpConstante) o;
                return this.valeur == p.valeur;
            }else{
                return false;
            }
        }
    }

}
