package ExpBool;

/**
 *
 * @author loant
 */
public class ExpEt extends ExpBinaire{

    public ExpEt(ExpBooleenne fg, ExpBooleenne fd) {
        super(fg, fd);
    }
    
    @Override
    public String toString() {
        return super.toString() + this.fg + " et " + this.fd + ")";
    }
    
    public boolean evalue(ContexteEval context) throws VariableInconnueException{
        return this.fg.evalue(context) && this.fd.evalue(context);
    }

    @Override
    public ExpBooleenne transformeNonEt() {
        return new ExpEt(this.fg.transformeNonEt(), this.fd.transformeNonEt());
    }

    public boolean equals(Object o){
        if (o == this){
            return true;
        }else{
            if (o instanceof ExpEt){
                ExpEt exp = (ExpEt) o;
                return this.fd.equals(exp.fd) && this.fg.equals(exp.fg);
            }else{
                return false;
            }
        }
    }

}
