package ExpBool;

import java.util.HashMap;

/**
 *
 * @author loant
 */
public class ExpNegation extends ExpBooleenne{
    private ExpBooleenne fils;

    public ExpNegation(ExpBooleenne fils) {
        this.fils = fils;
    }

    @Override
    public boolean evalue(ContexteEval c) throws VariableInconnueException{
        return !this.fils.evalue(c);
    }

    @Override
    public String toString() {
        return " non " + this.fils;
    } 

    @Override
    public ExpBooleenne transformeNonEt() {
        return new ExpNegation(this.fils.transformeNonEt());
    }
    
    public boolean equals(Object o){
        if (o == this){
            return true;
        }else{
            if (o instanceof ExpNegation){
                ExpNegation exp = (ExpNegation) o;
                return this.fils.equals(exp.fils);
            }else{
                return false;
            }
        }
    }
}
