package ExpBool;

import java.util.HashMap;

/**
 *
 * @author loant
 */
public class VarBool extends ExpBooleenne{
    private char nom;

    public VarBool(char nom) {
        this.nom = nom;
    }

    @Override
    public boolean evalue(ContexteEval context) throws VariableInconnueException{
        if (context.getHashmap().get(this.nom) != null){
            return context.getHashmap().get(this.nom);
        }throw new VariableInconnueException();
    }

    @Override
    public String toString() {
        return nom + "";
    }

    @Override
    public ExpBooleenne transformeNonEt() {
        return this;
    }

    public boolean equals(Object o){
        if (o == this){
            return true;
        }else{
            if (o instanceof VarBool){
                VarBool exp = (VarBool) o;
                return this.nom == exp.nom;
            }else{
                return false;
            }
        }
    }
    
}
