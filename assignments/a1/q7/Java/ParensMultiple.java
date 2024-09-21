//ParensMultiple:top//
//ParensMultiple:import//
import java.util.*;

// <parens>ParensMultiple ::= LP <parens>nested RP <parens>outside
public class ParensMultiple extends Parens /*ParensMultiple:class*/ {

    public static final String $className = "ParensMultiple";
    public static final String $ruleString =
        "<parens>ParensMultiple ::= LP <parens>nested RP <parens>outside";

    public Parens nested;
    public Parens outside;

    public ParensMultiple(Parens nested, Parens outside) {
//ParensMultiple:init//
        this.nested = nested;
        this.outside = outside;
    }

    public static ParensMultiple parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<parens>ParensMultiple", scn$.lno);
        scn$.match(Token.Match.LP, trace$);
        Parens nested = Parens.parse(scn$, trace$);
        scn$.match(Token.Match.RP, trace$);
        Parens outside = Parens.parse(scn$, trace$);
        return new ParensMultiple(nested, outside);
    }

//ParensMultiple//
}
