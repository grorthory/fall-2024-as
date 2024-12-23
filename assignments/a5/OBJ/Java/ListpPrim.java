//ListpPrim:top//
//ListpPrim:import//
import java.util.*;

// <prim>:ListpPrim ::= LISTP
public class ListpPrim extends Prim /*ListpPrim:class*/ {

    public static final String $className = "ListpPrim";
    public static final String $ruleString =
        "<prim>:ListpPrim ::= LISTP";



    public ListpPrim() {
//ListpPrim:init//

    }

    public static ListpPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:ListpPrim", scn$.lno);
        scn$.match(Token.Match.LISTP, trace$);
        return new ListpPrim();
    }

    public Val apply(Val [] va) {
    	if (va.length != 1)
    	throw new PLCCException("one argument expected");
        Val v0 = va[0];
    	return new IntVal(v0.isList() ? 1 : 0);
    }

//ListpPrim//
}
