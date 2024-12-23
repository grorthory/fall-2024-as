//Display1Exp:top//
//Display1Exp:import//
import java.util.*;

// <exp>:Display1Exp ::= DISPLAY1 <exp>
public class Display1Exp extends Exp /*Display1Exp:class*/ {

    public static final String $className = "Display1Exp";
    public static final String $ruleString =
        "<exp>:Display1Exp ::= DISPLAY1 <exp>";

    public Exp exp;

    public Display1Exp(Exp exp) {
//Display1Exp:init//
        this.exp = exp;
    }

    public static Display1Exp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:Display1Exp", scn$.lno);
        scn$.match(Token.Match.DISPLAY1, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new Display1Exp(exp);
    }

    public Val eval(Env env) {
        Val v = exp.eval(env);
        System.out.print(v+" ");
        return v;
    }

//Display1Exp//
}
