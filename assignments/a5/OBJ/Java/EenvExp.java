//EenvExp:top//
//EenvExp:import//
import java.util.*;

// <exp>:EenvExp ::= LLANGLE <exp> <mangle> RRANGLE
public class EenvExp extends Exp /*EenvExp:class*/ {

    public static final String $className = "EenvExp";
    public static final String $ruleString =
        "<exp>:EenvExp ::= LLANGLE <exp> <mangle> RRANGLE";

    public Exp exp;
    public Mangle mangle;

    public EenvExp(Exp exp, Mangle mangle) {
//EenvExp:init//
        this.exp = exp;
        this.mangle = mangle;
    }

    public static EenvExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:EenvExp", scn$.lno);
        scn$.match(Token.Match.LLANGLE, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        Mangle mangle = Mangle.parse(scn$, trace$);
        scn$.match(Token.Match.RRANGLE, trace$);
        return new EenvExp(exp, mangle);
    }

    public Val eval(Env env) {
        Val v = exp.eval(env);      // the environment object
        return mangle.eval(v, env);
    }

//EenvExp//
}
