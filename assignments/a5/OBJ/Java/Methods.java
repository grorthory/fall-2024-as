//Methods:top//
//Methods:import//
import java.util.*;

// <methods> **= METHOD <VAR> EQUALS <proc>
public class Methods /*Methods:class*/ {

    public static final String $className = "Methods";
    public static final String $ruleString =
        "<methods> **= METHOD <VAR> EQUALS <proc>";

    public List<Token> varList;
    public List<Proc> procList;

    public Methods(List<Token> varList, List<Proc> procList) {
        Env.checkDuplicates(varList, " in method names");
//Methods:init//
        this.varList = varList;
        this.procList = procList;
    }

    public static Methods parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<methods>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        List<Proc> procList = new ArrayList<Proc>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Match match$ = t$.match;
            switch(match$) {
            case METHOD:
                scn$.match(Token.Match.METHOD, trace$);
                varList.add(scn$.match(Token.Match.VAR, trace$));
                scn$.match(Token.Match.EQUALS, trace$);
                procList.add(Proc.parse(scn$, trace$));
                continue;
            default:
                return new Methods(varList, procList);
            }
        }

    }

    public Env addMethodBindings(Env env) {
        if (varList.size() == 0)
            return env;
        List<Exp> expList = new ArrayList<Exp>();
        for (Proc p: procList)
            expList.add(new ProcExp(p));
        return new LetDecls(varList, expList).addLetrecBindings(env);
    }

//Methods//
}
