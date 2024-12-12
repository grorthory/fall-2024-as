//NilExp:top//
//NilExp:import//
import java.util.*;

// <exp>:NilExp ::= NIL
public class NilExp extends Exp /*NilExp:class*/ {

    public static final String $className = "NilExp";
    public static final String $ruleString =
        "<exp>:NilExp ::= NIL";



    public NilExp() {
//NilExp:init//

    }

    public static NilExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:NilExp", scn$.lno);
        scn$.match(Token.Match.NIL, trace$);
        return new NilExp();
    }

    public Val eval(Env env) {
        return Val.nil;
    }

//NilExp//
}
