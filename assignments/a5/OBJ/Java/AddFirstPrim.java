//AddFirstPrim:top//
//AddFirstPrim:import//
import java.util.*;

// <prim>:AddFirstPrim ::= ADDFIRSTOP
public class AddFirstPrim extends Prim /*AddFirstPrim:class*/ {

    public static final String $className = "AddFirstPrim";
    public static final String $ruleString =
        "<prim>:AddFirstPrim ::= ADDFIRSTOP";



    public AddFirstPrim() {
//AddFirstPrim:init//

    }

    public static AddFirstPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:AddFirstPrim", scn$.lno);
        scn$.match(Token.Match.ADDFIRSTOP, trace$);
        return new AddFirstPrim();
    }

    public Val apply(Val [] va) {
        if (va.length != 2)
            throw new PLCCException("two arguments expected");
        Val v = va[0];
        ListVal lst = va[1].listVal();
        return new ListNode(v, lst);
    }

//AddFirstPrim//
}
