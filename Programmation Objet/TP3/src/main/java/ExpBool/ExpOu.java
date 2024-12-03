package ExpBool;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 *
 * @author loant
 */
public class ExpOu extends ExpBinaire{

    public ExpOu(ExpBooleenne fg, ExpBooleenne fd) {
        super(fg, fd);
    }

    @Override
    public String toString() {
        return super.toString() + this.fg + " ou " + this.fd + ")";
    }
    
    public boolean evalue(ContexteEval context) throws VariableInconnueException{
        return this.fg.evalue(context) || this.fd.evalue(context);
    }

    @Override
    public ExpBooleenne transformeNonEt() {
        return new ExpNegation(new ExpEt(new ExpNegation(this.fg.transformeNonEt()), new ExpNegation(this.fd.transformeNonEt())));
    }

    public boolean equals(Object o){
        if (o == this){
            return true;
        }else{
            if (o instanceof ExpOu){
                ExpOu exp = (ExpOu) o;
                return this.fd.equals(exp.fd) && this.fg.equals(exp.fg);
            }else{
                return false;
            }
        }
    }
    
}
