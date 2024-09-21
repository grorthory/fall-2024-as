//ParensNode:top//
//ParensNode:import//
import java.util.*;

// <parens>ParensNode ::= LP <parens> RP
public class ParensNode extends Parens /*ParensNode:class*/ {

    public static final String $className = "ParensNode";
    public static final String $ruleString =
        "<parens>ParensNode ::= LP <parens> RP";

    public Parens parens;

    public ParensNode(Parens parens) {
//ParensNode:init//
        this.parens = parens;
    }

    public static ParensNode parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<parens>ParensNode", scn$.lno);
        scn$.match(Token.Match.LP, trace$);
        Parens parens = Parens.parse(scn$, trace$);
        scn$.match(Token.Match.RP, trace$);
        return new ParensNode(parens);
    }

//ParensNode//
}
