//AtAtExp:top//
//AtAtExp:import//
import java.util.*;

// <exp>:AtAtExp ::= ATAT
public class AtAtExp extends Exp /*AtAtExp:class*/ {

    public static final String $className = "AtAtExp";
    public static final String $ruleString =
        "<exp>:AtAtExp ::= ATAT";



    public AtAtExp() {
//AtAtExp:init//

    }

    public static AtAtExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:AtAtExp", scn$.lno);
        scn$.match(Token.Match.ATAT, trace$);
        return new AtAtExp();
    }

    public Val eval(Env env) {
        System.out.println(env.toString());
        return new ObjectVal(env);
    }

//AtAtExp//
}
