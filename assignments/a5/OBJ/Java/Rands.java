//Rands:top//
//Rands:import//
import java.util.*;

// <rands> **= <exp> +COMMA
public class Rands /*Rands:class*/ {

    public static final String $className = "Rands";
    public static final String $ruleString =
        "<rands> **= <exp> +COMMA";

    public List<Exp> expList;

    public Rands(List<Exp> expList) {
//Rands:init//
        this.expList = expList;
    }

    public static Rands parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<rands>", scn$.lno);
        List<Exp> expList = new ArrayList<Exp>();
        // first trip through the parse
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case EQP:
        case ADDFIRSTOP:
        case LISTP:
        case DIVOP:
        case IF:
        case SUBOP:
        case BANGAT:
        case CHR:
        case LIT:
        case MULOP:
        case DOT:
        case OBJECTP:
        case LENOP:
        case LBRACK:
        case ADDOP:
        case DISPLAY1:
        case LANGLE:
        case CLASSP:
        case LET:
        case ERROR:
        case NEP:
        case PROC:
        case LBRACE:
        case PERROR:
        case CLASS:
        case AT:
        case NEWLINE:
        case NIL:
        case LLANGLE:
        case EXIT:
        case VAR:
        case PUTC:
        case SUB1OP:
        case ATAT:
        case LETREC:
        case DISPLAY:
        case GTP:
        case ADD1OP:
        case SET:
        case NEW:
        case LEP:
        case RESTOP:
        case ZEROP:
        case STRNG:
        case FIRSTOP:
        case LTP:
        case GEP:
            while(true) {
                expList.add(Exp.parse(scn$, trace$));
                t$ = scn$.cur();
                match$ = t$.match;
                if (match$ != Token.Match.COMMA)
                    break; // not a separator, so we're done
                scn$.match(match$, trace$);
            }
        } // end of switch
        return new Rands(expList);

    }

    public String toString() {
        String s = "";   // the string to return
        String sep = ""; // no separator for the first expression
        // get all of the expressions in the expression list
        for (Exp e : expList) {
            s += sep + e;
            sep = ",";   // commas separate the rest of the expressions
        }
        return s;
    }
    
    public List<Val> evalRands(Env env) {
        List<Val> valList = new ArrayList<Val>(expList.size());
        for (Exp e : expList)
            valList.add(e.eval(env));
        return valList;
    }

//Rands//
}
