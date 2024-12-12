//FirstPrim:top//
//FirstPrim:import//
import java.util.*;

// <prim>:FirstPrim ::= FIRSTOP
public class FirstPrim extends Prim /*FirstPrim:class*/ {

    public static final String $className = "FirstPrim";
    public static final String $ruleString =
        "<prim>:FirstPrim ::= FIRSTOP";



    public FirstPrim() {
//FirstPrim:init//

    }

    public static FirstPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:FirstPrim", scn$.lno);
        scn$.match(Token.Match.FIRSTOP, trace$);
        return new FirstPrim();
    }

    public Val apply(Val [] va) {
        if (va.length != 1)
            throw new PLCCException("one argument expected");
        ListNode lst = va[0].listNode();
        return lst.val;
    }

//FirstPrim//
}
