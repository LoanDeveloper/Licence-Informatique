package ExpBool;

import java.util.HashMap;

/**
 *
 * @author loant
 */
public abstract class ExpBooleenne {
    
    public abstract boolean evalue(ContexteEval c) throws VariableInconnueException;
        
    public abstract ExpBooleenne transformeNonEt();
    
    public boolean equals(Object o){
        if (o == this){
            return true;
        }else{
            return false;
        }
    }
}
