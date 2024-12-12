//Exp:top//
//Exp:import//
import java.util.*;

public abstract class Exp /*Exp:class*/ {

    public static final String $className = "Exp";
    public static Exp parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case LBRACE:
            return SeqExp.parse(scn$,trace$);
        case ATAT:
            return AtAtExp.parse(scn$,trace$);
        case LLANGLE:
            return EenvExp.parse(scn$,trace$);
        case LETREC:
            return LetrecExp.parse(scn$,trace$);
        case STRNG:
            return StrngExp.parse(scn$,trace$);
        case LET:
            return LetExp.parse(scn$,trace$);
        case AT:
            return AtExp.parse(scn$,trace$);
        case CHR:
            return ChrExp.parse(scn$,trace$);
        case DISPLAY1:
            return Display1Exp.parse(scn$,trace$);
        case NIL:
            return NilExp.parse(scn$,trace$);
        case EQP:
        case ADDFIRSTOP:
        case CLASSP:
        case NEP:
        case LISTP:
        case DIVOP:
        case SUBOP:
        case SUB1OP:
        case MULOP:
        case OBJECTP:
        case GTP:
        case LENOP:
        case ADD1OP:
        case LEP:
        case RESTOP:
        case ZEROP:
        case ADDOP:
        case FIRSTOP:
        case LTP:
        case GEP:
            return PrimappExp.parse(scn$,trace$);
        case PERROR:
            return PerrorExp.parse(scn$,trace$);
        case EXIT:
            return ExitExp.parse(scn$,trace$);
        case VAR:
            return VarExp.parse(scn$,trace$);
        case CLASS:
            return ClassExp.parse(scn$,trace$);
        case NEW:
            return NewExp.parse(scn$,trace$);
        case BANGAT:
            return BangAtExp.parse(scn$,trace$);
        case ERROR:
            return ErrorExp.parse(scn$,trace$);
        case DISPLAY:
            return DisplayExp.parse(scn$,trace$);
        case PROC:
            return ProcExp.parse(scn$,trace$);
        case LBRACK:
            return ListExp.parse(scn$,trace$);
        case DOT:
            return AppExp.parse(scn$,trace$);
        case PUTC:
            return PutcExp.parse(scn$,trace$);
        case NEWLINE:
            return NewlineExp.parse(scn$,trace$);
        case SET:
            return SetExp.parse(scn$,trace$);
        case LANGLE:
            return EnvExp.parse(scn$,trace$);
        case IF:
            return IfExp.parse(scn$,trace$);
        case LIT:
            return LitExp.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Exp cannot begin with " + t$.errString()
            );
        }
    }

    public abstract Val eval(Env env);

//Exp//
}
