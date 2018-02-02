import org.antlr.v4.runtime.*;

public class Driver {
    public static void main (String[] args) throws Exception{
        String fileName = "C:\\Users\\Ryan Brand\\Documents\\S2018\\CSCI468\\CompilerProject\\src\\main\\java\\parse_file.txt";
        CharStream input = CharStreams.fromFileName(fileName);

        Little littleLexer = new Little(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(littleLexer);
        commonTokenStream.fill();

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
}
