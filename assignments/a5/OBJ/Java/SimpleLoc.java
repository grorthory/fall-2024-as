//SimpleLoc:top//
//SimpleLoc:import//
import java.util.*;

// <loc>:SimpleLoc ::= 
public class SimpleLoc extends Loc /*SimpleLoc:class*/ {

    public static final String $className = "SimpleLoc";
    public static final String $ruleString =
        "<loc>:SimpleLoc ::= ";



    public SimpleLoc() {
//SimpleLoc:init//

    }

    public static SimpleLoc parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<loc>:SimpleLoc", scn$.lno);
        return new SimpleLoc();
    }

    public Env getEnv(Env env) {
        return env;
    }

//SimpleLoc//
}
