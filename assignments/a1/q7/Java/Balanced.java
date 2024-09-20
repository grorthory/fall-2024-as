//Balanced:top//
//Balanced:import//
import java.util.*;

// <balanced> ::= <parens> AT
public class Balanced extends _Start /*Balanced:class*/ {

    public static final String $className = "Balanced";
    public static final String $ruleString =
        "<balanced> ::= <parens> AT";

    public Parens parens;

    public Balanced(Parens parens) {
//Balanced:init//
        this.parens = parens;
    }

    public static Balanced parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<balanced>", scn$.lno);
        Parens parens = Parens.parse(scn$, trace$);
        scn$.match(Token.Match.AT, trace$);
        return new Balanced(parens);
    }

//Balanced//
}
