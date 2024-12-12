//ExitExp:top//
//ExitExp:import//
import java.util.*;

// <exp>:ExitExp ::= EXIT
public class ExitExp extends Exp /*ExitExp:class*/ {

    public static final String $className = "ExitExp";
    public static final String $ruleString =
        "<exp>:ExitExp ::= EXIT";



    public ExitExp() {
//ExitExp:init//

    }

    public static ExitExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ExitExp", scn$.lno);
        scn$.match(Token.Match.EXIT, trace$);
        return new ExitExp();
    }

    public Val eval(Env env) {
        throw new PLCCException("...exiting...");
    }

//ExitExp//
}
