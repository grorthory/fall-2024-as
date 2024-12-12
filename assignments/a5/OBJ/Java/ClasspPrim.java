//ClasspPrim:top//
//ClasspPrim:import//
import java.util.*;

// <prim>:ClasspPrim ::= CLASSP
public class ClasspPrim extends Prim /*ClasspPrim:class*/ {

    public static final String $className = "ClasspPrim";
    public static final String $ruleString =
        "<prim>:ClasspPrim ::= CLASSP";



    public ClasspPrim() {
//ClasspPrim:init//

    }

    public static ClasspPrim parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<prim>:ClasspPrim", scn$.lno);
        scn$.match(Token.Match.CLASSP, trace$);
        return new ClasspPrim();
    }

    public Val apply(Val [] va) {
    	if (va.length != 1)
            throw new PLCCException("one argument expected");
        Val v0 = va[0];
        return new IntVal(v0.isClass() ? 1 : 0);
       }

//ClasspPrim//
}
