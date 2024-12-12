//Program:top//
//Program:import//
import java.util.*;

public abstract class Program extends _Start /*Program:class*/ {

    public static final String $className = "Program";
    public static Program parse(Scan scn$, Trace trace$) {
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
            return Eval.parse(scn$,trace$);
        case DEFINE:
            return Define.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Program cannot begin with " + t$.errString()
            );
        }
    }

    public static Env initEnv = Env.initEnv();
    // public void $ok() { }

//Program//
}
