//Ext1:top//
//Ext1:import//
import java.util.*;

// <ext>:Ext1 ::= EXTENDS <exp>
public class Ext1 extends Ext /*Ext1:class*/ {

    public static final String $className = "Ext1";
    public static final String $ruleString =
        "<ext>:Ext1 ::= EXTENDS <exp>";

    public Exp exp;

    public Ext1(Exp exp) {
//Ext1:init//
        this.exp = exp;
    }

    public static Ext1 parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<ext>:Ext1", scn$.lno);
        scn$.match(Token.Match.EXTENDS, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new Ext1(exp);
    }

    public ClassVal toClassVal(Env env) {
        Val v = exp.eval(env);
        return v.classVal();
    }

//Ext1//
}
