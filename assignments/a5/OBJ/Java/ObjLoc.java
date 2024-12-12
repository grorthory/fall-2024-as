//ObjLoc:top//
//ObjLoc:import//
import java.util.*;

// <loc>:ObjLoc ::= LANGLE <exp> RANGLE
public class ObjLoc extends Loc /*ObjLoc:class*/ {

    public static final String $className = "ObjLoc";
    public static final String $ruleString =
        "<loc>:ObjLoc ::= LANGLE <exp> RANGLE";

    public Exp exp;

    public ObjLoc(Exp exp) {
//ObjLoc:init//
        this.exp = exp;
    }

    public static ObjLoc parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<loc>:ObjLoc", scn$.lno);
        scn$.match(Token.Match.LANGLE, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        scn$.match(Token.Match.RANGLE, trace$);
        return new ObjLoc(exp);
    }

    public Env getEnv(Env env) {
        Val v = exp.eval(env);
        return v.env();
    }

//ObjLoc//
}
