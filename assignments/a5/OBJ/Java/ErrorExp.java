//ErrorExp:top//
//ErrorExp:import//
import java.util.*;

// <exp>:ErrorExp ::= ERROR <exp>
public class ErrorExp extends Exp /*ErrorExp:class*/ {

    public static final String $className = "ErrorExp";
    public static final String $ruleString =
        "<exp>:ErrorExp ::= ERROR <exp>";

    public Exp exp;

    public ErrorExp(Exp exp) {
//ErrorExp:init//
        this.exp = exp;
    }

    public static ErrorExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ErrorExp", scn$.lno);
        scn$.match(Token.Match.ERROR, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new ErrorExp(exp);
    }

    public Val eval(Env env) {
        Val val = exp.eval(env);
        throw new PLCCException(val.toString());
    }

//ErrorExp//
}
