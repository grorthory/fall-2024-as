//SetExp:top//
//SetExp:import//
import java.util.*;

// <exp>:SetExp ::= SET <loc> <VAR> EQUALS <exp>
public class SetExp extends Exp /*SetExp:class*/ {

    public static final String $className = "SetExp";
    public static final String $ruleString =
        "<exp>:SetExp ::= SET <loc> <VAR> EQUALS <exp>";

    public Loc loc;
    public Token var;
    public Exp exp;

    public SetExp(Loc loc, Token var, Exp exp) {
//SetExp:init//
        this.loc = loc;
        this.var = var;
        this.exp = exp;
    }

    public static SetExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:SetExp", scn$.lno);
        scn$.match(Token.Match.SET, trace$);
        Loc loc = Loc.parse(scn$, trace$);
        Token var = scn$.match(Token.Match.VAR, trace$);
        scn$.match(Token.Match.EQUALS, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new SetExp(loc, var, exp);
    }

    public Val eval(Env env) {
        // return loc.getEnv(env).applyEnvRef(var).setRef(exp.eval(env));
        Env nenv = loc.getEnv(env);
        Ref ref = nenv.applyEnvRef(var);
        Val v = exp.eval(env);
        return ref.setRef(v);
    }

//SetExp//
}
