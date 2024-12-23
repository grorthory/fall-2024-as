import java.util.*;

public abstract class Env {

    public static final Env empty = new EnvNull();

    public static void checkDuplicates(List<Token> varList,
                                       String [] initVars,
                                       String msg) {
        // throws an exeption if the varList has duplicate vars
        Set<String> varSet =
            new HashSet<String>(2*(varList.size()+3));
        if (initVars != null)
            // predefined vars
            for (String str: initVars)
                varSet.add(str);
        for (Token var: varList) {
            String str = var.toString();
            if (varSet.contains(str)) {
                msg = "duplicate ID " + str + msg;
                throw new PLCCException("Semantic error",  msg);
            }
            varSet.add(str);
        }
    }

    public static void checkDuplicates(List<Token> varList, String msg) {
        checkDuplicates(varList, null, msg);
    }

    public static void checkDuplicates(List<Token> varList) {
        checkDuplicates(varList, "");
    }

    public static Env initEnv() {
        // initial environment with no bindings
        return new EnvNode(new Bindings(), empty);
    }

    public abstract Binding lookup(String sym); // only local bindings

    public abstract Ref applyEnvRef(String sym);

    public Ref applyEnvRef(Token tok) {
        return applyEnvRef(tok.toString());
    }

    public Val applyEnv(String sym) {
        return applyEnvRef(sym).deRef();
    }

    public Val applyEnv(Token tok) {
        return applyEnv(tok.toString());
    }

    public Env extendEnvRef(Bindings bindings) {
        return new EnvNode(bindings, this);
    }

    public abstract Env add(Binding b);

}