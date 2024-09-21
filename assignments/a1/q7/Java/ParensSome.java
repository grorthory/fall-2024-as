//ParensSome:top//
//ParensSome:import//
import java.util.*;

// <parens>ParensSome ::= LP <parens> RP
public class ParensSome extends Parens /*ParensSome:class*/ {

    public static final String $className = "ParensSome";
    public static final String $ruleString =
        "<parens>ParensSome ::= LP <parens> RP";

    public Parens parens;

    public ParensSome(Parens parens) {
//ParensSome:init//
        this.parens = parens;
    }

    public static ParensSome parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<parens>ParensSome", scn$.lno);
        scn$.match(Token.Match.LP, trace$);
        Parens parens = Parens.parse(scn$, trace$);
        scn$.match(Token.Match.RP, trace$);
        return new ParensSome(parens);
    }

//ParensSome//
}
