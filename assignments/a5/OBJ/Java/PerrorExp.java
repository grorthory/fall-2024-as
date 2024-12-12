//PerrorExp:top//
//PerrorExp:import//
import java.util.*;

// <exp>:PerrorExp ::= PERROR <STRNG>
public class PerrorExp extends Exp /*PerrorExp:class*/ {

    public static final String $className = "PerrorExp";
    public static final String $ruleString =
        "<exp>:PerrorExp ::= PERROR <STRNG>";

    public Token strng;

    public PerrorExp(Token strng) {
//PerrorExp:init//
        this.strng = strng;
    }

    public static PerrorExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:PerrorExp", scn$.lno);
        scn$.match(Token.Match.PERROR, trace$);
        Token strng = scn$.match(Token.Match.STRNG, trace$);
        return new PerrorExp(strng);
    }

    public Val eval(Env env) {
        String str = strng.toString();
        int len = str.length();
        str = str.substring(1,len-1);
        throw new PLCCException(str);
    }

//PerrorExp//
}
