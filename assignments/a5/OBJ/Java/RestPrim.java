//RestPrim:top//
//RestPrim:import//
import java.util.*;

// <prim>:RestPrim ::= RESTOP
public class RestPrim extends Prim /*RestPrim:class*/ {

    public static final String $className = "RestPrim";
    public static final String $ruleString =
        "<prim>:RestPrim ::= RESTOP";



    public RestPrim() {
//RestPrim:init//

    }

    public static RestPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:RestPrim", scn$.lno);
        scn$.match(Token.Match.RESTOP, trace$);
        return new RestPrim();
    }

    public Val apply(Val [] va) {
        if (va.length != 1)
            throw new PLCCException("one argument expected");
        ListNode lst = va[0].listNode();
        return lst.listVal;
    }

//RestPrim//
}
