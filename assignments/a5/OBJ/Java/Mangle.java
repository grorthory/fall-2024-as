//Mangle:top//
//Mangle:import//
import java.util.*;

// <mangle> **= RANGLE <exp> LPAREN <rands> RPAREN
public class Mangle /*Mangle:class*/ {

    public static final String $className = "Mangle";
    public static final String $ruleString =
        "<mangle> **= RANGLE <exp> LPAREN <rands> RPAREN";

    public List<Exp> expList;
    public List<Rands> randsList;

    public Mangle(List<Exp> expList, List<Rands> randsList) {
//Mangle:init//
        this.expList = expList;
        this.randsList = randsList;
    }

    public static Mangle parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<mangle>", scn$.lno);
        List<Exp> expList = new ArrayList<Exp>();
        List<Rands> randsList = new ArrayList<Rands>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Match match$ = t$.match;
            switch(match$) {
            case RANGLE:
                scn$.match(Token.Match.RANGLE, trace$);
                expList.add(Exp.parse(scn$, trace$));
                scn$.match(Token.Match.LPAREN, trace$);
                randsList.add(Rands.parse(scn$, trace$));
                scn$.match(Token.Match.RPAREN, trace$);
                continue;
            default:
                return new Mangle(expList, randsList);
            }
        }

    }

    public Val eval(Val v, Env env) {
        Iterator<Exp> expIter = expList.iterator();
        Iterator<Rands> randsIter = randsList.iterator();
        while (expIter.hasNext()) {
            // expIter.next() ProcExp to apply
            // randsIter.next() are the method rands -- evaluated in env
            // v.env() is the environment in which to build the ProcVal
            Val p = expIter.next().eval(v.env());
            List<Val> valList = randsIter.next().evalRands(env);
            v = p.apply(valList);
        }
        return v;
    }

//Mangle//
}
