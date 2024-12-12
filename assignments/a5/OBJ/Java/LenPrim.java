//LenPrim:top//
//LenPrim:import//
import java.util.*;

// <prim>:LenPrim ::= LENOP
public class LenPrim extends Prim /*LenPrim:class*/ {

    public static final String $className = "LenPrim";
    public static final String $ruleString =
        "<prim>:LenPrim ::= LENOP";



    public LenPrim() {
//LenPrim:init//

    }

    public static LenPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:LenPrim", scn$.lno);
        scn$.match(Token.Match.LENOP, trace$);
        return new LenPrim();
    }

    public Val apply(Val [] va) {
        if (va.length != 1)
            throw new PLCCException("one argument expected");
        ListVal lst = va[0].listVal();
        return new IntVal(lst.len());
    }

//LenPrim//
}
