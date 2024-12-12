//Loc:top//
//Loc:import//
import java.util.*;

public abstract class Loc /*Loc:class*/ {

    public static final String $className = "Loc";
    public static Loc parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case VAR:
            return SimpleLoc.parse(scn$,trace$);
        case LANGLE:
            return ObjLoc.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Loc cannot begin with " + t$.errString()
            );
        }
    }

    public abstract Env getEnv(Env env);

//Loc//
}
