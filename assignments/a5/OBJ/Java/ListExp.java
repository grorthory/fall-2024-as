//ListExp:top//
//ListExp:import//
import java.util.*;

// <exp>:ListExp ::= LBRACK <rands> RBRACK
public class ListExp extends Exp /*ListExp:class*/ {

    public static final String $className = "ListExp";
    public static final String $ruleString =
        "<exp>:ListExp ::= LBRACK <rands> RBRACK";

    public Rands rands;

    public ListExp(Rands rands) {
//ListExp:init//
        this.rands = rands;
    }

    public static ListExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ListExp", scn$.lno);
        scn$.match(Token.Match.LBRACK, trace$);
        Rands rands = Rands.parse(scn$, trace$);
        scn$.match(Token.Match.RBRACK, trace$);
        return new ListExp(rands);
    }

    public Val eval(Env env) {
        List<Val> valList = rands.evalRands(env);
        ListVal listVal = Val.listNull;
        int n = valList.size();
        // process the elements in reverse order
        while (n > 0)
            listVal = new ListNode(valList.get(--n), listVal);
        return listVal;
    }
    
    public String toString() {
        return " ...ListExp... ";
    }

//ListExp//
}
