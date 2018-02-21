import org.antlr.v4.runtime.*;

public class LexerService {

    private Lexer littleLexer = null;
    private CommonTokenStream commonTokenStream = null;

    public LexerService(CharStream input) {
        littleLexer = new LittleLexer(input);
        commonTokenStream = new CommonTokenStream(littleLexer);
    }

    public void fillStream() {
        commonTokenStream.fill();
    }

    public void printTokens() {
        // This loop implementation for extracting rule and value adapted from
        // https://www.programcreek.com/java-api-examples/index.php?api=org.antlr.v4.runtime.CommonTokenStream
        String[] tokenNames = littleLexer.getRuleNames();
        for (Token token : commonTokenStream.getTokens()) {
            CommonToken ct = (CommonToken) token;
            int type = ct.getType() - 1;
            //EOF
            if (type < 0) {
                break;
            }
            String tokenName = tokenNames[type];
            System.out.println("Token Type: " + tokenName);
            System.out.println("Value: " + ct.getText());
        }
    }

    public Lexer getLittleLexer() {
        return littleLexer;
    }

    public CommonTokenStream getCommonTokenStream() {
        return commonTokenStream;
    }
}
