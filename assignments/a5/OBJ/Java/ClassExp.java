//ClassExp:top//
//ClassExp:import//
import java.util.*;

// <exp>:ClassExp ::= <classDecl>
public class ClassExp extends Exp /*ClassExp:class*/ {

    public static final String $className = "ClassExp";
    public static final String $ruleString =
        "<exp>:ClassExp ::= <classDecl>";

    public ClassDecl classDecl;

    public ClassExp(ClassDecl classDecl) {
//ClassExp:init//
        this.classDecl = classDecl;
    }

    public static ClassExp parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<exp>:ClassExp", scn$.lno);
        ClassDecl classDecl = ClassDecl.parse(scn$, trace$);
        return new ClassExp(classDecl);
    }

    public Val eval(Env env) {
        return classDecl.eval(env);
    }

//ClassExp//
}
