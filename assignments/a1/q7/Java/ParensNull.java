//ParensNull:top//
//ParensNull:import//
import java.util.*;

// <parens>ParensNull ::= 
public class ParensNull extends Parens /*ParensNull:class*/ {

    public static final String $className = "ParensNull";
    public static final String $ruleString =
        "<parens>ParensNull ::= ";



    public ParensNull() {
//ParensNull:init//

    }

    public static ParensNull parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<parens>ParensNull", scn$.lno);
        return new ParensNull();
    }

//ParensNull//
}
