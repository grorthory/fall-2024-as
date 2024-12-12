//ChrExp:top//
//ChrExp:import//
import java.util.*;

// <exp>:ChrExp ::= <CHR>
public class ChrExp extends Exp /*ChrExp:class*/ {

    public static final String $className = "ChrExp";
    public static final String $ruleString =
        "<exp>:ChrExp ::= <CHR>";

    public Token chr;

    public ChrExp(Token chr) {
//ChrExp:init//
        this.chr = chr;
    }

    public static ChrExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ChrExp", scn$.lno);
        Token chr = scn$.match(Token.Match.CHR, trace$);
        return new ChrExp(chr);
    }

    public Val eval(Env env) {
        return new IntVal(chr.toString().charAt(1));
    }
    
    public String toString() {
        return chr.toString();
    }

//ChrExp//
}
