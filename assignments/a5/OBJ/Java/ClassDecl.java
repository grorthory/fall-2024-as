//ClassDecl:top//
//ClassDecl:import//
import java.util.*;

// <classDecl> ::= CLASS <ext> <statics> <fields> <methods> END
public class ClassDecl /*ClassDecl:class*/ {

    public static final String $className = "ClassDecl";
    public static final String $ruleString =
        "<classDecl> ::= CLASS <ext> <statics> <fields> <methods> END";

    public Ext ext;
    public Statics statics;
    public Fields fields;
    public Methods methods;

    public ClassDecl(Ext ext, Statics statics, Fields fields, Methods methods) {
//ClassDecl:init//
        this.ext = ext;
        this.statics = statics;
        this.fields = fields;
        this.methods = methods;
    }

    public static ClassDecl parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<classDecl>", scn$.lno);
        scn$.match(Token.Match.CLASS, trace$);
        Ext ext = Ext.parse(scn$, trace$);
        Statics statics = Statics.parse(scn$, trace$);
        Fields fields = Fields.parse(scn$, trace$);
        Methods methods = Methods.parse(scn$, trace$);
        scn$.match(Token.Match.END, trace$);
        return new ClassDecl(ext, statics, fields, methods);
    }

    public Val eval(Env env) {
        ClassVal superClass = ext.toClassVal(env);
        return new StdClass(env, superClass, statics, fields, methods);
    }

//ClassDecl//
}
