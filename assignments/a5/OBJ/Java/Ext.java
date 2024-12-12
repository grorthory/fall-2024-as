//Ext:top//
//Ext:import//
import java.util.*;

public abstract class Ext /*Ext:class*/ {

    public static final String $className = "Ext";
    public static Ext parse(Scan scn$, Trace trace$) {
        Token t$ = scn$.cur();
        Token.Match match$ = t$.match;
        switch(match$) {
        case METHOD:
        case FIELD:
        case STATIC:
        case END:
            return Ext0.parse(scn$,trace$);
        case EXTENDS:
            return Ext1.parse(scn$,trace$);
        default:
            throw new PLCCException(
                "Parse error",
                "Ext cannot begin with " + t$.errString()
            );
        }
    }

    public abstract ClassVal toClassVal(Env env);

//Ext//
}
