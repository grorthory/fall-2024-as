//ObjectpPrim:top//
//ObjectpPrim:import//
import java.util.*;

// <prim>:ObjectpPrim ::= OBJECTP
public class ObjectpPrim extends Prim /*ObjectpPrim:class*/ {

    public static final String $className = "ObjectpPrim";
    public static final String $ruleString =
        "<prim>:ObjectpPrim ::= OBJECTP";



    public ObjectpPrim() {
//ObjectpPrim:init//

    }

    public static ObjectpPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:ObjectpPrim", scn$.lno);
        scn$.match(Token.Match.OBJECTP, trace$);
        return new ObjectpPrim();
    }

    public Val apply(Val [] va) {
    	if (va.length != 1)
            throw new PLCCException("one argument expected");
        Val v0 = va[0];
        return new IntVal(v0.isObject() ? 1 : 0);
       }

//ObjectpPrim//
}
