//NewlineExp:top//
//NewlineExp:import//
import java.util.*;

// <exp>:NewlineExp ::= NEWLINE
public class NewlineExp extends Exp /*NewlineExp:class*/ {

    public static final String $className = "NewlineExp";
    public static final String $ruleString =
        "<exp>:NewlineExp ::= NEWLINE";



    public NewlineExp() {
//NewlineExp:init//

    }

    public static NewlineExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:NewlineExp", scn$.lno);
        scn$.match(Token.Match.NEWLINE, trace$);
        return new NewlineExp();
    }

    public Val eval(Env env) {
        System.out.println();
        return Val.nil;
    }

//NewlineExp//
}
