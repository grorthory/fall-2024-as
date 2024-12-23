//DisplayExp:top//
//DisplayExp:import//
import java.util.*;

// <exp>:DisplayExp ::= DISPLAY <exp>
public class DisplayExp extends Exp /*DisplayExp:class*/ {

    public static final String $className = "DisplayExp";
    public static final String $ruleString =
        "<exp>:DisplayExp ::= DISPLAY <exp>";

    public Exp exp;

    public DisplayExp(Exp exp) {
//DisplayExp:init//
        this.exp = exp;
    }

    public static DisplayExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:DisplayExp", scn$.lno);
        scn$.match(Token.Match.DISPLAY, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new DisplayExp(exp);
    }

    public Val eval(Env env) {
        Val v = exp.eval(env);
        System.out.print(v);
        return v;
    }

//DisplayExp//
}
