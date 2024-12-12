//PutcExp:top//
//PutcExp:import//
import java.util.*;

// <exp>:PutcExp ::= PUTC <exp>
public class PutcExp extends Exp /*PutcExp:class*/ {

    public static final String $className = "PutcExp";
    public static final String $ruleString =
        "<exp>:PutcExp ::= PUTC <exp>";

    public Exp exp;

    public PutcExp(Exp exp) {
//PutcExp:init//
        this.exp = exp;
    }

    public static PutcExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:PutcExp", scn$.lno);
        scn$.match(Token.Match.PUTC, trace$);
        Exp exp = Exp.parse(scn$, trace$);
        return new PutcExp(exp);
    }

    public Val eval(Env env) {
        Val v = exp.eval(env);
        System.out.print(v.putc());
        return Val.nil;
    }

//PutcExp//
}
