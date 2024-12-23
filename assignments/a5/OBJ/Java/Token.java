import java.util.*;
import java.util.regex.*;

// Token class with match patterns (used with the built-in Scan class)
public class Token {

    // patternFail is set to an error message string
    // if there are pattern compile errors
    public static String patternFail = null; //
    public static final Match $eof = Match.$EOF;

    public enum TokType {
        TOKEN,
        SKIP,
        LINE_TOGGLE,
        SPECIAL;
    }

    public enum Match {
        WHITESPACE ("\\s+", TokType.SKIP),
        COMMENT ("%.*", TokType.SKIP),
        LIT ("\\d+"),
        LPAREN ("\\("),
        RPAREN ("\\)"),
        COMMA (","),
        ADDOP ("\\+"),
        SUBOP ("\\-"),
        MULOP ("\\*"),
        DIVOP ("/"),
        ADD1OP ("add1"),
        SUB1OP ("sub1"),
        ZEROP ("zero\\?"),
        LTP ("<\\?"),
        LEP ("<=\\?"),
        GTP (">\\?"),
        GEP (">=\\?"),
        NEP ("<>\\?"),
        EQP ("=\\?"),
        LENOP ("len"),
        LISTP ("list\\?"),
        OBJECTP ("object\\?"),
        CLASSP ("class\\?"),
        FIRSTOP ("first"),
        RESTOP ("rest"),
        ADDFIRSTOP ("addFirst"),
        IF ("if"),
        THEN ("then"),
        ELSE ("else"),
        LET ("let"),
        LETREC ("letrec"),
        DEFINE ("define"),
        IN ("in"),
        EQUALS ("="),
        EXIT ("exit"),
        PROC ("proc"),
        SET ("set"),
        CLASS ("class"),
        EXTENDS ("extends"),
        STATIC ("static"),
        FIELD ("field"),
        METHOD ("method"),
        END ("end"),
        EVAL ("eval"),
        NEW ("new"),
        NIL ("nil"),
        DISPLAY ("display"),
        DISPLAY1 ("display#"),
        NEWLINE ("newline"),
        PUTC ("putc"),
        ERROR ("error"),
        PERROR ("perror"),
        AT ("@"),
        ATAT ("@@"),
        DOT ("\\."),
        LBRACE ("\\{"),
        RBRACE ("\\}"),
        LBRACK ("\\["),
        RBRACK ("\\]"),
        LANGLE ("<"),
        RANGLE (">"),
        LLANGLE ("!<"),
        RRANGLE ("!>"),
        BANGAT ("!@"),
        SEMI (";"),
        CHR ("'."),
        STRNG ("\\\"(\\\\.|[^\\\"\\\\])*\\\""),
        VAR ("[A-Za-z\\&\\?\\$][\\w\\?\\&\\$]*"),
        $ERROR (null),
        $EOF (null),
        $LINE (null);

        public String pattern;
        public TokType tokType;
        public Pattern cPattern = null; // compiled pattern

        // a SPECIAL token type or a TOKEN/LINE_TOGGLE
        Match(String pattern) {
            this(pattern, null);
        } 

        // legacy ??
        Match(String pattern, boolean skip) {
            this(pattern, TokType.SKIP);
        }

        Match(String pattern, TokType tokType) {
            if (pattern != null) {
                if (tokType == TokType.SKIP) {
                    this.tokType = TokType.SKIP;
                } else if (pattern.length() >= 2 &&
                           pattern.substring(0,2).equals("^^")) {
                    pattern = pattern.substring(1);
                    this.tokType = TokType.LINE_TOGGLE;
                } else {
                    this.tokType = TokType.TOKEN;
                }
                this.pattern = pattern;
                try {
                    this.cPattern = Pattern.compile(pattern, Pattern.DOTALL);
                } catch (PatternSyntaxException e) {
                    if (patternFail == null) {
                        patternFail = "Lexical specification errors() for";
                    }
                    patternFail += (" " +this);
                    this.cPattern = null;
                }
            } else {
                this.tokType = TokType.SPECIAL; // SPECIAL
            }
        }

        // Use this to force loading Match class to compile patterns.
        public static String init() {
            return patternFail; // returns null if no errors
        }
    }

    public Match match;      // token match
    public String str;       // this token's lexeme
    public int lno;          // the line number where this token was found
    public String line;      // the text line where this token appears

    public Token() {
        match = null;
        str = null;
        lno = 0;
        line = null;
    }

    public Token(Match match, String str, int lno, String line) {
        this.match = match;
        this.str = str;
        this.lno = lno;
        this.line = line;
    }

    public Token(Match match, String str) {
        this(match, str, 0, null);
    }

    public String toString() {
        return str;
    }

    public String errString() {
        switch(match) {
        case $EOF:
        case $ERROR:
            return str;
        default:
            return match.toString(); // just the match name
        }
    }

    public boolean isEOF() {
        return this.match == $eof;
    }

    public static void main(String [] args) {
        String msg = Match.init();
        if (msg != null) {
            System.out.println(msg);
            System.exit(1);
        }
        for (Match match: Match.values()) {
            if (match.tokType == TokType.SPECIAL) {
                System.out.println(
                    String.format("special "+match.toString())
                );
                continue; // not a real token
            }
            String what = "??";
            switch(match.tokType) {
                case SKIP:
                    what = "skip";
                    break;
                case TOKEN:
                    what = "token";
                    break;
                case LINE_TOGGLE:
                    what = "token (line toggle)";
                    break;
            }
            System.out.println(
                String.format("%s %s '%s'",what,match.toString(),match.pattern)
            );
        }
    }

//Token//

}
