//Ext0:top//
//Ext0:import//
import java.util.*;

// <ext>:Ext0 ::= 
public class Ext0 extends Ext /*Ext0:class*/ {

    public static final String $className = "Ext0";
    public static final String $ruleString =
        "<ext>:Ext0 ::= ";



    public Ext0() {
//Ext0:init//

    }

    public static Ext0 parse(Scan scn$, Trace trace$) {
        if (trace$ != null)
            trace$ = trace$.nonterm("<ext>:Ext0", scn$.lno);
        return new Ext0();
    }

    public ClassVal toClassVal(Env env) {
        return EnvClass.envClass; // a singleton
    }

//Ext0//
}
