package ExpBool;

import java.util.HashMap;

/**
 *
 * @author loant
 */
public abstract class ExpBinaire extends ExpBooleenne {
    protected ExpBooleenne fg;
    protected ExpBooleenne fd;

    public ExpBinaire(ExpBooleenne fg, ExpBooleenne fd) {
        this.fg = fg;
        this.fd = fd;
    }

    @Override
    public String toString() {
        return "(";
    }
    
    
}
