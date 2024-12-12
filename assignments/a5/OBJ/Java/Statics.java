//Statics:top//
//Statics:import//
import java.util.*;

// <statics> **= STATIC <VAR> EQUALS <exp>
public class Statics /*Statics:class*/ {

    public static final String $className = "Statics";
    public static final String $ruleString =
        "<statics> **= STATIC <VAR> EQUALS <exp>";

    public List<Token> varList;
    public List<Exp> expList;

    public Statics(List<Token> varList, List<Exp> expList) {
        Env.checkDuplicates(varList,
                            new String[] {"myclass", "superclass"},
                            " in static variables");
//Statics:init//
        this.varList = varList;
        this.expList = expList;
    }

    public static Statics parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<statics>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<Exp> expList = new ArrayList<Exp>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Match match$ = t$.match;
            switch(match$) {
            case STATIC:
                scn$.match(Token.Match.STATIC, trace$);
                varList.add(scn$.match(Token.Match.VAR, trace$));
                scn$.match(Token.Match.EQUALS, trace$);
                expList.add(Exp.parse(scn$, trace$));
                continue;
            default:
                return new Statics(varList, expList);
            }
        }

    }

    // Add new bindings to the static bindings -- behaves like top-level
    // defines.
    public void addStaticBindings(Env env) {
        Iterator<Token> varIter = varList.iterator(); // LHS identifiers
        Iterator<Exp> expIter = expList.iterator();    // RHS expressions
        while(varIter.hasNext()) {
            Token var = varIter.next();
            String id = var.toString(); // the LHS identifier
            Exp exp = expIter.next();    // the RHS expression
            Val val = exp.eval(env);
            Ref ref = new ValRef(val);
            env.add(new Binding(id, ref));
        }
    }

//Statics//
}
