import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.util.ArrayList;

public class Driver {
    public static void main (String[] args) throws Exception{
        String fileName = "C:\\Users\\Ryan Brand\\Documents\\S2018\\CSCI468\\CompilerProject\\src\\main\\java\\parse_file.txt";
        CharStream input = new ANTLRFileStream(fileName);

        Little littleLexer = new Little(input);
        CommonTokenStream commonTokenStream = new CommonTokenStream(littleLexer);
        commonTokenStream.fill();
        for (String name:
             littleLexer.getRuleNames()) {
            System.out.println(name);
        }

        System.out.println();

        // This loop implementation for extracting rule and value adapted from
        // https://www.programcreek.com/java-api-examples/index.php?api=org.antlr.v4.runtime.CommonTokenStream
        for (Token token : commonTokenStream.getTokens()) {
            CommonToken ct = (CommonToken) token;
            String[] tokenNames = littleLexer.getTokenNames();
            int type = ct.getType();
            String tokenName = type > 0 ? tokenNames[type] : "EOF";
            System.out.println("LEXER: " + tokenName);
            System.out.println("VALUE: " + ct.getText());
        }
    }
}
