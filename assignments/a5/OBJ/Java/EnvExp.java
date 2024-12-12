//EnvExp:top//
//EnvExp:import//
import java.util.*;

// <exp>:EnvExp ::= LANGLE <exp>vExp RANGLE <exp>eExp
public class EnvExp extends Exp /*EnvExp:class*/ {

    public static final String $className = "EnvExp";
    public static final String $ruleString =
        "<exp>:EnvExp ::= LANGLE <exp>vExp RANGLE <exp>eExp";

    public Exp vExp;
    public Exp eExp;

    public EnvExp(Exp vExp, Exp eExp) {
//EnvExp:init//
        this.vExp = vExp;
        this.eExp = eExp;
    }

    public static EnvExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:EnvExp", scn$.lno);
        scn$.match(Token.Match.LANGLE, trace$);
        Exp vExp = Exp.parse(scn$, trace$);
        scn$.match(Token.Match.RANGLE, trace$);
        Exp eExp = Exp.parse(scn$, trace$);
        return new EnvExp(vExp, eExp);
    }

    public Val eval(Env env) {
        Val v = vExp.eval(env);
        return eExp.eval(v.env());
    }

//EnvExp//
}
