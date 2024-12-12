//BangAtExp:top//
//BangAtExp:import//
import java.util.*;

// <exp>:BangAtExp ::= BANGAT
public class BangAtExp extends Exp /*BangAtExp:class*/ {

    public static final String $className = "BangAtExp";
    public static final String $ruleString =
        "<exp>:BangAtExp ::= BANGAT";



    public BangAtExp() {
//BangAtExp:init//

    }

    public static BangAtExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:BangAtExp", scn$.lno);
        scn$.match(Token.Match.BANGAT, trace$);
        return new BangAtExp();
    }

    public Val eval(Env env) {
        return env.applyEnv("!@");
    }

//BangAtExp//
}
