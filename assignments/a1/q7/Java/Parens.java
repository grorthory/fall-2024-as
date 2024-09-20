//Parens:top//
//Parens:import//
import java.util.*;

// <parens> ::= LP RP
public class Parens /*Parens:class*/ {

    public static final String $className = "Parens";
    public static final String $ruleString =
        "<parens> ::= LP RP";



    public Parens() {
//Parens:init//

    }

    public static Parens parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<parens>", scn$.lno);
        scn$.match(Token.Match.LP, trace$);
        scn$.match(Token.Match.RP, trace$);
        return new Parens();
    }

//Parens//
}
