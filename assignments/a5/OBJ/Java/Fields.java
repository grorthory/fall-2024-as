//Fields:top//
//Fields:import//
import java.util.*;

// <fields> **= FIELD <VAR>
public class Fields /*Fields:class*/ {

    public static final String $className = "Fields";
    public static final String $ruleString =
        "<fields> **= FIELD <VAR>";

    public List<Token> varList;

    public Fields(List<Token> varList) {
        Env.checkDuplicates(varList,
                            new String[] {"super", "self", "this"},
                            " in field variables");
//Fields:init//
        this.varList = varList;
    }

    public static Fields parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<fields>", scn$.lno);
        List<Token> varList = new ArrayList<Token>();
        while (true) {
            Token t$ = scn$.cur();
            Token.Match match$ = t$.match;
            switch(match$) {
            case FIELD:
                scn$.match(Token.Match.FIELD, trace$);
                varList.add(scn$.match(Token.Match.VAR, trace$));
                continue;
            default:
                return new Fields(varList);
            }
        }

    }

    public void addFieldBindings(Bindings fieldBindings) {
        for (Token t: varList) {
            String s = t.toString();
            fieldBindings.add(s, new ValRef(Val.nil));
        }
    }

//Fields//
}
