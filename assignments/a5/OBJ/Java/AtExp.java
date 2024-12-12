//AtExp:top//
//AtExp:import//
import java.util.*;

// <exp>:AtExp ::= AT
public class AtExp extends Exp /*AtExp:class*/ {

    public static final String $className = "AtExp";
    public static final String $ruleString =
        "<exp>:AtExp ::= AT";



    public AtExp() {
//AtExp:init//

    }

    public static AtExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:AtExp", scn$.lno);
        scn$.match(Token.Match.AT, trace$);
        return new AtExp();
    }

    public Val eval(Env env) {
        return new ObjectVal(env);
    }

//AtExp//
}
